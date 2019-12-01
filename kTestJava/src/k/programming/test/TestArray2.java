/**
 * 
 */
package k.programming.test;

import java.util.ArrayList;

/**
 * @author k
 *
 */
public class TestArray2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList< String[]> list = new ArrayList<String[]>();
		String[] s1 = new String[]{"aaa","bbb"};
		String[] s2 = new String[]{"ccc","ggg"};
		String[] s3= new String[]{"ddd","fff"};
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		for (String[] str : list) {
			list.remove(1);
			System.out.println("k>TestArray2.main - str[0]:" + str[0]);	//test+++
		}

	}

}
