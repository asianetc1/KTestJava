package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TestSwtCanvasRect {

	protected Shell shell;
	static Canvas canvas;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestSwtCanvasRect window = new TestSwtCanvasRect();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
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
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(536, 352);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		//
		canvas = new Canvas(shell, SWT.NONE);
		
		//
		Button btnRedraw = new Button(canvas, SWT.NONE);
		btnRedraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				canvas.redraw();
			}
		});
		btnRedraw.setBounds(434, 10, 76, 25);
		btnRedraw.setText("Redraw");

		//
	    canvas.addPaintListener(new PaintListener() {
	      public void paintControl(PaintEvent e) {
	        Rectangle rect = ((Canvas) e.widget).getBounds();
	        
		        for (int i = 0; i < 200; i=i+20) {
			        e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_RED));
		        	e.gc.fillRectangle(0, i, 400, 10);
		        	e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_BLUE));
		        	e.gc.fillRectangle(0, i+10, 230, 10);
		        }
		        //canvas.redraw();
	      }
	    });

	}
}







