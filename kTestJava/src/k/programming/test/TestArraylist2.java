package k.programming.test;

import java.util.ArrayList;
import java.util.Collections;

public class TestArraylist2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		ArrayList<String> danjuHubo = new ArrayList<String>();
		danjuHubo.add("aaa");
		danjuHubo.add("bbb");
		danjuHubo.add("ccc");
		danjuHubo.add("ddd");
		System.out.println("k>TestArraylist.main - danjuHubo.size() 1:" + danjuHubo.size());	//test+++
		
		String v = "";
		for (int i = 0; i < danjuHubo.size(); i++) {
			if(danjuHubo.get(i).equals("ccc")) {
				danjuHubo.remove(danjuHubo.get(i));
			}
		}
//		for (Object o : danjuHubo) {
//			if(o.equals("ccc")) {
//				danjuHubo.remove(o);
//			}
//		}
		
		System.out.println("k>TestArraylist.main - danjuHubo.size() 2:" + danjuHubo.size());	//test+++
	}
}
