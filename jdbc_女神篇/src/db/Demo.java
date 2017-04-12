package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {

	private static final String URL = "jdbc:Oracle:thin@localhost:1521:Orcl";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	private static Connection conn = null;

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return conn;
	}
}
