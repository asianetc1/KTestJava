package k.programming.test;

public class TestThread {
	static int cnt = 0;
	static int sec=0;		
	static boolean isRunning = false;
	
	public static void main(String[] args) {
		sec=3;		//n초 동안 실행
		getData(sec);
	}

	public static void getData(final int sec) {
		Thread jamjungThjread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i <= sec; i++) {
					if(!isRunning){
						getJamjungData(i);
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("k>TestThread.main(...).new Runnable() {...}.run -------------- :"+i );	//test+++
				}
			}
		});
		jamjungThjread.start();
		try {
			jamjungThjread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void getJamjungData(int i){
		isRunning = true;
		System.out.println("k>TestThread.print - : " + i+"sec.");	//test+++
		isRunning = false;
	}
}
