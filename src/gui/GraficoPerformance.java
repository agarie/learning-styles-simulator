package gui;

import java.awt.RenderingHints;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.*;
import java.io.*;
import java.awt.Font;
import org.jfree.chart.plot.XYPlot;
import java.awt.Color;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.ui.RectangleInsets;
import java.awt.BasicStroke;

public class GraficoPerformance extends ApplicationFrame {
    private static JFreeChart jfreechart;
    public GraficoPerformance(final String title, XYSeries series1)
    {
        super(title);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);

        this.jfreechart = ChartFactory.createScatterPlot(title, "", "Performance", dataset, PlotOrientation.VERTICAL, true, true, false);
        this.jfreechart.getLegend().setItemFont(new Font("Dialog", Font.BOLD, 12));

        XYPlot plot = (XYPlot) jfreechart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.gray);
        renderer.setSeriesPaint(1, Color.black);
        renderer.setStroke(new BasicStroke(3f, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL));
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setSeriesItemLabelFont(0, new Font("SansSerif", Font.BOLD, 14));
        renderer.setSeriesItemLabelFont(1, new Font("SansSerif", Font.BOLD, 14));

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //Alterar fonte
        rangeAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 12));
        rangeAxis.setLabelFont(new Font("SansSerif", Font.BOLD, 14));
        domainAxis.setTickLabelFont(new Font("SansSerif", Font.BOLD, 12));
        domainAxis.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));


        final ChartPanel panel = new ChartPanel(this.jfreechart, true);
        panel.setPreferredSize(new java.awt.Dimension(620,410));
        panel.setMinimumDrawHeight(3);
        panel.setMaximumDrawHeight(2000);
        panel.setMinimumDrawWidth(3);
        panel.setMaximumDrawWidth(2000);
        setContentPane(panel);


    }
    //****************************************************************************
    public static void gerar(String titulo, String filename, XYSeries series1) {
        GraficoPerformance g = new GraficoPerformance(titulo, series1);
        g.pack();
        RefineryUtilities.centerFrameOnScreen(g);
        g.setVisible(true);
        File f = new File(filename);
        try{
            ChartUtilities.saveChartAsJPEG(f, jfreechart, 620,410);
        }
        catch (IOException e){
            System.out.println("Erro ao salvar o gráfico: "+e.toString());
        }
        catch (Exception es){
            System.out.println("Erro ao salvar o gráfico. "+es.toString());
        }

    }
}
