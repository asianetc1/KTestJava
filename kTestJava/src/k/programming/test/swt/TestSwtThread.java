package k.programming.test.swt;

import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class TestSwtThread {

	static Display display = Display.getDefault();

	private static Device device = Display.getCurrent ();
	final static Color BLUE = new Color (device, 33, 99, 255);
	final static Color YELLOW = new Color (device, 255,255,0);
	final static Color BLACK = new Color (device, 0, 0, 0);
	final static Color GRAY = new Color (device, 130, 130, 130);
	
	static Shell shell = new Shell();
	static Label label1 = new Label(shell, SWT.NONE);
	static Label label2 = new Label(shell, SWT.NONE);
	static Label label3 = new Label(shell, SWT.NONE);
	static Label label4 = new Label(shell, SWT.NONE);

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestSwtThread window = new TestSwtThread();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @throws InterruptedException 
	 */
	protected void createContents() {
		shell.setSize(594, 411);
		shell.setText("SWT Application");
		
		label1.setBounds(28, 30, 192, 15);
		label1.setText("New Label");
		
		label2.setBounds(28, 70, 98, 15);
		label2.setText("New Label");
		
		label3.setBounds(28, 110, 98, 15);
		label3.setText("New Label");
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				print1(label1);
				blink(label1);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				print1(label2);
				blink(label2);
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				print1(label3);
				blink(label3);
			}
		});
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t2.start();		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		t3.start();		
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		label4.setBounds(28, 150, 98, 15);
		label4.setText("New Label4");

	}

	public static void print1(final Label label) {
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 30000; i++) {
			       if (!label.isDisposed()) {
			    	   label.setText(String.valueOf(i));
			         }
				}
			}
		}); 
	}
	
//	public static void blink(final Label label) {
//		display.asyncExec(new Runnable() {
//			@Override
//			public void run() {
//				label.setBackground(YELLOW);
//				label.update();
//			}
//		}); 
//	}
	
	public static void blink(final Label label) {
	    		display.asyncExec(new Runnable() {
	    			@Override
	    			public void run() {
		    				label.setBackground(YELLOW);
		    				label.update();
		    				try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
		    				label.setBackground(BLUE);
		    				label.update();
	    				}
	    		}); 
	}

}

