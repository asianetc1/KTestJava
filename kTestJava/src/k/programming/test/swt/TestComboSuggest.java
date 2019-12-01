package k.programming.test.swt;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class TestComboSuggest {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestComboSuggest window = new TestComboSuggest();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		//shell.setLayout(new FormLayout());
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 0, 0);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 221);
		fd_composite.right = new FormAttachment(0, 329);
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new GridLayout(1, false));
		
		final String[] items = new String[] {
				"111111 aaa", "11345 fffffffff", "123891 bbb", "333333", "123456"
				, "299999 ffffffff4f", "002292 bbb", "333933"
				, "399999 ffffff1fff", "622222 bbb", "233133"
				, "499999 ffffff2fff", "222321 bbb", "133343"
				, "599999 gffffff3ff", "622522 bbb", "735433"
				, "699999 fffffff4ff", "122122 bbb", "459033"
				};
		final Combo combo = new Combo(shell, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				if(combo.getText().trim().length()>0) {
					if(!combo.getListVisible()) combo.setListVisible(true);
					String[] itemsTemp = new String[] {};
					for (int i = 0; i < items.length; i++) { 
						if( items[i].indexOf(combo.getText().trim()) > -1) {
							combo.select(i);
							break;
						}
					}
				}
			}
		});
		combo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!combo.getListVisible()) combo.setListVisible(true);
			}
		});
		combo.addMouseWheelListener(new MouseWheelListener() {
			public void mouseScrolled(MouseEvent e) {
				System.out.println("k>TestCombo.createContents().new MouseWheelListener() {...}.mouseScrolled - e.count:" + e.count);	//test+++
				System.out.println("k>TestCombo.createContents().new MouseWheelListener() {...}.mouseScrolled - combo.getListVisible():" + combo.getListVisible());	//test+++
				if(!combo.getListVisible()) combo.setListVisible(true);
				if(e.count==1){
					combo.select(combo.getSelectionIndex()-1);
				} else if(e.count==-1){
					combo.select(combo.getSelectionIndex()+1);
				}
			}
		});

		combo.setItems(items);
		combo.setBounds(39, 34, 220, 28);
		//combo.select(0);
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(45, 94, 88, 23);
		
	}
}
