package k.programming.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	public static void main(String[] args) {
	      ScheduledJob job = new ScheduledJob();
	      Timer timer = new Timer();
	      timer.scheduleAtFixedRate(job, 1000, 2000);
	      try {
	         Thread.sleep(10000);
	      } catch(InterruptedException ex) {
	      }
	      timer.cancel();
	   }
}


class ScheduledJob extends TimerTask {
	   public void run() {
	      System.out.println(new Date());
	   }
}