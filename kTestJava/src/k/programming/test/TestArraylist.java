package k.programming.test;

import java.util.ArrayList;
import java.util.Collections;

public class TestArraylist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//test1();
		
		//TEST DATA START-------------------------------------------------------------------------
		ArrayList<String[]> danjuHubo = new ArrayList<String[]>();
		for (int i = 10; i < 15; i++) {
			String[] d = new String[]{"120491","10:00:"+i,String.valueOf(i*10),"100000"};
			danjuHubo.add(d);
		}

		ArrayList<String[]> dbData = new ArrayList<String[]>();
		for (int i = 10; i < 20; i++) {
			String[] d = new String[]{"120491","10:11:"+i,String.valueOf(i*10),"100000"};
			dbData.add(d);
		}
		System.out.println("k>TestArraylist.main - danjuHubo.size() 1:" + danjuHubo.size());	//test+++
		System.out.println("k>TestArraylist.main - dbData.size() 1:" + dbData.size());	//test+++
		//TEST DATA END-------------------------------------------------------------------------

		ArrayList<String[]> danjuTemp = new ArrayList<String[]>();

		//1,dbData와 기존 단주후보 일치시 처리
		int danjuHuboSize1 = danjuHubo.size();
		if(danjuHuboSize1>0) {
			for (int i = danjuHuboSize1-1;  i>-1; i--) {
				String[] h = danjuHubo.get(i);	//단주후보
				int dbDataSize = dbData.size();
				for (int j = dbDataSize-1; j >-1; j--) {		//dbData [order by company_no desc, trade_time desc] 처리요!    기존 단주후보 null 시 처리 삭제!!!
					String[] d = dbData.get(j);			//dbData 
					if(h[0]==d[0] && h[2]==d[2]){	//종목&거래량이 같으면
						danjuTemp = new ArrayList<String[]>();
						int timeDiff = 9;	//for test+++
						//int timeDiff = timeDiff(h[1],d[1]);	//...
						if(timeDiff<10 || timeDiff>720) {	//시간간격이 9초 이하이거나 721초 이상이면
							//기존 단주후보==>(단주추가 or 버림) & 기존 단주후보 삭제
							int danjuHuboSize2 = danjuHubo.size();
							for (int k = danjuHuboSize2-1;  k>-1; k--) {
								if(danjuHubo.get(k)[0]==d[0] && danjuHubo.get(k)[2]==d[2]){		//
									danjuTemp.add(danjuHubo.get(k));
									danjuHubo.remove(danjuHubo.get(k));
								}
							}
							//danjuTemp(1종목+1거래량)에서 단주확정 또는 단주후보 데이터 버리기...
							int amount = Integer.parseInt(d[2]);	//거래량
							int sum = Integer.parseInt(d[3]);	//거래금액
							int count = danjuTemp.size();	//회수
//							if(amout=70 || amout=80 || ...){
//								if(count>9){
//									
//								} else {
//									
//								}
//							}
//							if(sum>7000000 && sum<90000000 ...){
//								if(count>5){
//									
//								} else {
//									
//								}
//							}
						} 
						danjuHubo.add(dbData.get(j));	//dbData 단주후보에 추가
						dbData.remove(dbData.get(j));	//dbData 버림
					}
				}
			}
		}

		//2.dbData값이 기존 단주후보와 일치하는 값이 없을 경우 신규 단주후보 추가
		if(dbData.size()>0){
			int dbDataSize = dbData.size();
			for (int j = dbData.size()-1; j >-1; j--) {		//dbData [order by company_no desc, trade_time desc] 처리요!
			//for (int j = 0; j < dbDataSize; j++) {
				danjuHubo.add(dbData.get(j));	//dbData 신규 단주후보에 추가						
				dbData.remove(dbData.get(j));	//dbData버림
			}
		}
			
		System.out.println("k>TestArraylist.main - danjuHubo.size() 2:" + danjuHubo.size());	//test+++
		System.out.println("k>TestArraylist.main - dbData.size() 2:" + dbData.size());	//test+++
		
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
