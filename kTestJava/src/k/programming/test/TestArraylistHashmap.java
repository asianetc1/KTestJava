package k.programming.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class TestArraylistHashmap {

	public static void main(String[] args) {
		System.out.println("k>TestArraylistHashmap.main ---------------------------" );	//test+++
		ArrayList list = new ArrayList();
		
		for (int i = 4; i >= 0; i--) {
			HashMap map = new HashMap();
			map.put("name", "kwak"+i);
			map.put("sex", "male"+i);
			map.put("age", i);
			list.add(map);
		}

		for (int j=0; j<list.size(); j++) {
			HashMap map = new HashMap();
			map = (HashMap)list.get(j);
			System.out.println(" name:" + map.get("name") +" sex:" + map.get("sex")); // test+++
		}

	}
}
