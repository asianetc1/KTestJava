package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IAxis;
import org.swtchart.IAxis.Position;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries.SeriesType;

public class TestMultiAxisChart {

	private static final double[] ySeries1 = { 0.1, 0.38, 0.71, 0.92, 1.0 };
	private static final double[] ySeries2 = { 1.2, 3.53, 3.1, 0.1, 0.5 };

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell _chartShell = new Shell();
		_chartShell.setSize(600,500);
		_chartShell.setText("SWT Chart 1");
		_chartShell.setLayout(new FillLayout());

		createChart(_chartShell);
		
		_chartShell.open();
		_chartShell.layout();
		while (!_chartShell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
	}

	/**
	 * create the chart.
	 * 
	 * @param parent
	 *            The parent composite
	 * @return The created chart
	 */
	static public Chart createChart(Composite parent) {

		// create a chart
		Chart chart = new Chart(parent, SWT.NONE);
		    
		// set titles
		chart.getTitle().setText("Multiple Axes Example");
		chart.getAxisSet().getXAxis(0).getTitle().setText("Data Points");
		chart.getAxisSet().getYAxis(0).getTitle().setText("Amplitude 1");

		// create second Y axis
		int axisId = chart.getAxisSet().createYAxis();

		// set the properties of second Y axis
		IAxis yAxis2 = chart.getAxisSet().getYAxis(axisId);
		yAxis2.setPosition(Position.Secondary);
		final Color RED = Display.getDefault().getSystemColor(SWT.COLOR_RED);
		yAxis2.getTick().setForeground(RED);
		yAxis2.getTitle().setForeground(RED);
		yAxis2.getTitle().setText("Amplitude 2");

		// create line series
		ILineSeries lineSeries1 = (ILineSeries) chart.getSeriesSet()
		        .createSeries(SeriesType.LINE, "line series 1");
		lineSeries1.setYSeries(ySeries1);
		ILineSeries lineSeries2 = (ILineSeries) chart.getSeriesSet()
		        .createSeries(SeriesType.LINE, "line series 2");
		lineSeries2.setYSeries(ySeries2);
		lineSeries2.setLineColor(RED);

		// assign series to second Y axis
		lineSeries2.setYAxisId(axisId);

		// adjust the axis range
		chart.getAxisSet().adjustRange();
		
		chart.redraw();
		
		return chart;
	}	
	
}
