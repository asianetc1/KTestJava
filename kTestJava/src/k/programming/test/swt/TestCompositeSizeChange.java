package k.programming.test.swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

public class TestCompositeSizeChange {

	static Display display = Display.getDefault();
	static Shell shell = new Shell();
	static Composite comp0 = new Composite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	
	static boolean isbig0 = false;
	static Rectangle small0 = new Rectangle(10, 33, 300, 515);
	static Rectangle big0 = new Rectangle(10, 33, 600, 515);
	
	public static void main(String[] args) {
		shell.setSize(768, 596);
		shell.setText("SWT Application");
		
		comp0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(isbig0==false){
					comp0.setBounds(big0);
					isbig0 = true;
				} else {
					comp0.setBounds(small0);
					isbig0 = false;
				}						
			}
		});
		comp0.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		comp0.setBounds(small0);
		
		Label lblNewLabel = new Label(comp0, SWT.NONE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				MessageBox m = new MessageBox(shell);
				m.setMessage("aaaaaaaaaaaaaaaaaaa");
				m.open();
			}
		});
		lblNewLabel.setBounds(26, 48, 56, 15);
		lblNewLabel.setText("New Label");
		
		Button button = new Button(shell, SWT.RIGHT);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(isbig0==false){
					comp0.setBounds(big0);
					isbig0 = true;
				} else {
					comp0.setBounds(small0);
					isbig0 = false;
				}				
			}
		});
		button.setBounds(234, 10, 76, 17);
		button.setText("▶ ");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
