import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class TesteSIM
{

    public static void main(String args[]){

        //for (int i = 0; i < 50; i++) {
        //    //    System.out.println(Math.random());
        //    System.out.println(i % 4);
        //}

        // create a dataset...
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Category 1", 43.2);
        data.setValue("Category 2", 27.9);
        data.setValue("Category 3", 79.5);
        // create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
        "Sample Pie Chart",
        data,
        true, // legend?
        true, // tooltips?
        false // URLs?
        );
        // create and display a frame...
        ChartFrame frame = new ChartFrame("First", chart);
        frame.pack();
        frame.setVisible(true);
    }
}

