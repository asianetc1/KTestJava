package k.programming.test.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IBarSeries;
import org.swtchart.ILineSeries;
import org.swtchart.ISeries.SeriesType;

public class TestChartCategory {

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


		// create a chart
		Chart chart = new Chart(_chartShell, SWT.NONE);
		    
		// set titles
		chart.getTitle().setText("Category Axis Example");
		chart.getAxisSet().getXAxis(0).getTitle().setText("Month");
		chart.getAxisSet().getYAxis(0).getTitle().setText("Amplitude");

		// set category
		chart.getAxisSet().getXAxis(0).enableCategory(true);
		chart.getAxisSet().getXAxis(0).setCategorySeries(
		        new String[] { "Jan", "Feb", "Mar", "Apr", "May" });

		// create bar series
		IBarSeries barSeries1 = (IBarSeries) chart.getSeriesSet().createSeries(
		        SeriesType.BAR, "bar series 1");
		barSeries1.setYSeries(ySeries1);
		barSeries1.setBarColor(Display.getDefault().getSystemColor(
		        SWT.COLOR_GREEN));

		IBarSeries barSeries2 = (IBarSeries) chart.getSeriesSet().createSeries(
		        SeriesType.BAR, "bar series 2");
		barSeries2.setYSeries(ySeries2);

		// adjust the axis range
		chart.getAxisSet().adjustRange();
		
//		
//		
//		createChart(_chartShell);
//		
//		ySeries1[0]=10;
//		ySeries2[0]=15;
//		createChart(_chartShell);

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
		chart.getTitle().setText("Area Chart");

		// create line series
		ILineSeries lineSeries1 = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "line series 1");
		lineSeries1.setYSeries(ySeries1);
		lineSeries1.setLineColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		lineSeries1.enableArea(true);

		ILineSeries lineSeries2 = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "line series 2");
		lineSeries2.setYSeries(ySeries2);
		lineSeries2.enableArea(true);

		// adjust the axis range
		chart.getAxisSet().adjustRange();

		return chart;
	}	
	
}
