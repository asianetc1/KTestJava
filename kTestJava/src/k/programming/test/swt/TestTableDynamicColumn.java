package k.programming.test.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;

public class TestTableDynamicColumn {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestTableDynamicColumn window = new TestTableDynamicColumn();
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
		shell.setSize(577, 391);
		shell.setText("SWT Application");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(37, 10, 298, 310);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		DropTarget dropTarget = new DropTarget(table, DND.DROP_MOVE);
		
		DragSource dragSource_1 = new DragSource(shell, DND.DROP_MOVE);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(385, 126, 88, 24);
		
		Tree tree = new Tree(shell, SWT.BORDER);
		tree.setBounds(352, 206, 166, 137);
		
		TreeColumn trclmnCcccccccc = new TreeColumn(tree, SWT.NONE);
		trclmnCcccccccc.setWidth(100);
		trclmnCcccccccc.setText("ccccccccc");
		
		TreeColumn trclmnAaaaaa = new TreeColumn(tree, SWT.NONE);
		trclmnAaaaaa.setWidth(100);
		trclmnAaaaaa.setText("aaaaaa");
		
		//	>MySQL 메타데이터
		//	select * 
		//	from information_schema.COLUMNS
		//	where TABLE_NAME='danju' and TABLE_SCHEMA='stock';
		
		for (int i = 0; i < 2; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE, i);
			column.setWidth(100);
			column.setText("칼럼"+i);
		}

		for (int i = 0; i < 5; i++) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			for (int j = 0; j < 2; j++) {
				tableItem.setText(j, "항목"+i+j);
			}
			
		}
	}
}
