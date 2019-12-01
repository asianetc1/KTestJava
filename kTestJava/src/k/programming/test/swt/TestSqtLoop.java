package k.programming.test.swt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Shell;

public class TestSqtLoop {

	private static Display display = Display.getDefault();
	private static Device device = Display.getCurrent ();
	private static Shell shell0 = new Shell();
	final static Composite comp0 = new Composite(shell0, 0);
	final static Canvas canvas = new Canvas(comp0, SWT.NONE);
    private static List<Item> items = new ArrayList<Item>();
    final static Color RED = new Color (device, 255, 0, 0);

	public static void main(String[] args) {
		comp0.setBounds(0, 0, 500, 500);
		
		canvas.setBounds(0, 0, 500, 500);
		canvas.setBackground(RED);
        canvas.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent event) {
                GC gc = event.gc;

                int x = 0;
                for (int i = 0; i < 100; i++) {
                    Color color = new Color(device, i, i,255);
                    gc.setBackground(color);
                    gc.fillRectangle(x, x, 50, 50);
                    x += 20;
                }
                
            }
        });
        
		shell0.open();
		shell0.layout();
		while (!shell0.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}        
        
    }

    public void setItems(List<Item> items) {
        this.items = items;
        canvas.redraw();
    }

}
