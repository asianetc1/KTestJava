package k.programming.test.customEvent;

public class MyThread extends Thread {

	private MyEventListener event;
	private String name;

	public MyThread(String name) {
		this.name = name;
	}

	public String getNames() {
		return name;
	}

	public void addMyThreadListener(MyEventListener event) {
		this.event = event;
	}

	public void run() {
		try {
			sleep(1000);
			event.actionPerformed(this);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}