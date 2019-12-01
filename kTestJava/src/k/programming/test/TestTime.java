package k.programming.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long diff=0;
//		diff=getTimeDiff("120000","120100");
//		diff=getTimeDiff("100000","090000");
		diff=getTimeDiff("090101","090807");
		System.out.println("k>TestTime.main - diff:" + diff);	//test+++
	}

	//시간차이
	public static long getTimeDiff(String t1, String t2) {
		long result = 0;
		try {
			
			if(null==t1 || t1.trim().equals("")) return 0;
			if(null==t2 || t2.trim().equals("")) return 0;
			t1=t1.trim();
			t2=t2.trim();
			if(t1.length()==5) t1= "0"+t1;
			else if(t1.length()>6) t1= t1.substring(0, 6);
			if(t2.length()==5) t2= "0"+t2;
			else if(t2.length()>6) t2= t2.substring(0, 6);
			System.out.println("k>TestTime.getTimeDiff - t1:" + t1 + "  t2:" + t2);	//test+++
			
			DateFormat formatter = new SimpleDateFormat("HHmmss");
			Date date1 = formatter.parse(t1);
			Date date2 = formatter.parse(t2);
			System.out.println("TestNumber.getTimeDiff - date1.getTime():"+date1.getTime()+"\tdate2.getTime()"+date2.getTime());		//t+++
			if(date2.getTime()==date1.getTime()) {
				result=0;
			} else {
				result = Math.abs((date2.getTime() - date1.getTime())/1000);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}	
}
