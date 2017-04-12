package net.dfrz.model.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.dfrz.db.DBUtil;
import net.dfrz.domain.MeetDetail;
import net.dfrz.domain.User;
import net.dfrz.model.MeetDetailDao;

public class MeetDetailImpl implements MeetDetailDao {
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	MeetDetail meetDetail = null;

	@Override
	public void add(MeetDetail meetDetail) {
		conn = DBUtil.getConnection();

		int frequency = maxFrequency();
		int meetYear = maxMeetYear();

		if (meetYear < Calendar.getInstance().get(Calendar.YEAR)) {
			frequency = 0;
			meetYear++;
		} else {
			frequency++;
		}

		String sql = "" + "insert into meetDetail"
				+ "(meetyear,address,company,money,comtype,reason,frequency)"
				+ "values(?,?,?,?,?,?,?)";

		try {
			ptmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptmt.setInt(1, meetYear);
			ptmt.setString(2,
					meetDetail.getAddressName(meetDetail.getAddress()));
			ptmt.setString(3, meetDetail.getCompany());
			ptmt.setString(4, meetDetail.getMoney());
			ptmt.setString(5, meetDetail.getComTypeName());
			ptmt.setString(6, meetDetail.getReason());
			ptmt.setInt(7, frequency);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, null, ptmt);
		}
	}

	// 获取最大的年
	private int maxMeetYear() {
		conn = DBUtil.getConnection();
		String maxMeetYear = "select max(meetyear) from meetdetail";
		int meetYear = -1;

		try {
			ptmt = conn.prepareStatement(maxMeetYear);
			rs = ptmt.executeQuery(maxMeetYear);
			while (rs.next()) {
				meetYear = rs.getInt("max(meetyear)");
			}
			return meetYear;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// 获取最大的次数
	private int maxFrequency() {
		conn = DBUtil.getConnection();
		String maxFrequency = "select max(frequency) from meetdetail";
		int frequency = -1;

		try {
			ptmt = conn.prepareStatement(maxFrequency);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				frequency = rs.getInt("max(frequency)");
			}
			return frequency;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frequency;
	}

	@Override
	public Map<Integer, MeetDetail> queryMeetDetailShenQian() {
		int i = 1;
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();
		conn = DBUtil.getConnection();
		String sql = "select * from meetDetail,meet where meetDetail.id = meet.id and state='提交'";

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery(sql);
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
				meetDetails.put(i++, meetDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}
		return meetDetails;
	}

	@Override
	public Map<Integer, MeetDetail> queryBackJudgeMeetDetail() {
		int i = 1;
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();
		conn = DBUtil.getConnection();
		String sql = "select * from meetDetail,meet where meetDetail.id = meet.id and state='重审'";

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery(sql);
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
				meetDetails.put(i++, meetDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}
		return meetDetails;
	}

	@Override
	public void updateMeetDetailMoney(String id, String money) {
		conn = DBUtil.getConnection();
		String sql = "" + "update meetDetail " + "set money = ?"
				+ "where id = ?";

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, money);
			ptmt.setString(2, id);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}

	}

	@Override
	public Map<Integer, MeetDetail> queryMeetDetail() {
		int i = 1;
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();
		conn = DBUtil.getConnection();
		String sql = "select * from meetDetail";

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery(sql);
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
				meetDetail.setGovernor(rs.getString("governor"));
				meetDetails.put(i++, meetDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}
		return meetDetails;
	}

	@Override
	public void write(Map<Integer, MeetDetail> meetDetails, File file) {
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		try {
			workbook = Workbook.createWorkbook(file);
			sheet = workbook.createSheet("meetDetailsInformation", 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Map.Entry<Integer, MeetDetail>> set = meetDetails.entrySet();
		MeetDetail meetDetail = null;
		Label meetYear = null;
		Label address = null;
		Label company = null;
		Label money = null;
		Label comType = null;
		Label reason = null;
		Label governor = null;
		int row = 1;

		meetYear = new Label(0, 0, "MeetYear");
		address = new Label(1, 0, "Address");
		company = new Label(2, 0, "Company");
		money = new Label(3, 0, "Money");
		comType = new Label(4, 0, "CompanyType");
		reason = new Label(5, 0, "Reason");
		governor = new Label(6, 0, "Governor");

		try {
			sheet.addCell(meetYear);
			sheet.addCell(address);
			sheet.addCell(company);
			sheet.addCell(money);
			sheet.addCell(comType);
			sheet.addCell(reason);
			sheet.addCell(governor);
		} catch (RowsExceededException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}

		for (Map.Entry<Integer, MeetDetail> it : set) {
			meetDetail = it.getValue();
			meetYear = new Label(0, row, meetDetail.getMeetYear() + "年第"
					+ meetDetail.getFrequency() + "次信贷审批会议");
			address = new Label(1, row, meetDetail.getAddress());
			company = new Label(2, row, meetDetail.getCompany());
			money = new Label(3, row, meetDetail.getMoney() + "万元");
			comType = new Label(4, row, meetDetail.getComTypeName());
			reason = new Label(5, row, meetDetail.getReason());
			governor = new Label(6, row, meetDetail.getGovernor());
			row++;

			try {
				sheet.addCell(meetYear);
				sheet.addCell(address);
				sheet.addCell(company);
				sheet.addCell(money);
				sheet.addCell(comType);
				sheet.addCell(reason);
				sheet.addCell(governor);
			} catch (RowsExceededException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
		}

		try {
			workbook.write();
			workbook.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<Integer, MeetDetail> queryMeetDetailByRounder(User onlineUser) {
		int i = 1;
		Map<Integer, MeetDetail> meetDetails = new HashMap<Integer, MeetDetail>();
		conn = DBUtil.getConnection();
		String sql = "select * from meetDetail,meet where meetDetail.id = meet.id and state in('通过','否决')";

		try {
			ptmt = conn.prepareStatement(sql);
			rs = ptmt.executeQuery(sql);
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
				if (rs.getString("rounder").contains(onlineUser.getLogName())) {
					meetDetails.put(i++, meetDetail);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, ptmt);
		}
		return meetDetails;
	}

}
