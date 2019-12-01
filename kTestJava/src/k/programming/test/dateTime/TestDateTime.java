package k.programming.test.dateTime;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.Collator;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;

public class TestDateTime {

	public static boolean isWeekend() {
		Calendar cal = Calendar.getInstance();
	    return checkWeekend(cal);
	}

	public static boolean isWeekend(Calendar cal) {
		return checkWeekend(cal);
	}

	public static boolean checkWeekend(Calendar cal) {
		int day =  0;
		day =  cal.get(Calendar.DAY_OF_WEEK);
		if(day==1 || day==7) return true;		//주말(토일)
		
		int dayOfYear =  0;
		dayOfYear =  cal.get(Calendar.DAY_OF_YEAR);
		if(dayOfYear==1 || dayOfYear==365) return true;		//년초 연말
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DAY_OF_MONTH);
		
		if(m==3 && d==1) return true;	//31절
		if(m==5 && d==5) return true;	//어린이날
		if(m==6 && d==6) return true;	//현충일
		if(m==8 && d==15) return true;	//광복절
		if(m==10 && d==3) return true;	//개천절
		if(m==10 && d==9) return true;	//한글날
		if(m==12 && d==25) return true;	//크리스마스

		//2017년
		if(y==2017){
			if(m==10 && (d>=2 && d<=9) ) return true;
			if(m==12 && d==20 ) return true;
			if(m==12 && d==29 ) return true;
		}		
		
		//2018년
		if(y==2018){
			if(m==2 && (d>=15 && d<=17) ) return true;	//설
			if(m==5 && d==7 ) return true;	//어린이날대체
			if(m==5 && d==22 ) return true;	//석가탄신일
			if(m==9 && (d>=23 && d<=25) ) return true;	//추석
		}
		
