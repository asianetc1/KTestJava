package k.programming.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimerDaemon {

	public static void main(String[] args) {
	      ScheduledJobDaemon job = new ScheduledJobDaemon();
	      Timer timer = new Timer(true);
	      timer.scheduleAtFixedRate(job, 1000, 1000);
	      System.out.println("k>TestTimerDaemon.main - :" );	//test+++
	      try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
}


class ScheduledJobDaemon extends TimerTask {
	   public void run() {
	      System.out.println(new Date());
	   }
}