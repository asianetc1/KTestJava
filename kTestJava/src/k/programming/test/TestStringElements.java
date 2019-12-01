/**
 * 
 */
package k.programming.test;


public class TestStringElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sss = "string test";
		if (!sss.equals(null)) {
			for (int j = 0; j < sss.length(); j++) {
				System.out.println(sss.charAt(j));
			}
		}
	}

}
