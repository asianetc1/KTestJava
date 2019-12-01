package k.programming.test;

import java.util.HashMap;
import java.util.Map;

public class TestHashmap {

	static HashMap<String, String> map = new HashMap<String, String>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testHashmap();
		testHashmap2();

	}

	private static void testHashmap() {
		map.put("name", "kwak");
		map.put("sex", "male");
		System.out.println(" name:" + map.get("name"));
		System.out.println(" sex:" + map.get("sex"));
	}
	
	private static void testHashmap2() {
		map.put("name", "kwak");
		map.put("sex", "male");
		System.out.println(" name:" + map.get("name"));
		System.out.println(" sex:" + map.get("sex"));
	}

}
