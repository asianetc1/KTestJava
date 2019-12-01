package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Label;

public class TestMovableModalWinodw {

	private static String title="";
	public static String getTitle() {
		return title;
	}
	public static void setTitle(String title) {
		TestMovableModalWinodw.title = title;
	}
	
	public TestMovableModalWinodw(){}
	public TestMovableModalWinodw(String title){this.setTitle(title);}
	
	static Boolean blnMouseDown=false;
    static int xPos=0;
    static int yPos=0;
    
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		setTitle("123456 종목명");
		createModalWinodw(display, getTitle());
	}

	/**
	 * 모달창 
	 * @param display
	 */
	public static void createModalWinodw(Display display, String title) {
		final Shell shell = new Shell(display, SWT.APPLICATION_MODAL);
		shell.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("k>TestMovableModalWinodw.createModalWinodw(...).new KeyAdapter() {...}.keyPressed - :1111" );	//test+++
				if(e.keyCode==SWT.ESC)shell.dispose();
			}
		});
		shell.setLocation(800, 500);
		shell.setSize(298, 161);
		shell.setText("SWT Application");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				shell.dispose();
			}
		});
		btnNewButton.setBounds(242, 0, 53, 19);
		btnNewButton.setText("close");
		
		Label chartTitle = new Label(shell, SWT.NONE);
		chartTitle.setBounds(0, 0, 200, 15);
		chartTitle.setText(title);

		shell.open();
		shell.layout();
		
		 shell.addMouseListener(new MouseListener() {

	            @Override
	            public void mouseUp(MouseEvent arg0) {
	                blnMouseDown=false;
	            }

	            @Override
	            public void mouseDown(MouseEvent e) {
	                blnMouseDown=true;
	                xPos=e.x;
	                yPos=e.y;
	            }

	            @Override
	            public void mouseDoubleClick(MouseEvent arg0) {
	                // TODO Auto-generated method stub
	            }
	        });
	        shell.addMouseMoveListener(new MouseMoveListener() {
	            @Override
	            public void mouseMove(MouseEvent e) {
	                if(blnMouseDown){
	                    shell.setLocation(shell.getLocation().x+(e.x-xPos),shell.getLocation().y+(e.y-yPos));
	                }
	            }
	        });
	        
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
