package net.dfrz.model.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.dfrz.db.DBUtil;
import net.dfrz.domain.Meet;
import net.dfrz.domain.MeetDetail;
import net.dfrz.model.MeetDao;

public class MeetImpl implements MeetDao {
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	MeetDetail meetDetail = null;

	@Override
	public void add(Meet meet) {
		conn = DBUtil.getConnection();
		String sql = "" + "insert into meet"
				+ "(meetyear,name,phone,setdate,state,rounder)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement ptmt = null;

		try {
			ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptmt.setString(1,
					String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			ptmt.setString(2, meet.getName());
			ptmt.setString(3, meet.getPhone());
			ptmt.setString(4, String.valueOf(new SimpleDateFormat("yyyyMMdd")
					.format(new Date())));
			ptmt.setString(5, meet.getState());
			ptmt.setString(6, meet.getRounder());
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, null, ptmt);
		}

	}

	@Override
	public void updateMeet(String id, String judge) {
		conn = DBUtil.getConnection();
		String sql = "" + "update meet " + "set state=? " + "where id=?";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, judge);
			ptmt.setString(2, id);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}

	}

	@Override
	public List<String> quarySetDate() {
		conn = DBUtil.getConnection();
		List<String> dates = new ArrayList<String>();
		String sql = "select setdate FROM meet";

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				dates.add(rs.getString("setdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}

		return dates;
	}

	@Override
	public Map<MeetDetail, Meet> quaryMeetDetail(String beginDate,
			String endDate) {
		conn = DBUtil.getConnection();
		Map<MeetDetail, Meet> meets = new HashMap<MeetDetail, Meet>();
		MeetDetail meetDetail = null;
		Meet meet = null;
		String sql = "select * " + "FROM meet,meetdetail "
				+ "where meet.id = meetdetail.id "
				+ "and to_number(setdate)>=? " + "and to_number(setdate)<=?"
				+ "and state in ('提交','重审','会签')";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, Integer.parseInt(beginDate));
			ptmt.setInt(2, Integer.parseInt(endDate));
			rs = ptmt.executeQuery();
			while (rs.next()) {
				meetDetail = new MeetDetail();
				meet = new Meet();

				meet.setName(rs.getString("name"));
				meet.setPhone(rs.getString("phone"));
				meet.setSetDate(rs.getString("setdate"));
				meet.setId(rs.getString("id"));
				meet.setState(rs.getString("state"));
				meet.setMeetYear(rs.getInt("meetyear"));
				meet.setRounder(rs.getString("rounder"));

				meetDetail.setMeetYear(rs.getInt("meetyear"));
				meetDetail.setFrequency(rs.getInt("frequency"));
				meetDetail.setId(rs.getString("id"));
				meetDetail.setAddress(rs.getString("address"));
				meetDetail.setCompany(rs.getString("company"));
				meetDetail.setMoney(rs.getString("money"));
				meetDetail.setComTypeName(rs.getString("comtype"));
				meetDetail.setReason(rs.getString("reason"));

				meets.put(meetDetail, meet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}

		return meets;
	}

	@Override
	public Map<MeetDetail, Meet> quaryMeetDetailHistory(String beginDate,
			String endDate) {
		conn = DBUtil.getConnection();
		Map<MeetDetail, Meet> meets = new HashMap<MeetDetail, Meet>();
		MeetDetail meetDetail = null;
		Meet meet = null;
		String sql = "select * " + "FROM meet,meetdetail "
				+ "where meet.id = meetdetail.id "
				+ "and to_number(setdate)>? " + "and to_number(setdate)<?"
				+ "and state in ('通过','否决')";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, Integer.parseInt(beginDate));
			ptmt.setInt(2, Integer.parseInt(endDate));
			rs = ptmt.executeQuery();
			while (rs.next()) {
				meetDetail = new MeetDetail();
				meet = new Meet();

				meet.setName(rs.getString("name"));
				meet.setPhone(rs.getString("phone"));
				meet.setSetDate(rs.getString("setdate"));
				meet.setId(rs.getString("id"));
				meet.setState(rs.getString("state"));
				meet.setMeetYear(rs.getInt("meetyear"));
				meet.setRounder(rs.getString("rounder"));

				meetDetail.setMeetYear(rs.getInt("meetyear"));
				meetDetail.setFrequency(rs.getInt("frequency"));
				meetDetail.setId(rs.getString("id"));
				meetDetail.setAddress(rs.getString("address"));
				meetDetail.setCompany(rs.getString("company"));
				meetDetail.setMoney(rs.getString("money"));
				meetDetail.setComTypeName(rs.getString("comtype"));
				meetDetail.setReason(rs.getString("reason"));

				meets.put(meetDetail, meet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}

		return meets;
	}

	@Override
	public void write(Map<MeetDetail, Meet> meets, String address) {
		StringBuffer sb = null;
		BufferedWriter bw = null;
		File file = null;
		Meet meet = null;

		try {
			file = new File(address);

			if (!file.exists())
				file.createNewFile();

			bw = new BufferedWriter(new FileWriter(file, true));

			Set<Map.Entry<MeetDetail, Meet>> set = meets.entrySet();
			for (Map.Entry<MeetDetail, Meet> me : set) {
				meetDetail = new MeetDetail();
				meet = new Meet();
				sb = new StringBuffer();
				meet = me.getValue();
				meetDetail = me.getKey();
				sb.append(meet.getName());
				sb.append(":");
				sb.append(meet.getPhone());
				sb.append(":");
				sb.append(meet.getSetDate());
				sb.append(":");
				sb.append(meetDetail.getMeetYear());
				sb.append("年第");
				sb.append(meetDetail.getFrequency());
				sb.append("次信贷审批会议:");
				sb.append(meetDetail.getAddress());
				sb.append(":");
				sb.append(meetDetail.getCompany());
				sb.append(":");
				sb.append(meetDetail.getMoney());
				sb.append(":");
				sb.append(meetDetail.getComTypeName());
				sb.append(":");
				sb.append(meetDetail.getReason());
				sb.append(":");
				sb.append(meet.getState());
				System.out.println(sb.toString());
				bw.write(sb.toString());
				bw.flush();
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
