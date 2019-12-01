package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class TestSwtCanvas {

	static Display display = Display.getDefault();
	static Shell shell = new Shell();
	static Canvas canvas = new Canvas(shell, SWT.NONE);

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {

		shell.setSize(450, 300);
		shell.setText("SWT Application");
		canvas.setBounds(10, 10, 172, 151);

		
		aa(canvas);
		shell.open();
		shell.layout();

		bb(canvas);
		shell.open();
		shell.layout();
		
		cc(canvas);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(258, 88, 56, 55);
		lblNewLabel.setText("New Label");
		//Image image = new Image(display, "c:/kStock/view_xls.gif");
		Image image = new Image(display, "D:/java_project/KTestJava/src/k/programming/test/swt/view_xls.gif");
		lblNewLabel.setImage(image);
		
		shell.layout();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
	}

	private static void cc(Canvas canvas) {
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
	}

	private static void bb(Canvas canvas) {
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void aa(Canvas canvas) {
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
