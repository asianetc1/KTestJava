package k.programming.test.swt;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;

public class TestCanvas {

	protected Shell shlSwtCanvasEx;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestCanvas window = new TestCanvas();
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
		shlSwtCanvasEx.open();
		shlSwtCanvasEx.layout();
		while (!shlSwtCanvasEx.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	static Composite composite;
	static Canvas canvas;
	static ArrayList<int[]> signals;	//!!!
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSwtCanvasEx = new Shell();
		shlSwtCanvasEx.setBounds(200, 0, 450, 300);
		shlSwtCanvasEx.setText("SWT Canvas Ex");
		shlSwtCanvasEx.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				composite.setBounds(0, 0, shlSwtCanvasEx.getBounds().width, shlSwtCanvasEx.getBounds().height);
				canvas.setBounds(new Rectangle(0, 0, composite.getBounds().width, composite.getBounds().height));
				drawSignals(canvas, signals);	//!!!
			}
		});
		
		composite = new Composite(shlSwtCanvasEx, SWT.NONE);
		composite.setBounds(0, 0, shlSwtCanvasEx.getBounds().width, shlSwtCanvasEx.getBounds().height);
		
		canvas = new Canvas(composite, SWT.NONE);
		canvas.setBounds(new Rectangle(0, 0, composite.getBounds().width, composite.getBounds().height));

		//===============================================
		signals = new ArrayList<int[]>();
		int[] v5 = new int[]{1, 0, -1, 1, 0, -1};	//5분전 대비
		int[] v10 = new int[]{1, 1, -1, 1, 0, -1};	//10분전 대비
		int[] v30 = new int[]{1, 0, -1, 1, 0, -1};	//30분전 대비
		signals.add(v5);
		signals.add(v10);
		signals.add(v30);
		drawSignals(canvas, signals);
		//===============================================
	}

	
	
	//====================================================================
	static int w;
	static int h;
	/**
	 * 시그널
	 * 		코스피+코스닥+외인선물
	 * 		단+프+파
	 * @param canvas
	 */
	public void drawSignals(Canvas canvas, ArrayList<int[]> arrays) {
		canvas.setToolTipText("중국, 코스피, 코스닥, 외인선물, 단주, 프로그램, 파바박\n   ■10분전 대비 상승/하락\n   ※상승=빨강, 하락=파랑 ");
		
		w = canvas.getSize().x/6;
		h = canvas.getSize().y/3;
		
		for (int i = 0; i < arrays.size(); i++) {
			drawSignal(canvas, w*0, h*i, w, h, arrays.get(i)[0]);
			drawSignal(canvas, w*1, h*i, w, h, arrays.get(i)[1]);
			drawSignal(canvas, w*2, h*i, w, h, arrays.get(i)[2]);
			drawSignal(canvas, w*3, h*i, w, h, arrays.get(i)[3]);
			drawSignal(canvas, w*4, h*i, w, h, arrays.get(i)[4]);
			drawSignal(canvas, w*5, h*i, w, h, arrays.get(i)[5]);
		}
		canvas.update();
	}

	/**
	 * 
	 * @param canvas
	 */
	public void drawSignal(Canvas canvas, final int x, final int y, final int w, final int h, final int v) {
		canvas.addPaintListener(new PaintListener() {
		      public void paintControl(PaintEvent e) {
		    	 if(v>0)
		    		 e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_RED));
		    	 if(v<0)
		    		 e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_BLUE));
		    	 if(v==0)
		    		 e.gc.setBackground(e.display.getSystemColor(SWT.COLOR_GRAY));
		    	 e.gc.fillRectangle(x, y, w, h);
		      }
		    });
	}
	//====================================================================
	
	
}