		return false;
	}
	
	public static String getTodayDotStr() {
		Calendar cal = Calendar.getInstance();
	    String dateStr = "";
	    dateStr = String.format("%04d.%02d.%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		return dateStr;
	}

	public static String getTodayDateStr() {
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		dateStr = String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		return dateStr;
	}

	public static long getTodayDateLong() {
		Calendar cal = Calendar.getInstance();
		String dateStr = "";
		long result = 0;
		dateStr = String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		if(null!=dateStr && !dateStr.equals("")){
			result=Long.parseLong(dateStr);
		}
		return result;
	}
	
	public static String getTodayDateTimeStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%04d.%02d.%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)) + "  " +
				String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return dateTimeStr;
	}

	public static String getTodayDateTimeMillisecondStr2() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = 
				String.format("%04d.%02d.%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)) + "  " 
				+String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND))
				+String.format(" %02d", cal.get(Calendar.MILLISECOND));
		return dateTimeStr;
	}
	
	public static String getCurrentHHMMSSsssStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = 
				String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND))
				+String.format(" %02d", cal.get(Calendar.MILLISECOND));
		return dateTimeStr;
	}
	
	public static String getCurrentMMSSStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return dateTimeStr;
	}

	public static int getCurrentSS() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d", cal.get(Calendar.SECOND));
		return Integer.parseInt(dateTimeStr);
	}
	
	public static String getCurrentSSStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d", cal.get(Calendar.SECOND));
		return dateTimeStr;
	}
	
	public static int getCurrentHHMM() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return Integer.parseInt(dateTimeStr);
	}
	
	public static int getCurrentMM() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = String.format("%02d", cal.get(Calendar.MINUTE));
		return Integer.parseInt(dateTimeStr);
	}
	
	public static String getCurrentHHMMStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}

	public static int getCurrentHHMMSS() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return Integer.parseInt(dateTimeStr);
	}
	
	public static String getCurrentHHMMSSStr() {
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return dateTimeStr;
	}
	
	public static String getMinuteAfterCurrentHHMMStr(int min) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, min);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}
	
	public static String get20MinuteAfterCurrentHHMMStr() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 20);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}
	
	/**
	 * 현재시간+-n시간 Long
	 * @param _hour
	 * @return
	 */
	public static Long getAddHourCurrentHHMMLong(int _hour) {
		if(_hour==0)return (long) 0;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, _hour);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return Long.parseLong(dateTimeStr);
	}

	public static String getCurrentHHMMAddMinuteStr(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}

	/**
	 * 현재시간+n분
	 * @param minutes
	 * @return
	 */
	public static String getCurrentHHMMSSAddMinuteStr(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
		return dateTimeStr;
	}
	
	public static String getHHMMAddMinuteStr(String hhmm, int minutes) {
		if(hhmm.length()==3) hhmm ="0" +hhmm ;	//9시 시간대 대응 for 대신. 915-->0915
		SimpleDateFormat dataFormat = new SimpleDateFormat("HHmm");
		Date date = null;
		try {
			date = dataFormat.parse(hhmm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return dateTimeStr;
	}
	
	public static int getHHMMAddMinute(String hhmm, int minutes) {
		if(hhmm.length()==3) hhmm ="0" +hhmm ;	//9시 시간대 대응 for 대신. 915-->0915
		SimpleDateFormat dataFormat = new SimpleDateFormat("HHmm");
		Date date = null;
		try {
			date = dataFormat.parse(hhmm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		String dateTimeStr = "";
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		return Integer.parseInt(dateTimeStr);
	}
	
	/**
	 * 
	 * @param _dateStr
	 * @param _addDay
	 * @return
	 */
	public static int getAddDate(String _dateStr, int _addDay) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = dataFormat.parse(_dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, _addDay);
		String dateStr = "";
		dateStr = String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		return Integer.parseInt(dateStr);
	}
	
	/**
	 * 주말을 감안한 거래일 +-처리
	 * @param _dateStr
	 * @param _addDay
	 * @return
	 */
	public static String getAddDateStr(String _dateStr, int _addDay) {
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		String dateStr = "";
		
		try {
			date = dataFormat.parse(_dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		//휴일을 감안한 거래일 +-처리
		int addDay = 0;

		if(_addDay>0){
			for (int i = 0; i < _addDay; i++) {
				cal.add(Calendar.DATE, +1);
				while(TestDateTime.isWeekend(cal)){
					if(_addDay>0){
						cal.add(Calendar.DATE, 1);
					}else if(_addDay<0){
						cal.add(Calendar.DATE, -1);
					}
				}
			}
		}
		if(_addDay<0){
			for (int i = 0; i > _addDay; i--) {
				cal.add(Calendar.DATE, -1);
				while(TestDateTime.isWeekend(cal)){
					if(_addDay>0){
						cal.add(Calendar.DATE, 1);
					}else if(_addDay<0){
						cal.add(Calendar.DATE, -1);
					}
				}
			}
		}
		dateStr = String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
//		System.out.println("k>TestNumber.getAddDateStr - 2:" + dateStr);	//t+++

		return dateStr;
	}
	
	public static String getTodayYYYYMMDDStr() {
		Calendar cal = Calendar.getInstance();
	    String dateStr = "";
	    dateStr = String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
		return dateStr;
	}
	
	//시간차이
	public static long getTimeDiff(String t1, String t2) {
		long result = 0;
		try {

			if(null==t1 || t1.trim().equals("")) {
				System.out.println("k>TestNumber.getTimeDiff - : t1 is no value!!!" );	//test+++
				return -1;
			}
			if(null==t2 || t2.trim().equals("")) {
				System.out.println("k>TestNumber.getTimeDiff - : t2 is no value!!!" );	//test+++
				return -1;
			}
			t1=t1.trim();
			t2=t2.trim();
			
			if(t1.length()==5) t1= "0"+t1;
			else if(t1.length()>6) {
				t1= t1.substring(0, 6);
				return -1;	//test!!!
			}
			if(t2.length()==5) t2= "0"+t2;
			else if(t2.length()>6) {
				t2= t2.substring(0, 6);
				return -1;	//test!!!
			}
			
			DateFormat formatter = new SimpleDateFormat("HHmmss");
			Date date1 = formatter.parse(t1);
			Date date2 = formatter.parse(t2);
			if(date2.getTime()==date1.getTime()) {
				//System.out.println("TestNumber.getTimeDiff - date1.getTime():"+date1.getTime()+"\tdate2.getTime()"+date2.getTime());		//t+++
				result=0;
			} else {
				result = Math.abs((date2.getTime() - date1.getTime())/1000);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//시간차이2
	public static long getTimeDiffColon(String t1, String t2) {
		long result = 0;
		try {
			DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			Date date1 = formatter.parse(t1);
			Date date2 = formatter.parse(t2);
			result = Math.abs((date2.getTime() - date1.getTime())/1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	//
	/**
	 * 장운영시간 for 수급
	 *   8:00-18:00 
	 * @return
	 */
	public static boolean isMarketOpenTimeForSooGup() {
		boolean result = false;
		Calendar cal = Calendar.getInstance();
		String dateTimeStr = "";
		int dateTimeInt = 0;
		dateTimeStr = String.format("%02d%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
		dateTimeInt = Integer.parseInt(dateTimeStr);
		if(dateTimeInt>=800 && dateTimeInt<=1800){
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	//
	public static long getSystemTimMiliseond() {
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		long result = Long.parseLong(dayTime.format(new Date(time))); 
		return result;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
	  Pattern pattern = Pattern.compile("^[+-]?\\d*(\\.?\\d*)$");
	  return pattern.matcher(str).matches();
	}	
	
	//###	
	static public int compareAbsValStringTimeLong(Object value0, Object value1){
		if(null!=value0.toString() && null!=value1.toString() && !value0.equals("") && !value1.equals("")){
			String v0 = value0.toString().replaceAll("[,]", "");
			String v1 = value1.toString().replaceAll("[,]", "");
//			v0 = v0.toString().replaceAll("[.]", "");
//			v1 = v1.toString().replaceAll("[.]", "");
			v0 = v0.toString().replaceAll("[:]", "");
			v1 = v1.toString().replaceAll("[:]", "");
			if(TestDateTime.isNumeric(v0) && TestDateTime.isNumeric(v1) ){
				if(Math.abs(Long.parseLong(v0)) < Math.abs(Long.parseLong(v1))) return -1; else return 1;
			} else {
				Collator collator = Collator.getInstance(Locale.getDefault());
				return collator.compare(value0, value1);
			}
		} else {
			return 0;
		}
	}

	//###	
	static public int compareValStringAll(Object value0, Object value1){
		if(null!=value0.toString() && null!=value1.toString() && !value0.equals("") && !value1.equals("")){

			String v0 = value0.toString().trim();
			String v1 = value1.toString().trim();
			v0 = v0.replaceAll("[,]", "");
			v1 = v1.replaceAll("[,]", "");
			v0 = v0.replaceAll("[:]", "");
			v1 = v1.replaceAll("[:]", "");
			v0 = v0.replaceAll("[+]", "");
			v1 = v1.replaceAll("[+]", "");
			v0 = v0.replaceAll("[%]", "");
			v1 = v1.replaceAll("[%]", "");
			v0 = v0.replaceAll("K", "");
			v1 = v1.replaceAll("K", "");
			v0 = v0.replaceAll("억", "");
			v1 = v1.replaceAll("억", "");
//			v0 = v0.replaceAll("(", "");
//			v1 = v1.replaceAll("(", "");
//			v0 = v0.replaceAll(")", "");
//			v1 = v1.replaceAll(")", "");

			if(TestDateTime.isNumeric(v0) && TestDateTime.isNumeric(v1) ){
				if(v0.indexOf(".")>-1 || v1.indexOf(".")>-1) { 
					if(Float.parseFloat(v0) < Float.parseFloat(v1)) return -1; else return 1;
				} else {
					if(Long.parseLong(v0) < Long.parseLong(v1)) return -1; else return 1;
				}
			} else {
				Collator collator = Collator.getInstance(Locale.getDefault());
				return collator.compare(value0, value1);
			}
		} else {
			return 0;
		}
	}
	
	//###
	static public int compareValStringLong(Object value0, Object value1){
		if(null!=value0.toString() && null!=value1.toString() && !value0.equals("") && !value1.equals("")){
			
			String v0 = value0.toString().replaceAll("[,]", "");
			String v1 = value1.toString().replaceAll("[,]", "");
//			v0 = v0.toString().replaceAll("[.]", "");
//			v1 = v1.toString().replaceAll("[.]", "");
			v0 = v0.toString().replaceAll("[:]", "");
			v1 = v1.toString().replaceAll("[:]", "");
//			v0 = v0.toString().replaceAll("[+]", "");
//			v1 = v1.toString().replaceAll("[+]", "");
//			v0 = v0.toString().replaceAll("[%]", "");
//			v1 = v1.toString().replaceAll("[%]", "");
//			v0 = v0.toString().replaceAll("K", "");
//			v1 = v1.toString().replaceAll("K", "");
//			v0 = v0.toString().replaceAll("억", "");
//			v1 = v1.toString().replaceAll("억", "");
			
			if(TestDateTime.isNumeric(v0) && TestDateTime.isNumeric(v1) ){
//				System.out.println("k>TestNumber.compareValStringLong - v0 :" + v0);	//test+++
//				System.out.println("k>TestNumber.compareValStringLong - v1 :" + v1);	//test+++
//				System.out.println("k>TestNumber.compareValStringLong - v0 index:" + v0.indexOf("."));	//test+++
				if(Long.parseLong(v0) < Long.parseLong(v1)) return -1; else return 1;
				//if(Integer.parseInt(v0) < Integer.parseInt(v1)) return -1; else return 1;
			} else {
				Collator collator = Collator.getInstance(Locale.getDefault());
				return collator.compare(value0, value1);
			}
		} else {
			return 0;
		}
	}

	/**
	 * YYYYMMDD.0 --> YYYYMMDD 
	 * @param param
	 * @return
	 */
	public static String makeDateYYYYMMDDStr(double param) {
		String y = "";
		String m = "";
		String d = "";
		String dt = "";
		dt=Double.toString(param).substring(0, String.valueOf(param).indexOf("."));
		y = dt.substring(0, 4);
		m = dt.substring(4, 6);
		d = dt.substring(6, 8);
		return y+"/"+m+"/"+d;
	}
	
	//hhMMss --> HH:mm:ss
	public static String makeTimeStr(String time) {
		String h = "";
		String m = "";
		String s = "";
		if(time.length()==5) time="0"+time;
		if(time.length()==6){
			h = time.substring(0, 2);
			m = time.substring(2, 4);
			s = time.substring(4, 6);
		}
		return h+":"+m+":"+s;
	}

	/**
	 * HHMM --> HH:MM 
	 * @param time
	 * @return
	 */
	public static String makeTimeHHMMStr(String time) {
		String h = "";
		String m = "";
		if(time.length()==3) time="0"+time;
		if(time.length()==4){
			h = time.substring(0, 2);
			m = time.substring(2, 4);
		}
		return h+":"+m;
	}
	
	/**
	 * HHMM.0 --> HH:MM 
	 * @param time
	 * @return
	 */
	public static String makeTimeHHMMStr(double time) {
		String h = "";
		String m = "";
		String t = "";
		t=String.valueOf(time).substring(0, String.valueOf(time).indexOf("."));
		if(t.length()==3) t="0"+t;
		h = t.substring(0, 2);
		m = t.substring(2, 4);
		return h+":"+m;
	}
	
	/**
	 * HHMMSS.0 --> HH:MM:SS 
	 * @param time
	 * @return
	 */
	public static String makeTimeHHMMSSStr(double time) {
		String h = "";
		String m = "";
		String s = "";
		String t = "";
		t=String.valueOf(time).substring(0, String.valueOf(time).indexOf("."));
		if(t.length()==5) t="0"+t;
		h = t.substring(0, 2);
		m = t.substring(2, 4);
		s = t.substring(4, 6);
		return h+":"+m+":"+s;
	}
	
	/**
	 * double array-->string array
	 * @param param
	 * @return
	 */
	public static String[] makeStringArrayFromDoubleArray(double[] param){
		if(param.length<1) return null;
		//String[] ss = new String[param.length]{};
		String[] ss = new String[param.length];
		for (int i = 0; i < param.length; i++) {
			ss[i]=String.valueOf(param[i]);
		}
		return ss;
	}
	
	
	public static void executeJavaGC() {
		Runtime r = Runtime.getRuntime();
		DecimalFormat format = new DecimalFormat("###,###,###.##");
		
		//JVM이 현재 시스템에 요구 가능한 최대 메모리량, 이 값을 넘으면 OutOfMemory 오류가 발생 합니다.               
		long max = r.maxMemory();
		//JVM이 현재 시스템에 얻어 쓴 메모리의 총량
		long total = r.totalMemory();
		//JVM이 현재 시스템에 청구하여 사용중인 최대 메모리(total)중에서 사용 가능한 메모리
		long free = r.freeMemory();
//		System.out.println("k>TestNumber.executeJavaGC - : ------------------------------------------------------------------" );	//test+++
		System.out.println("k>TestNumber.executeJavaGC - : Java Memory - Max:" + format.format(max) + ", Total:" + format.format(total) + ", Free:"+format.format(free));          
		
		if(free<50000000){	//남은 메모리가 50메가 이하이면 GC!!!
			System.gc();
			System.out.println("k>TestNumber.executeJavaGC - : Java Garbage Collected!!!" );	//test+++
	
			//JVM이 현재 시스템에 요구 가능한 최대 메모리량, 이 값을 넘으면 OutOfMemory 오류가 발생 합니다.               
			max = r.maxMemory();
			//JVM이 현재 시스템에 얻어 쓴 메모리의 총량
			total = r.totalMemory();
			//JVM이 현재 시스템에 청구하여 사용중인 최대 메모리(total)중에서 사용 가능한 메모리
			free = r.freeMemory();
			System.out.println("k>TestNumber.executeJavaGC - : AFTER GC   - Max:" + format.format(max) + ", Total:" + format.format(total) + ", Free:"+format.format(free));
		}
		
	}

	public static void main(String args[]){
		//System.out.println(makeTimeStr("091234"));
		Calendar cal = Calendar.getInstance();
		boolean b = false;
	    int day =  cal.get(Calendar.DAY_OF_YEAR);
	    System.out.println("TestNumber.main - day:"+day);		//t+++

	}
	
}



