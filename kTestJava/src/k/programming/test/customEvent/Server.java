package k.programming.test.customEvent;

public class Server {

	public Server() {}
	public void start() {
		MyThread thread1 = new MyThread("1");
		MyThread thread2 = new MyThread("2");
		MyThread thread3 = new MyThread("3");
		MyThread thread4 = new MyThread("4");
		MyThread thread5 = new MyThread("5");

		MyEvent a = new MyEvent();
		thread1.addMyThreadListener(a);
		thread2.addMyThreadListener(a);
		thread3.addMyThreadListener(a);
		thread4.addMyThreadListener(a);
		thread5.addMyThreadListener(a);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		System.out.println("running...");
	}

	public static void main(String[] args) {
		(new Server()).start();
	}

}

class MyEvent extends MyEventAdapter { //implements MyEventListener {

	public void actionPerformed(Object my) {
		System.out.println( ((MyThread)my).getNames() + " end.");
	}

}