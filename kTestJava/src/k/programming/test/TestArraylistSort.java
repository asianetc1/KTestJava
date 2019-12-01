package k.programming.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestArraylistSort {

	public static void main(String[] args) {
		System.out.println("k>TestArraylistSort.main - :----------------------------" );	//test+++
		ArrayList list = new ArrayList();
		
		String[] item = new String[]{"234567", "bb", "22", "111"};
		list.add(item);
		item = new String[]{"123456", "aa", "11", "333"};
		list.add(item);
		item = new String[]{"345678", "cc", "33", "222"};
		list.add(item);

		for (int j=0; j<list.size(); j++) {
			String[] item1 = (String[])list.get(j);
			System.out.println(item1[0]+ " "+item1[1]+ " "+item1[2]+ " "+item1[3]); // test+++
		}
		
		System.out.println("k>TestArraylistSort.main - :--------------------------" );	//test+++
		Collections.sort(list, gigwanSorter);
		
		for (int j=0; j<list.size(); j++) {
			String[] item1 = (String[])list.get(j);
			System.out.println(item1[0]+ " "+item1[1]+ " "+item1[2]+ " "+item1[3]); // test+++
		}
	}
	
    public static Comparator<Object> gigwanSorter = new Comparator<Object>() {
        public int compare(Object o1, Object o2) {
        	String[] s1 = (String[])o1; 
        	String[] s2 = (String[])o2; 
            long by1 = Long.parseLong(s1[3]);
            long by2 = Long.parseLong(s2[3]);
            return by1 > by2 ? -1 : (by1 == by2 ? 0 : 1); // descending 정렬.....
        }
    };
}
