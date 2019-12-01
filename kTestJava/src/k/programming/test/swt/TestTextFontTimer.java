package k.programming.test.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;

public class TestTextFontTimer {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestTextFontTimer window = new TestTextFontTimer();
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
		
		blink(lbl1);
		blink(lbl2);
		blink(lbl3);
		blink(lbl4);
		blink(lbl5);
		 
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	

	public void blink(final Label lbl1) {
			Display.getCurrent().timerExec(500, new Runnable() {
				 public void run() {
					 lbl1.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
					 lbl1.getParent().update();
				 }
			 });
			
			Display.getCurrent().timerExec(1000, new Runnable() {
				public void run() {
					lbl1.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
					lbl1.update();
				}
			});
			

	}

	
	Label lbl1;
	Label lbl2;
	Label lbl3;
	Label lbl4;
	Label lbl5;
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(371, 355);
		shell.setText("SWT Application");
		
		lbl1 = new Label(shell, SWT.NONE);
		lbl1.setAlignment(SWT.CENTER);
		lbl1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl1.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl1.setBounds(10, 10, 336, 54);
		lbl1.setText("TEXT LABEL 테스트 1");
		
		lbl2 = new Label(shell, SWT.NONE);
		lbl2.setText("TEXT LABEL 테스트 2");
		lbl2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl2.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl2.setAlignment(SWT.CENTER);
		lbl2.setBounds(10, 70, 336, 54);
		
		lbl3 = new Label(shell, SWT.NONE);
		lbl3.setText("TEXT LABEL 테스트 3");
		lbl3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl3.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl3.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl3.setAlignment(SWT.CENTER);
		lbl3.setBounds(10, 130, 336, 54);
		
		lbl4 = new Label(shell, SWT.NONE);
		lbl4.setText("TEXT LABEL 테스트 4");
		lbl4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl4.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl4.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl4.setAlignment(SWT.CENTER);
		lbl4.setBounds(10, 190, 336, 54);
		
		lbl5 = new Label(shell, SWT.NONE);
		lbl5.setText("TEXT LABEL 테스트 5");
		lbl5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl5.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl5.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl5.setAlignment(SWT.CENTER);
		lbl5.setBounds(10, 250, 336, 54);

	}
}
