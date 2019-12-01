package k.programming.test.number;


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

public class TestNumber {

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

			if(TestNumber.isNumeric(v0) && TestNumber.isNumeric(v1) ){
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
			
			if(TestNumber.isNumeric(v0) && TestNumber.isNumeric(v1) ){
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
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static String makeMoneyStr(long param){
		DecimalFormat format = new DecimalFormat("###,###,###,###,###");
		String result = "";
		result = format.format(param);
		return result;
	}
	
	/**
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static String makeMoneyStr(int param){
		DecimalFormat format = new DecimalFormat("###,###,###,###,###");
		String result = "";
		result = format.format(param);
		return result;
	}

	/**
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static String makeMoneyStr(String param){
		DecimalFormat format = new DecimalFormat("###,###,###,###,###");
		String result = "";
		if(null!=param) result = format.format(Long.parseLong(param));
		return result;
	}
	
	/**
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static String makeFloatStr(float param){
		DecimalFormat format = new DecimalFormat("###.#");
		//DecimalFormat format = new DecimalFormat("###.##");
		String result = "";
		result = format.format(param);
		return result;
	}
	
	/**
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static double makeDouble2(double param){
		DecimalFormat format = new DecimalFormat("###.##");
		double result;
		result = Double.parseDouble(format.format(param));
		return result;
	}
	
	/**
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static String makeFloatStr2(float param){
		DecimalFormat format = new DecimalFormat("###.##");
		String result = "";
		result = format.format(param);
		//System.out.println("TestNumber.makeFloatStr2 - result:"+result);		//t+++
		//System.out.printf("%.2f", param);		//t+++
		if(param>0)result="+"+result;
		return result;
	}
	
	
	/**
	 * %
	 * @param param
	 * @return
	 */
	public static String makeFloatPercent2(float param){
		DecimalFormat format = new DecimalFormat("###.##");
		String result = "";
		result = format.format(param);
		return result;
	}
	
	/**
	 * %
	 * @param param
	 * @return
	 */
	public static String makeFloatPercent1(float param){
		DecimalFormat format = new DecimalFormat("###.#");
		String result = "";
		result = format.format(param);
		return result;
	}
	
	/**
	 * %
	 * @param param
	 * @return
	 */
	public static String makeFloat0(float param){
		DecimalFormat format = new DecimalFormat("###,###,###,###");
		String result = "";
		result = format.format(param);
		return result;
	}
	
	/**
	 * 금액 단위 문자열 변환
	 * @param param
	 * @return
	 */
	public static String makeFloatStr3(float param){
		DecimalFormat format = new DecimalFormat("###,###,###.##");
		String result = "";
		result = format.format(param);
		//if(param>0)result="+"+result;
		return result;
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



