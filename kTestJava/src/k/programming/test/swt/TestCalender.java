package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TestCalender {

    public static void main(String[] args) {

        // setup the SWT window
        Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new RowLayout());

        // initialize a parent composite with a grid layout manager
        Composite parent = new Composite(shell, SWT.NONE);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 1;
        parent.setLayout(gridLayout);
        
        final DateTime calendar = new DateTime(parent, SWT.CALENDAR);
        calendar.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        		String pickDate = "";
        		String m = "";
        		if( (calendar.getMonth()+1)<10 ) 
        			m="0"+(calendar.getMonth()+1);
        		pickDate = calendar.getYear() + m +  calendar.getDay();
        		System.out.println("k>TestCalender.main(...).new SelectionAdapter() {...}.widgetSelected - pickDate:" + pickDate);	//t+++
        		shell.close();
        	}
        });
        DateTime date = new DateTime(parent, SWT.DATE);
        DateTime time = new DateTime(parent, SWT.TIME);
        DateTime dateD = new DateTime(parent, SWT.DATE | SWT.DROP_DOWN);
        DateTime dateS = new DateTime(parent, SWT.DATE | SWT.SHORT);

       
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        // tear down the SWT window
        display.dispose();
    }
} 
