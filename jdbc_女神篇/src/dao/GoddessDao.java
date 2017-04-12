package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Goddess;
import db.DBUtil;

public class GoddessDao {

	public void addGoddess(Goddess goddess) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into imooc_goddess"
				+ "(id,user_name,sex,age,birthday,email,mobile,"
				+ "create_user,create_date,update_user,update_date,isdel)"
				+ "values" + "(?,?,?,?,?,?,?,?,sysdate,?,sysdate,?)";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, goddess.getId());
		ptmt.setString(2, goddess.getUser_name());
		ptmt.setInt(3, goddess.getSex());
		ptmt.setInt(4, goddess.getAge());
		ptmt.setDate(5, null);
		ptmt.setString(6, goddess.getEmail());
		ptmt.setString(7, goddess.getMobile());
		ptmt.setString(8, goddess.getCreate_user());
		ptmt.setString(9, goddess.getUpdate_user());
		ptmt.setInt(10, goddess.getIsdel());

		ptmt.execute();

	}

	public void updateGoddess(Goddess goddess) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = " update imooc_goddess "
				+ " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "
				+ " update_user=?,update_date=sysdate,isdel=? "
				+ " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setString(1, goddess.getUser_name());
		ptmt.setInt(2, goddess.getSex());
		ptmt.setInt(3, goddess.getAge());
		ptmt.setDate(4, null);
		ptmt.setString(5, goddess.getEmail());
		ptmt.setString(6, goddess.getMobile());
		ptmt.setString(7, goddess.getUpdate_user());
		ptmt.setInt(8, goddess.getIsdel());
		ptmt.setInt(9, goddess.getId());

		ptmt.execute();

	}

	public void delGoddess(Integer id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = " delete from imooc_goddess " + " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);

		ptmt.execute();
	}

	public List<Goddess> query() throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select user_name,id,age from imooc_goddess");

		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while (rs.next()) {
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setId(rs.getInt("id"));
			g.setAge(rs.getInt("age"));
			gs.add(g);
		}
		return gs;
	}

	public List<Goddess> query(String name) throws Exception {
		List<Goddess> gs = new ArrayList<Goddess>();

		Connection conn = DBUtil.getConnection();
		// "select * from imooc_goddess where user_name=?"
		PreparedStatement ptmt = conn
				.prepareStatement("select * from imooc_goddess where user_name like ?");
		ptmt.setString(1, "%" + name + "%");

		ResultSet rs = ptmt.executeQuery();

		Goddess goddess = new Goddess();
		while (rs.next()) {
			goddess.setId(rs.getInt("id"));
			goddess.setUser_name(rs.getString("user_name"));
			goddess.setSex(rs.getInt("sex"));
			goddess.setAge(rs.getInt("age"));
			goddess.setBirthday(rs.getDate("birthday"));
			goddess.setEmail(rs.getString("email"));
			goddess.setMobile(rs.getString("mobile"));
			goddess.setCreate_date(rs.getDate("create_date"));
			goddess.setCreate_user(rs.getString("create_user"));
			goddess.setUpdate_date(rs.getDate("update_date"));
			goddess.setCreate_user(rs.getString("update_user"));
			goddess.setIsdel(rs.getInt("isdel"));

			gs.add(goddess);
		}
		return gs;
	}

	public List<Goddess> query(List<Map<String, Object>> params)
			throws Exception {
		List<Goddess> gs = new ArrayList<Goddess>();

		Connection conn = DBUtil.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess where 1=1 ");

		if (params != null && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map = params.get(i);
				sb.append(" and " + map.get("name") + " " + map.get("rela")
						+ " " + map.get("value"));
			}
		}

		PreparedStatement ptmt = conn.prepareStatement(sb.toString());

		ResultSet rs = ptmt.executeQuery();

		Goddess goddess = new Goddess();
		while (rs.next()) {
			goddess.setId(rs.getInt("id"));
			goddess.setUser_name(rs.getString("user_name"));
			goddess.setSex(rs.getInt("sex"));
			goddess.setAge(rs.getInt("age"));
			goddess.setBirthday(rs.getDate("birthday"));
			goddess.setEmail(rs.getString("email"));
			goddess.setMobile(rs.getString("mobile"));
			goddess.setCreate_date(rs.getDate("create_date"));
			goddess.setCreate_user(rs.getString("create_user"));
			goddess.setUpdate_date(rs.getDate("update_date"));
			goddess.setCreate_user(rs.getString("update_user"));
			goddess.setIsdel(rs.getInt("isdel"));

			gs.add(goddess);
		}
		return gs;
	}

	public Goddess get(Integer id) throws Exception {
		Goddess goddess = new Goddess();

		Connection conn = DBUtil.getConnection();
		String sql = "select * from imooc_goddess where id=?";
		PreparedStatement ptmt = conn.prepareStatement(sql);

		ptmt.setInt(1, id);

		ResultSet rs = ptmt.executeQuery();

		while (rs.next()) {
			goddess.setId(rs.getInt("id"));
			goddess.setUser_name(rs.getString("user_name"));
			goddess.setSex(rs.getInt("sex"));
			goddess.setAge(rs.getInt("age"));
			goddess.setBirthday(rs.getDate("birthday"));
			goddess.setEmail(rs.getString("email"));
			goddess.setMobile(rs.getString("mobile"));
			goddess.setCreate_date(rs.getDate("create_date"));
			goddess.setCreate_user(rs.getString("create_user"));
			goddess.setUpdate_date(rs.getDate("update_date"));
			goddess.setCreate_user(rs.getString("update_user"));
			goddess.setIsdel(rs.getInt("isdel"));
		}
		return goddess;

	}
}
