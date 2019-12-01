package k.programming.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class TestDBFunction {

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	//ResultSet --> ArrayList
	private ArrayList<HashMap<String, Object>> getRsData(ResultSet rs) throws SQLException {
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		
		if(rs != null){
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				HashMap<String, Object> map  = new HashMap<String, Object>();					
				for (int i = 1; i <= columnCount; i++) {
					map.put(md.getColumnName(i), rs.getObject(i));
				}
				result.add(map);
			}
		}
		return result;
	}
	
	private ArrayList<HashMap<String, Object>> getDbData(String sqlStr) throws SQLException {
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "stock", "zzzz");
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sqlStr);
			result = getRsData(rs);
				
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) { try { rs.close(); } catch (Exception e) {}}
			if (stmt != null) { try { stmt.close(); } catch (Exception e) {}}
			if (con != null) { try {con.close();} catch (Exception e) {}}
		}		
		return result;
	}
	
}
