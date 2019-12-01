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

public class TestTextFont {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestTextFont window = new TestTextFont();
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
		shell.setSize(371, 355);
		shell.setText("SWT Application");
		
		Label lbl1 = new Label(shell, SWT.NONE);
		lbl1.setAlignment(SWT.CENTER);
		lbl1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl1.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl1.setBounds(10, 10, 336, 54);
		lbl1.setText("TEXT LABEL 테스트 1");
		
		Label lbl2 = new Label(shell, SWT.NONE);
		lbl2.setText("TEXT LABEL 테스트 2");
		lbl2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl2.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl2.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl2.setAlignment(SWT.CENTER);
		lbl2.setBounds(10, 70, 336, 54);
		
		Label lbl3 = new Label(shell, SWT.NONE);
		lbl3.setText("TEXT LABEL 테스트 3");
		lbl3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lbl3.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lbl3.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lbl3.setAlignment(SWT.CENTER);
		lbl3.setBounds(10, 130, 336, 54);
		
		Label lblTextLabel = new Label(shell, SWT.NONE);
		lblTextLabel.setText("TEXT LABEL 테스트 4");
		lblTextLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTextLabel.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lblTextLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblTextLabel.setAlignment(SWT.CENTER);
		lblTextLabel.setBounds(10, 190, 336, 54);
		
		Label lblTextLabel_1 = new Label(shell, SWT.NONE);
		lblTextLabel_1.setText("TEXT LABEL 테스트 5");
		lblTextLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblTextLabel_1.setFont(SWTResourceManager.getFont("맑은 고딕", 24, SWT.BOLD));
		lblTextLabel_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblTextLabel_1.setAlignment(SWT.CENTER);
		lblTextLabel_1.setBounds(10, 250, 336, 54);

	}
}
