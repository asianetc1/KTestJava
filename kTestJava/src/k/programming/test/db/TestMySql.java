package k.programming.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
-------------------------------------------------------------------------
-----------------------  Table �������� ---------------------------------
-------------------------------------------------------------------------
	���� �ŷ� ������ from ���ǻ� table
	drop table trade_data;
	create table trade_data(
		no int auto_increment ,
		company_no varchar(8)	 comment 'ȸ���ڵ�',
		trade_date varchar(8)	comment '�ŷ��� yyyymmdd',
		trade_time varchar(8)	comment '�ŷ��ð� hh:mm:ss',
		trade_amount int		comment '�ŷ���',
		trade_price int		comment'�ŷ�����',
		use_yn char(1) default 'Y'	comment '��뿩��',
		index(no),
		index(company_no(8)),
		index(trade_date(8)),
		index(trade_time(8))
	) comment='���� �ŷ� ������ from ���ǻ�'
	;

	����ȸ������ table
	drop table company_info;
	create table company_info(
		no int auto_increment ,
		company_no varchar(8)	 comment 'ȸ���ڵ�',
		company_name varchar(20) comment 'ȸ���',
		use_yn char(1) default 'Y',
		index(no),
		index(company_no(8))
	) comment='����ȸ������'
	;

	�ð�(��) ������ �Ǽ� ī��Ʈ table
	drop table analyze_time;
	create table analyze_time(
		no int auto_increment ,
		company_no varchar(8)	 comment 'ȸ���ڵ�',
		trade_date varchar(8)	comment '�ŷ��� yyyymmdd',
		trade_time varchar(8)	comment '�ŷ��ð� hh:mm:ss',
		trade_count int		comment '�ŷ��Ǽ�',
		use_yn char(1) default 'Y',
		index(no),
		index(company_no(8)),
		index(trade_date(8)),
		index(trade_time(8))
	) comment='�ð�(��) ������ �Ǽ� ī��Ʈ'
	;

	�ŷ����� �Ǽ� ī��Ʈ table
	drop table analyze_amount;
	create table analyze_amount(
		no int auto_increment ,
		company_no varchar(8)	 comment 'ȸ���ڵ�',
		trade_date varchar(8)	comment '�ŷ��� yyyymmdd',
		trade_amount int		comment '�ŷ���',
		trade_count int		comment '�ŷ��Ǽ�',
		use_yn char(1) default 'Y',
		index(no),
		index(company_no(8)),
		index(trade_date(8)),
		index(trade_amount)
	) comment='�ŷ����� �Ǽ� ī��Ʈ'
	;

-------------------------------------------------------------------------
----------------------- ȸ������ ���� ������ �Է� ���� -----------------
utf-8 �ڵ�� ������ INSERT!!!
-------------------------------------------------------------------------
select count(*) from stock.company_info;
select * from stock.company_info limit 20;
select company_no from stock.company_info limit 20;

LOAD DATA LOCAL INFILE 'c:/company_list.csv'
INTO TABLE stock.company_info 
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(company_no,company_name);

delete from stock.company_info;

-------------------------------------------------------------------------
----------------------- SAMPLE ���ʰŷ� ������ �Է� ���� -----------------
-------------------------------------------------------------------------
select count(*) from stock.trade_data;
select * from stock.trade_data limit 20;

LOAD DATA LOCAL INFILE 'c:/sample_data.csv'
INTO TABLE stock.trade_data 
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
(company_no,trade_date,trade_time,trade_amount,trade_price);


delete from stock.trade_data;

 */


public class TestMySql {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "stock", "zzzz");

			st = con.createStatement();
			rs = st.executeQuery("SHOW TABLES");

			if (st.execute("SHOW TABLES")) {
				rs = st.getResultSet();
			}

			System.out.println(">table list");
			
			while (rs.next()) {
				String str = rs.getNString(1);
				System.out.println(str);
			}
			
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
			if (st != null) { try { st.close(); } catch (Exception e) {}}
			if (con != null) { try {con.close();} catch (Exception e) {}}
		}

	}

}
