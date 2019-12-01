package k.programming.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DbProcess {
	public static final String DB_URL="jdbc:mysql://192.168.11.4:3306/stock";	//!!!
	public static final String DB_ID="stock";	//!!!
	public static final String DB_PW="zzzz";	//!!!
	
	static Connection con = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	//
	private static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(DB_URL, DB_ID, DB_PW);
			//System.out.println("k>DbProcess.getConnection-----------------" );	//test+++
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
			System.out.println("SQLState: " + se.getSQLState());
		}
		return con;
	}

	//
	private static void releaseConnection(){
		try {
			con.close();
			//System.out.println("k>DbProcess.releaseConnection--------------" );	//test+++
		} catch (SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
			System.out.println("SQLState: " + se.getSQLState());
		} finally {
			if (rs != null) { try { rs.close(); } catch (Exception e) {}}
			if (stmt != null) { try { stmt.close(); } catch (Exception e) {}}
			if (con != null) { try {con.close();} catch (Exception e) {}}
		}		
	}

	//
	public static ArrayList<HashMap<String, Object>> getDbData(String sqlStr) throws SQLException {
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		con = getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlStr);
		result = getRsData(rs);
		releaseConnection();
		return result;
	}

	//
	public static String getDbDataStr(String sqlStr) throws SQLException {
		String result = "";
		con = getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlStr);
		if(rs.next()){
			result = rs.getString(1);
		}
		releaseConnection();			
		return result;
	}

	//

	public static int setDbData(String sqlStr) throws SQLException {
		int result = 0;
		con = getConnection();
		stmt = con.createStatement();
		result = stmt.executeUpdate(sqlStr);
		releaseConnection();
		return result;
	}

	//
	public static int setDbTradeDataBatch(String sqlStr, ArrayList<HashMap<String, String>> list) throws SQLException {
		int result = 0;
		
		con = getConnection();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sqlStr);
		
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map = list.get(i);
			//System.out.println("k>DbProcess.setDbDataBatch - map:" + map.toString());	//test+++
			pstmt.setString(1, map.get("time"));
			pstmt.setString(2, map.get("amount"));
			pstmt.setString(3, map.get("price"));

            pstmt.addBatch();
            if( i>0 && (i%5000)==0){		//!!!
                int[] r = pstmt.executeBatch();
                con.commit() ;
                System.out.println("k>DbProcess.setDbTradeDataBatch - DB Commit - i:" + i);	//test+++
                System.out.println("k>DbProcess.setDbTradeDataBatch - DB Commit - r:" + r.toString());	//test+++
                pstmt.clearBatch();
            }
            pstmt.clearParameters();
            //System.out.print(" k>DbProcess.setDbTradeDataBatch -  i:" + i);	//test+++
		}
		//Stock.progressBar.setSelection(50);	
		
		result = list.size();
        pstmt.executeBatch() ;
        con.commit() ;
        con.setAutoCommit(true);
        releaseConnection();
        
		return result;
	}

	//
	public static int setBatchTradeDataBatch(String sqlStr, ArrayList<HashMap<String, String>> list) throws SQLException {
		int result = 0;
		
		con = getConnection();
		con.setAutoCommit(false);
		pstmt = con.prepareStatement(sqlStr);
		
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map = list.get(i);
			//System.out.println("k>DbProcess.setDbDataBatch - map:" + map.toString());	//test+++
			pstmt.setString(1, map.get("chetime"));
			pstmt.setString(2, map.get("cvolume"));
			pstmt.setString(3, map.get("price"));
			pstmt.setString(4, map.get("chdegree"));
			
			pstmt.addBatch();
			if( i>0 && (i%5000)==0){		//!!!
				int[] r = pstmt.executeBatch();
				con.commit() ;
				System.out.println("k>DbProcess.setBatchTradeDataBatch - DB Commit - i:" + i);	//test+++
				System.out.println("k>DbProcess.setBatchTradeDataBatch - DB Commit - r:" + r.toString());	//test+++
				pstmt.clearBatch();
			}
			pstmt.clearParameters();
			//System.out.print(" k>DbProcess.setDbTradeDataBatch -  i:" + i);	//test+++
		}
		//Stock.progressBar.setSelection(50);	
		
		result = list.size();
		pstmt.executeBatch() ;
		con.commit() ;
		con.setAutoCommit(true);
		releaseConnection();
		
		return result;
	}
	
	//ResultSet --> ArrayList
	public static ArrayList<HashMap<String, Object>> getRsData(ResultSet rs) throws SQLException {
		ArrayList<HashMap<String, Object>> result = new ArrayList<HashMap<String,Object>>();
		
		if(rs != null){
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				HashMap<String, Object> map  = new HashMap<String, Object>();					
				for (int i = 1; i <= columnCount; i++) {
					if(rs.getObject(i) == null){
						map.put(md.getColumnName(i), "");
					} else {
						map.put(md.getColumnName(i), rs.getObject(i));
					}
				}
				result.add(map);
			}
		}
		return result;
	}
}
