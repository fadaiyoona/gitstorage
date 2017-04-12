package net.dfrz.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.dfrz.db.DBUtil;
import net.dfrz.domain.User;
import net.dfrz.model.UserDao;

public class UserImpl implements UserDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	User user;

	@Override
	public void login(User user) {
		conn = DBUtil.getConnection();
		String sql = "update loanuser " + "set islogin = 1"
				+ "where logname = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getLogName());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void exit() {
		conn = DBUtil.getConnection();
		String sql = "update loanuser set islogin=0 where islogin=1";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User whoLogining() {
		conn = DBUtil.getConnection();
		String sql = "select * from loanuser where islogin=1";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setEmpName(rs.getString("empName"));
				user.setLogName(rs.getString("logName"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, pstmt);
		}

		return user;
	}

	@Override
	public List<User> quaryUser(String loginName, String password) {
		conn = DBUtil.getConnection();
		List<User> users = new ArrayList<User>();
		String sql = "select * FROM loanuser where LogName=? and Password=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setLogName(rs.getString("logname"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, pstmt);
		}
		return users;

	}

	@Override
	public List<User> quaryUser(String loginName) {
		conn = DBUtil.getConnection();
		List<User> users = new ArrayList<User>();
		String sql = "select * FROM loanuser where LogName=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, pstmt);
		}
		return users;

	}

	@Override
	public void addUser(User user) {
		conn = DBUtil.getConnection();
		String sql = "" + "insert into loanuser"
				+ "(EmpName,LogName,Phone,Password,Type,islogin)"
				+ "values(?,?,?,?,?,?)";
		PreparedStatement ptmt = null;

		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, user.getEmpName());
			ptmt.setString(2, user.getLogName());
			ptmt.setString(3, user.getPhone());
			ptmt.setString(4, user.getPassword());
			ptmt.setString(5, user.getType());
			ptmt.setString(6, "0");
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, null, ptmt);
		}

	}

	@Override
	public List<User> quaryGovernors(String loginName) {
		conn = DBUtil.getConnection();
		List<User> users = new ArrayList<User>();
		String sql = "select * FROM loanuser where LogName=? and type = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginName);
			pstmt.setString(2, "1");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, pstmt);
		}
		return users;

	}

	@Override
	public List<User> quaryRounders(String logName) {
		conn = DBUtil.getConnection();
		List<User> users = new ArrayList<User>();
		String sql = "select * FROM loanuser where LogName=? and type = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, logName);
			pstmt.setString(2, "4");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.relase(conn, rs, pstmt);
		}
		return users;

	}

}
