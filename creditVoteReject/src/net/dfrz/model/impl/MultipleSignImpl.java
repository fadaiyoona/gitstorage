package net.dfrz.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.dfrz.db.DBUtil;
import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.State;
import net.dfrz.domain.User;
import net.dfrz.model.MultipleSignDao;
import net.dfrz.view.MainMenu;

public class MultipleSignImpl implements MultipleSignDao {
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	MeetDetail meetDetail = null;

	@Override
	public boolean queryState() {
		conn = DBUtil.getConnection();
		String sql = "select state from state";

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt("state") == 1) {
					return true;
				}
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}
		return false;

	}

	@Override
	public void updateMultipleSign(String id, String judge, User onlineUser) {
		conn = DBUtil.getConnection();
		String sqlmeet = null;
		String sqlmeetdetail = null;
		StringBuffer governor = new StringBuffer();
		String governors = getGovernor(id);

		if (judge.equals("通过")) {
			if (governors == null) {
				sqlmeetdetail = "update meetdetail set governor=? where id=?";
				governor.append(onlineUser.getLogName());
			} else if ((governors.split(",").length + 1) == this
					.getSignByTheGovernor().split(",").length) {
				sqlmeet = "" + "update meet set state='通过' where id=?";
				sqlmeetdetail = "update meetdetail set governor=? where id=?";
				governor.append(governors);
				governor.append(",");
				governor.append(onlineUser.getLogName());
				try {
					ptmt = conn.prepareStatement(sqlmeet);
					ptmt.setString(1, id);
					ptmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				sqlmeetdetail = "update meetdetail set governor=? where id=?";
				governor.append(governors);
				governor.append(",");
				governor.append(onlineUser.getLogName());
			}

			try {
				ptmt = conn.prepareStatement(sqlmeetdetail);
				ptmt.setString(1, governor.toString());
				ptmt.setString(2, id);
				ptmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.relase(conn, rs, ptmt);
			}

		} else if (judge.equals("否决")) {
			sqlmeet = "" + "update meet " + " " + " set state='否决' "
					+ " where id=?";
			sqlmeetdetail = "" + "update meetdetail " + " "
					+ " set governor=? " + " where id=?";
			if (governors == null) {
				governor.append(onlineUser.getLogName());
				governor.append("(否决)");
			} else {
				governor.append(governors);
				governor.append(",");
				governor.append(onlineUser.getLogName());
				governor.append("(否决)");
			}

			try {
				ptmt = conn.prepareStatement(sqlmeet);
				ptmt.setString(1, id);
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ptmt = conn.prepareStatement(sqlmeetdetail);
				ptmt.setString(1, governor.toString());
				ptmt.setString(2, id);
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.relase(conn, rs, ptmt);
			}
		} else if (judge.equals("重审")) {
			sqlmeet = "" + "update meet " + " " + " set state='重审' "
					+ " where id=?";
			sqlmeetdetail = "" + "update meetdetail " + " "
					+ " set governor=? " + " where id=?";
			governor.append(governors);
			governor.append(",");
			governor.append(onlineUser.getLogName());
			governor.append("(重审)");

			try {
				ptmt = conn.prepareStatement(sqlmeet);
				ptmt.setString(1, id);
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ptmt = conn.prepareStatement(sqlmeetdetail);
				ptmt.setString(1, governor.toString());
				ptmt.setString(2, id);
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.relase(conn, rs, ptmt);
			}
		}
	}

	@Override
	public String getSignByTheGovernor() {
		conn = DBUtil.getConnection();
		String sql = "select signedByTheGovernor from state";
		String governor = null;

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				governor = rs.getString("signedByTheGovernor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return governor;
	}

	@Override
	public void open(State state) {
		conn = DBUtil.getConnection();
		String sql = "update state set state=?,signedByTheGovernor=?";
		PreparedStatement ptmt = null;

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, state.getState());
			ptmt.setString(2, state.getSignedByTheGovernor());
			ptmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, null, ptmt);
		}
	}

	@Override
	public void close(State state) {
		conn = DBUtil.getConnection();
		String sql = "update state set state=?,signedByTheGovernor=?";
		PreparedStatement ptmt = null;

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, state.getState());
			ptmt.setString(2, state.getSignedByTheGovernor());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, null, ptmt);
		}
	}

	@Override
	public Map<Integer, MeetDetail> queryMultipleSignMeetDetails(User onlineUser) {
		int i = 1;
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();
		conn = DBUtil.getConnection();
		String sql = "select * from meetDetail,meet where meetDetail.id = meet.id "
				+ "and state in('提交','会签') ";

		try {
			ptmt = conn.prepareStatement(sql);
			// ptmt.setString(1, onlineUser.getLogName());F
			rs = ptmt.executeQuery();
			while (rs.next()) {
				meetDetail = new MeetDetail();
				meetDetail.setId(rs.getString("id"));
				meetDetail.setFrequency(rs.getInt("frequency"));
				meetDetail.setMeetYear(rs.getInt("meetyear"));
				meetDetail.setAddress(rs.getString("address"));
				meetDetail.setCompany(rs.getString("company"));
				meetDetail.setMoney(rs.getString("money"));
				meetDetail.setComTypeName(rs.getString("comtype"));
				meetDetail.setReason(rs.getString("reason"));
				if (rs.getString("governor") == null
						|| !rs.getString("governor").contains(
								MainMenu.onlineUser.getLogName()))
					meetDetails.put(i++, meetDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}
		return meetDetails;
	}

	public String getGovernor(String id) {
		String governor = null;
		conn = DBUtil.getConnection();
		String sql = "select governor from meetdetail where id=?";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, id);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				governor = rs.getString("governor");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return governor;
	}

}
