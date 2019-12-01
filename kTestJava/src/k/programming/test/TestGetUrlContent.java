/* COPYRIGHT (c) Samsung Fire & Marine Insurance 2009
 * This software is the proprietary information of 
 * Samsung Fire & Marine Insurance.
 */

package k.programming.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Information Lifecycle Managemenrt
 * 
 * @sfmi.title 타이틀을 입력하세요.(필수)
 * @sfmi.developer 이름을 입력하세요.
 * @sfmi.portal-id 포탈아이디를 입력하세요.(필수)
 */

public class TestGetUrlContent {

    public static void main(String[] args) {

//        try {
//            URL u = new URL("http://www.java2s.com");
//            Object o = u.getContent();
//            System.out.println("I got a " + o.getClass().getName());
//        }
//        catch (Exception ex) {
//            System.err.println(ex);
//        }

        try {
            URLConnection conn = new URL("http://www.java2s.com").openConnection();
            InputStream in = conn.getInputStream();
            String contents = convertStreamToString(in);
            System.out.println("k> TestGetUrlContent.main contents: " + contents ); //test+++
       } catch (MalformedURLException e) {
            System.out.println("k> TestGetUrlContent.main : URL EXCEPTION");
       } catch (IOException e) {
           System.out.println("k> TestGetUrlContent.main : " + e.getMessage() ); //test+++
       }

    }
    
    private static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {
        
        BufferedReader reader = new BufferedReader(new    
                                InputStreamReader(is, "UTF-8"));
          StringBuilder sb = new StringBuilder();
           String line = null;
           try {
                  while ((line = reader.readLine()) != null) {
                          sb.append(line + "\n");
                  }
             } catch (IOException e) {
                  e.printStackTrace();
             } finally {
                  try {
                          is.close();
                  } catch (IOException e) {
                          e.printStackTrace();
                  }
              }
          return sb.toString();
    }
  }    
