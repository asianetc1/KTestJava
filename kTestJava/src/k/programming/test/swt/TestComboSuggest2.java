package k.programming.test.swt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class TestComboSuggest2 {

	protected Shell shell;
	private Text condCompanyNo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestComboSuggest2 window = new TestComboSuggest2();
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
		shell.setSize(186, 300);
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
		

		//=========================================
		//=========================================
		final String[] companyItems = new String[] {
				  "333333 하늘", "123456 한국건설","111111 aaa", "123891 bbb"
				, "169999 ffyfff1fff", "622222 한국화장", "233133"
				, "069999 ffyfff1fff", "622222 한국화장2", "233133"
				, "498999 ffffff2fff", "222321 대상bbb", "133343"
				};
		
		final org.eclipse.swt.widgets.List list = new org.eclipse.swt.widgets.List(shell, SWT.BORDER);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
		        String selectionText = list.getSelection()[0];
		        System.out.println("selectionText={" + selectionText + "}");
			}
		});

		list.setItems(companyItems);
		list.setBounds(0, 22, 170, 240);
		
		condCompanyNo = new Text(shell, SWT.BORDER);
		condCompanyNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
        		shell.setImeInputMode(SWT.NATIVE);	//한글입력모드!!!
        		condCompanyNo.selectAll();
			}
		});
		condCompanyNo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				condCompanyNo.getText();
				List<String> itemsTempArray = new ArrayList<String>();
				for (int i = 0; i < companyItems.length; i++) { 
					if(condCompanyNo.getText().trim().equals(""))
						itemsTempArray.add(companyItems[i]);
					else if( companyItems[i].indexOf(condCompanyNo.getText().trim()) > -1) 
						itemsTempArray.add(companyItems[i]);
				}
				if(itemsTempArray.size()>0){
					list.setVisible(true);
					String[] itemsTemp = new String[itemsTempArray.size()];
					itemsTemp = itemsTempArray.toArray(itemsTemp);
					list.setItems(itemsTemp);
					list.setSelection(0);
				}				
			}
		});
		condCompanyNo.setBounds(0, 0, 170, 21);
		
		condCompanyNo.setFocus();
		//=========================================
		//=========================================
	}
}
