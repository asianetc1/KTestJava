package k.programming.test;

import java.util.Calendar;
import java.util.regex.Pattern;

public class TestDateTime2 {

	public static boolean isWeekend() {
		Calendar cal = Calendar.getInstance();
		boolean b = false;
	    int day =  cal.get(Calendar.DAY_OF_WEEK);
	    if(day==1 || day==7){	//주말
	    	b = true;
	    }
		return b;
	}
	
	public static String getTodayDotStr() {
		Calendar cal = Calendar.getInstance();
	    String dateStr = "";
	    dateStr = String.format("%04d.%02d.%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		return dateStr;
	}

	public static String getTodayDateTimeStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%04d.%02d.%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)) + "  " +
				String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return dateTimeStr;
	}

	public static String getCurrentMMSSStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return dateTimeStr;
	}

	public static String getCurrentHHMMStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}

	public static String getCurrentHHMMStr(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}
	
	public static String getTodayYYYYMMDDStr() {
		Calendar cal = Calendar.getInstance();
	    String dateStr = "";
	    dateStr = String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		return dateStr;
	}

	//hhMMss --> hh:MM:ss
	public static String makeTimeStr(String time) {
		String h = time.substring(0, 2);
		String m = time.substring(2, 4);
		String s = time.substring(4, 6);
		return h+":"+m+":"+s;
	}

	//?��?��?��?���?=7:00-18:10
	public static boolean isMarketOpenTime() {
		boolean result = false;
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		int dateTimeInt = 0;
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		dateTimeInt = Integer.parseInt(dateTimeStr);
		System.out.println("k>TestNumber.isMarketOpenTime - dateTimeInt:" + dateTimeInt);	//test+++
		if(dateTimeInt>=730 && dateTimeInt<=1810){
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
  public static boolean isNumeric(String str) {
	  Pattern pattern = Pattern.compile("^[+-]?\\d*(\\.?\\d*)$");
	  return pattern.matcher(str).matches();
  }	
	
	public static void main(String args[]){
		System.out.println(makeTimeStr("091234"));
	}
}



