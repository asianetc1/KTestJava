package k.programming.test.swt;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.IAxis.Position;
import org.swtchart.IBarSeries;
import org.swtchart.ILineSeries;
import org.swtchart.ILineSeries.PlotSymbolType;
import org.swtchart.ISeries.SeriesType;
import org.swtchart.ISeriesLabel;
import org.swtchart.Range;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;

public class TestSwtMultiCharts  extends TimerTask {
	static Display display = new Display();
	static Shell shell = new Shell();
	static Shell enlargeShell = new Shell();

	static Composite chartCompositeRow1 = new Composite(shell, SWT.NONE);
	static Composite chartCompositeRow2 = new Composite(shell, SWT.NONE);
	static Composite chartCompositeRow3 = new Composite(shell, SWT.NONE);
	static Composite chartCompositeRow4 = new Composite(shell, SWT.NONE);

	static Chart chart1 = new Chart(chartCompositeRow1, SWT.NONE);
	static Chart chart2 = new Chart(chartCompositeRow1, SWT.NONE);
	static Chart chart3 = new Chart(chartCompositeRow1, SWT.NONE);
	static Chart chart4 = new Chart(chartCompositeRow1, SWT.NONE);
	static Chart chart5 = new Chart(chartCompositeRow1, SWT.NONE);
	static Chart chart6 = new Chart(chartCompositeRow1, SWT.NONE);

	static Chart chart7 = new Chart(chartCompositeRow2, SWT.NONE);
	static Chart chart8 = new Chart(chartCompositeRow2, SWT.NONE);
	static Chart chart9 = new Chart(chartCompositeRow2, SWT.NONE);
	static Chart chart10 = new Chart(chartCompositeRow2, SWT.NONE);
	static Chart chart11 = new Chart(chartCompositeRow2, SWT.NONE);
	static Chart chart12 = new Chart(chartCompositeRow2, SWT.NONE);
	
	static Chart chart13 = new Chart(chartCompositeRow3, SWT.NONE);
	static Chart chart14 = new Chart(chartCompositeRow3, SWT.NONE);
	static Chart chart15 = new Chart(chartCompositeRow3, SWT.NONE);
	static Chart chart16 = new Chart(chartCompositeRow3, SWT.NONE);
	static Chart chart17 = new Chart(chartCompositeRow3, SWT.NONE);
	static Chart chart18 = new Chart(chartCompositeRow3, SWT.NONE);
	
	static Chart chart19 = new Chart(chartCompositeRow4, SWT.NONE);
	static Chart chart20 = new Chart(chartCompositeRow4, SWT.NONE);
	static Chart chart21 = new Chart(chartCompositeRow4, SWT.NONE);
	static Chart chart22 = new Chart(chartCompositeRow4, SWT.NONE);
	static Chart chart23 = new Chart(chartCompositeRow4, SWT.NONE);
	static Chart chart24 = new Chart(chartCompositeRow4, SWT.NONE);
	
	
	//마우스 이벤트용
	static Composite compChart1 = chart1.getPlotArea();
	static Composite compChart2 = chart2.getPlotArea();
	static Composite compChart3 = chart3.getPlotArea();
	static Composite compChart4 = chart4.getPlotArea();
	static Composite compChart5 = chart5.getPlotArea();
	static Composite compChart6 = chart6.getPlotArea();
	static Composite compChart7 = chart7.getPlotArea();
	static Composite compChart8 = chart8.getPlotArea();
	static Composite compChart9 = chart9.getPlotArea();
	static Composite compChart10 = chart10.getPlotArea();
	static Composite compChart11 = chart11.getPlotArea();
	static Composite compChart12 = chart12.getPlotArea();
	static Composite compChart13 = chart13.getPlotArea();
	static Composite compChart14 = chart14.getPlotArea();
	static Composite compChart15 = chart15.getPlotArea();
	static Composite compChart16 = chart16.getPlotArea();
	static Composite compChart17 = chart17.getPlotArea();
	static Composite compChart18 = chart18.getPlotArea();
	static Composite compChart19 = chart19.getPlotArea();
	static Composite compChart20 = chart20.getPlotArea();
	static Composite compChart21 = chart21.getPlotArea();
	static Composite compChart22 = chart22.getPlotArea();
	static Composite compChart23 = chart23.getPlotArea();
	static Composite compChart24 = chart24.getPlotArea();

