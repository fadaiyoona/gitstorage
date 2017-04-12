package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Goddess;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import db.DBUtil;

public class ProcedureDao {

	public static List<Goddess> select_filter(String sp_name)
			throws SQLException {
		Connection conn = DBUtil.getConnection();
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess goddess = null;
		CallableStatement call = conn
				.prepareCall("{call mypackage1.sp_select_filter(?,?)}");

		call.setString(1, sp_name);
		call.registerOutParameter(2, OracleTypes.CURSOR);

		call.execute();

		ResultSet rs = ((OracleCallableStatement) call).getCursor(2);
		while (rs.next()) {
			goddess = new Goddess();
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

	public static void select_nofilter() throws SQLException {
		Connection conn = DBUtil.getConnection();
		CallableStatement call = conn
				.prepareCall("{call mypackage.sp_select_nofilter(?)}");

		call.registerOutParameter(1, OracleTypes.CURSOR);

		call.execute();

		ResultSet rs = ((OracleCallableStatement) call).getCursor(1);

		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("user_name");
			String mobile = rs.getString("mobile");
			System.out.println(id + "=" + name + ":" + mobile);
		}

	}
}
