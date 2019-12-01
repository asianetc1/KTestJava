package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class TestTableCheckbox {

  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    Table table = new Table(shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
    table.setBackground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
    table.setLocation(0, 0);
    for (int i = 0; i < 3; i++) {
      TableItem item = new TableItem(table, SWT.NONE);
      item.setText("Item " + i);
    }
    table.setSize(174, 152);

    shell.setSize(200, 200);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}