	static boolean isRunning = false;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
        TimerTask timerTask = new TestSwtMultiCharts();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 30*1000);

        shell.setSize(1800,1050);
		shell.setText("SWT Chart 1");
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		//shell.setLayout(new GridLayout(6, false));
		
		chartCompositeRow1.setBounds(0,20,shell.getSize().x, (shell.getSize().y-20)/4);
		chartCompositeRow1.setLayout(new FillLayout(SWT.HORIZONTAL));

		chartCompositeRow2.setBounds(0,20+(shell.getSize().y-20)/4,shell.getSize().x, (shell.getSize().y-20)/4);
		chartCompositeRow2.setLayout(new FillLayout(SWT.HORIZONTAL));

		chartCompositeRow3.setBounds(0,20+(shell.getSize().y-20)/4*2,shell.getSize().x, (shell.getSize().y-20)/4);
		chartCompositeRow3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		chartCompositeRow4.setBounds(0,20+(shell.getSize().y-20)/4*3,shell.getSize().x, (shell.getSize().y-20)/4);
		chartCompositeRow4.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			//System.out.println("k>TestSwtMultiCharts.main - chart1:" + chart1);	//test+++
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}		
		if(null!=display)display.dispose();		
	}

	public static void drawCharts() {
		isRunning = true;

		chart1 = drawChart(chart1,0);
		chart2 = drawChart(chart2,1);
		chart3 = drawChart(chart3,2);
		chart4 = drawChart(chart4,3);
		chart5 = drawChart(chart5,4);
		chart6 = drawChart(chart6,5);
		chart7 = drawChart(chart7,6);
		chart8 = drawChart(chart8,7);
		chart9 = drawChart(chart9,8);
		chart10 = drawChart(chart10,9);
		chart11 = drawChart(chart11,10);
		chart12 = drawChart(chart12,11);
		chart13 = drawChart(chart13,12);
		chart14 = drawChart(chart14,13);
		chart15 = drawChart(chart15,14);
		chart16 = drawChart(chart16,15);
		chart17 = drawChart(chart17,16);
		chart18 = drawChart(chart18,17);
		chart19 = drawChart(chart19,18);
		chart20 = drawChart(chart20,19);
		chart21 = drawChart(chart21,20);
		chart22 = drawChart(chart22,21);
		chart23 = drawChart(chart23,22);
		chart24 = drawChart(chart24,23);

		isRunning = false;
	}
	
	static public Chart drawChart(Chart chart, int companyNosIndex) {

		//data from db
		double[] ySeries1 = { 0.1, 1.3, 2.71, 0.92, 1.0 };
		double[] ySeries2 = { 1.2, 2.3, 1.6, 0.7, 1.5 };
		double[] ySeries3 = { 0.0, 0.2, -0.8, 0.0, -0.5 };
		double[] ySeries4 = { -1.5,-1.5, 2.1, 2.1, 2.1 };	//외인
		double[] ySeries5 = { 1.8, 1.8, 3.7, 3.7, 3.7 };

		chart.setVisible(false);
		
		//차트설정
		if(chart.getAxisSet().getYAxisIds().length < 2){
			chart.getAxisSet().getYAxis(chart.getAxisSet().createYAxis()).setPosition(Position.Secondary);
		}
		
		chart.getTitle().setText("123456 제이씨현");	//@@@
		chart.getLegend().setVisible(false);
		chart.getAxisSet().getXAxis(0).getTitle().setVisible(false);
		chart.getAxisSet().getYAxis(0).getTitle().setVisible(false);
		chart.getAxisSet().getYAxis(1).getTitle().setVisible(false);
		
		//단주
		ILineSeries series1 = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "line series 1");
		series1.setYSeries(ySeries1);	//@@@
		series1.setLineColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		series1.setLineWidth(2);
		series1.setSymbolType(PlotSymbolType.NONE);
		series1.setYAxisId(chart.getAxisSet().getYAxisIds()[0]);
		
		//프로그램
		ILineSeries series2 = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "line series 2");
		series2.setYSeries(ySeries2);	//@@@
		series2.setLineColor(Display.getDefault().getSystemColor(SWT.COLOR_BLACK));
		series2.setLineWidth(2);
		series2.setSymbolType(PlotSymbolType.NONE);
		series2.setYAxisId(chart.getAxisSet().getYAxisIds()[0]);

		//파바박
		IBarSeries series3 = (IBarSeries) chart.getSeriesSet().createSeries(SeriesType.BAR, "line series 3");
		series3.setYSeries(ySeries3);	//@@@
		series3.setBarColor(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		series3.setBarWidth(2);
		series3.setYAxisId(chart.getAxisSet().getYAxisIds()[0]);
		ISeriesLabel seriesLabel3 = series3.getLabel();
		seriesLabel3.setFormat("####");
		
		//잠정 외인
		ILineSeries series4 = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "line series 4");
		series4.setYSeries(ySeries4);	//@@@
		series4.setLineColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		series4.enableArea(true);
		//series4.setSymbolType(PlotSymbolType.SQUARE);
		//series4.setSymbolSize(2);
		//series4.setSymbolColor(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		series4.setSymbolType(PlotSymbolType.NONE);
		series4.enableStep(true);
		series4.setYAxisId(chart.getAxisSet().getYAxisIds()[1]);
		
		//잠정 기관
		ILineSeries series5 = (ILineSeries) chart.getSeriesSet().createSeries(SeriesType.LINE, "line series 5");
		series5.setYSeries(ySeries5);	//@@@
		series5.setLineColor(Display.getDefault().getSystemColor(SWT.COLOR_BLUE));
		series5.enableArea(true);
		//series5.setSymbolType(PlotSymbolType.SQUARE);
		//series5.setSymbolSize(2);		
		//series5.setSymbolColor(Display.getDefault().getSystemColor(SWT.COLOR_BLUE));
		series5.setSymbolType(PlotSymbolType.NONE);
		series5.enableStep(true);
		series5.setYAxisId(chart.getAxisSet().getYAxisIds()[1]);

		Range rangeX;
		Range rangeY0;
		Range rangeY1;
		
		rangeX = new Range(0, 15);	//x축 초기 범위.(분)
		chart.getAxisSet().getXAxis(0).setRange(rangeX);
