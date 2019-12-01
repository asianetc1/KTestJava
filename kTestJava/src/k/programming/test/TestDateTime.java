package k.programming.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestDateTime {

	public static void main(String[] args) {

		//날짜(년/월/일) 구하기
		SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
		Date currentTime = new Date ( );
		String dTime = formatter.format ( currentTime );
		System.out.println ( dTime ); 
		
		//날짜(년/월/일/시/분/초) 구하기
		SimpleDateFormat formatter2 = new SimpleDateFormat ( "yyyy.MM.dd HH:mm:ss", Locale.KOREA );
		Date currentTime2 = new Date ( );
		String dTime2 = formatter2.format ( currentTime2 );
		System.out.println ( dTime2 ); 
		
		//현재날짜에서 2달전의 날짜를 구하기		
		Calendar cal = Calendar.getInstance ( );//오늘 날짜를 기준으루..
		cal.add ( cal.MONTH, -2 ); //2개월 전....
		System.out.println ( cal.get ( cal.YEAR ) );
		System.out.println ( cal.get ( cal.MONTH ) + 1 );
		System.out.println ( cal.get ( cal.DATE ) );

		//
	    String dateString, timeString;
	    dateString = String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)) + " " +
	    					String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));
	    System.out.println(dateString);
	    
	}

}
