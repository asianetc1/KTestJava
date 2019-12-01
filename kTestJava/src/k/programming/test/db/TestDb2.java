package k.programming.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDb2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:db2://localhost:50000/sample";
		String user = "k1";
		String pass = "zzzz";

		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
			System.out.println("Driver Loading");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Get Connection Object");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select EMPNO from EMPLOYEE");
			while (rs.next()) {
				System.out.println(rs.getString("EMPNO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