//		rangeY0 = new Range(-1, 1);	//y축 범위: (천만원)
//		rangeY1 = new Range(-1, 1);	//y축 범위2
		
		//x축 범위 조정
		if(ySeries1.length>15) chart.getAxisSet().getXAxis(0).adjustRange();
		
		//y축 범위 조정	0		
		double maxY = 0.0;
		chart.getAxisSet().getYAxis(0).adjustRange();
		for (double d : ySeries1) if(Math.abs(d)>maxY) maxY=Math.abs(d);
		for (double d : ySeries2) if(Math.abs(d)>maxY) maxY=Math.abs(d);
		for (double d : ySeries3) if(Math.abs(d)>maxY) maxY=Math.abs(d);
		rangeY0 = new Range(-maxY, maxY);	//y축 범위1
		chart.getAxisSet().getYAxis(0).setRange(rangeY0);
		
		//y축 범위 조정	1		
		maxY = 0.0;
		for (double d : ySeries4) if(Math.abs(d)>maxY) maxY=Math.abs(d);
		for (double d : ySeries5) if(Math.abs(d)>maxY) maxY=Math.abs(d);
		System.out.println("k>TestSwtMultiCharts.drawChart - maxY:" + maxY);	//test+++
		rangeY1 = new Range(-maxY*1.5, maxY*1.5);	//y축 범위2
		chart.getAxisSet().getYAxis(1).setRange(rangeY1);
		
		chart.redraw();
		chart.setVisible(true);		
		return chart;
	}	

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
    	display.asyncExec (new Runnable () {        
			@Override
			public void run() {
				if(!isRunning)drawCharts();
			}
		});	        
        System.out.println("Timer task finished at:"+new Date());
    }
}
