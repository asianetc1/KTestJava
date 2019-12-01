package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;

public class TestCursor {

	private static boolean wait = false;

	private static Cursor cursor = null;

	public static void main(String[] args) {
	    final Display display = new Display();
	    final Shell shell = new Shell(display);
	    shell.setLayout(new FillLayout());

	    Button button = new Button(shell, SWT.PUSH);
	    button.setText("Change cursor");

	    button.addListener(SWT.Selection, new Listener() {

	        @Override
	        public void handleEvent(Event arg0) {
	            wait = !wait;

	            if(cursor != null)
	                cursor.dispose();

	            cursor = wait ? new Cursor(display, SWT.CURSOR_WAIT) : new Cursor(display, SWT.CURSOR_ARROW);

	            shell.setCursor(cursor);
	        }
	    });


	    shell.setSize(200,200);
	    
	    List list = new List(shell, SWT.BORDER);
	    list.setItems(new String[] {"111 aaa", "222 bbb"});
	    shell.open();
	    while (!shell.isDisposed()) {
	        if (!display.readAndDispatch()) {
	            display.sleep();
	        }
	    }
	    display.dispose();

	    if(cursor != null)
	        cursor.dispose();
	}

}
