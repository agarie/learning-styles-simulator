package gui;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
//import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import java.io.File;
import java.io.IOException;
import java.awt.BasicStroke;
import java.awt.Font;

public class Grafico extends ApplicationFrame {
    private static JFreeChart chart; 
    public Grafico(String title, XYSeries series1, XYSeries series2, String labelX, String labelY) {
        super(title);
        XYDataset dataset;
//        if (series1 == null)
//               dataset = createDataset1(series2);
//        else 
               dataset = createDataset(series1, series2);
        this.chart = createChart(title, dataset, labelX, labelY);
        //LegendTitle legend = chart.getLegend();
        //if (legend != null) {
        this.chart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 12));
        //}
        //MUDAR POSICAO DA LEGENDA
        //legend.setPosition(RectangleEdge.BOTTOM);
        //legend.setHorizontalAlignment(HorizontalAlignment.RIGHT);        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(620,410));
        setContentPane(chartPanel);
    }
    
    private static XYDataset createDataset(XYSeries series1, XYSeries series2) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        if (series1 != null) dataset.addSeries(series1);
        if (series2 != null) dataset.addSeries(series2);
        return dataset;
    }
    
    private static JFreeChart createChart(String title, XYDataset dataset, String labelX, String labelY  ) {
        // create the chart...
        
        JFreeChart chart = ChartFactory.createXYLineChart(
        "", // chart title
        labelX, // x axis label
        labelY, // y axis label
        dataset, // data
        PlotOrientation.VERTICAL,
        true, // include legend        
        true, // tooltips
        false // urls
        );
        
        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);
        // get a reference to the plot for further customisation...
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
//        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setAxisOffset(new RectangleInsets(0.05, 0.05, 0.05, 0.05));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
//      renderer.setShapesVisible(true);
//      renderer.setShapesFilled(true);
        // change the auto tick unit selection to integer units only...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());        
        //Alterar fonte
        rangeAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 12));
        rangeAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 12));                        
        domain.setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));
        domain.setLabelFont(new Font("SansSerif", Font.BOLD, 12));        
        // OPTIONAL CUSTOMISATION COMPLETED.
        // customise the renderer...
        //LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        //renderer.setShapesVisible(true);
        //cores das linhas no grafico
        renderer.setSeriesPaint(0, Color.black);
        renderer.setSeriesPaint(1, Color.gray);
        renderer.setStroke(new BasicStroke(3f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setSeriesItemLabelFont(0, new Font("SansSerif", Font.BOLD, 12));
        renderer.setSeriesItemLabelFont(1, new Font("SansSerif", Font.BOLD, 12));
        //renderer.setItemLabelFont(new Font("SansSerif", Font.BOLD, 14));
        //renderer.setFillPaint(Color.white);
        return chart;
    }

//    public static JPanel createDemoPanel() {
//        JFreeChart chart = createChart(createDataset());
//        return new ChartPanel(chart);
//    }

    public static void gerar(String titulo, String filename, XYSeries series1, XYSeries series2, String labelX, String labelY) {
        Grafico g = new Grafico(titulo, series1, series2, labelX, labelY);
        g.pack();
        RefineryUtilities.centerFrameOnScreen(g);
        g.setVisible(true);
        File f = new File(filename);
        try{
            ChartUtilities.saveChartAsJPEG(f, chart, 620,410);
        }
        catch (IOException e){
            System.out.println("Erro ao salvar o grafico: "+e.toString());     
        }        
        catch (Exception es){
            System.out.println("Erro ao salvar o grafico. "+es.toString());
        }        

    }        
}