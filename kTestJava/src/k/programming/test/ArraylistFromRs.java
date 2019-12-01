package k.programming.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*
 * CREATE TABLE K.CONTACT
(
    NAME        VARCHAR2(20) DEFAULT 'name' NOT NULL,
    ADDR        VARCHAR2(100),
    AGE         NUMBER(3),
    LENGTH      FLOAT,
    INSERT_DATE DATE
)
TABLESPACE SYSTEM
STORAGE
(
    INITIAL 64K
    NEXT 1M
)
NOCOMPRESS;


n1	a1	11	123
n2	a2		456
n3	a3	44	

 */
public class ArraylistFromRs {
	public static void main(String[] args) throws Exception,SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driver).newInstance();

		String jdbcUrl = "jdbc:oracle:thin:@K:1521:XE";
		Connection conn = DriverManager.getConnection(jdbcUrl, "k", "k");

		Statement stmt = conn.createStatement();
		//ResultSet rs = stmt.executeQuery("SELECT * FROM CONTACT");
		ResultSet rs = stmt.executeQuery("SELECT " +
				"NAME,ADDR,AGE,LENGTH" +
				//",INSERT_DATE " +
				",to_char(insert_date,'yy/mm/dd hh24:mm') as insert_date " +
				" FROM CONTACT"
				);

		// =======================================================
		printColumnInfo(rs);
		System.out.println("=========================");
		printColumnNames(rs);
		
		System.out.println("=============================================================");

		// =======================================================
		// Java
		// =======================================================
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if(rs!=null){
			list = getArraylistFromRs(rs);
		}
		//return list;
		// =======================================================
		// JSP
		// =======================================================
		for (Iterator<HashMap<String, String>> iterator = list.iterator(); iterator.hasNext();) {
			HashMap<String, String> map = (HashMap<String, String>) iterator.next();
				System.out.println("---------------"); // test+++
				System.out.println("NAME :" + map.get("NAME"));	//test+++
				System.out.println("ADDR :" + map.get("ADDR"));	//test+++
				System.out.println("AGE :" + map.get("AGE"));	//test+++
				System.out.println("LENGTH :" + map.get("LENGTH"));	//test+++
				System.out.println("INSERT_DATE :" + map.get("INSERT_DATE"));	//test+++
		}
		// =======================================================

		conn.close();
	}

	//+++
	public static ArrayList<HashMap<String, String>> getArraylistFromRs(ResultSet rs) throws SQLException {
		ResultSetMetaData rmd = rs.getMetaData();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>(); 
		
		String colName = "";
		String colValue = "";
		
		while (rs.next()) {
			HashMap<String,String> map = new HashMap<String,String>();
			for (int col = 1; col <= rmd.getColumnCount(); col++) {
				colName = rmd.getColumnName(col);
				colValue = getData(rs, rmd.getColumnType(col), col) ;
				//System.out.println("k>TestRsArraylist.getData - colName:"+colName+" colValue:" + colValue);	//test+++
				map.put(colName, colValue);
			}
			list.add(map);
		}
		return list;
	}

	//+++
	public static String getData(ResultSet rs, int type, int colIdx) throws SQLException {

		String colValue = "";
		java.sql.Date d;
		
		System.out.println("k>TestRsArraylist.getData - type:" + type);	//test+++
		
		switch (type) {
		case java.sql.Types.CHAR:
			colValue = rs.getString(colIdx);
			break;
		case java.sql.Types.VARCHAR:
			colValue = rs.getString(colIdx);
			break;
		case java.sql.Types.INTEGER:
			int i = rs.getInt(colIdx);
			colValue = String.valueOf(i);
			break;
		case java.sql.Types.NUMERIC:
			BigDecimal bd = rs.getBigDecimal(colIdx);
			if (null != bd) {
				colValue = bd.toString();
			}
			break;
		case java.sql.Types.TIMESTAMP:
			d = rs.getDate(colIdx);
			if (null != d) {
				colValue = d.toString();
			}
			break;
		case java.sql.Types.DATE:
			d = rs.getDate(colIdx);
			if (null != d) {
				colValue = d.toString();
			}
			break;
		}
	
		return colValue;
	}

	//===================================================
	public static void printColumnNames(ResultSet rs) throws SQLException {
		ResultSetMetaData rmd = rs.getMetaData();
		for (int col = 1; col <= rmd.getColumnCount(); col++)
			System.out.println(rmd.getColumnName(col) + " ");
	}

	public static void printColumnInfo(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int cols = rsmd.getColumnCount();
		for (int colIdx = 1; colIdx <= cols; colIdx++) {
			String name = rsmd.getColumnName(colIdx);
			int type = rsmd.getColumnType(colIdx);
			String typeName = rsmd.getColumnTypeName(colIdx);

			System.out.println(name + ", " + type + ", " + typeName);
		}
	}
	//===================================================
	
}
