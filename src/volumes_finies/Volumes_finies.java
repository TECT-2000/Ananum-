package volumes_finies;

import Equation_1D.Equation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import resolution.ThomasMethod;

/**
 *
 * @author Mike Tsebo
 */
public class Volumes_finies extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        Equation test = new Equation(99, 0.0, 1.0);
        ThomasMethod resolution = new ThomasMethod(test.getMatrice(), test.getVecteurB());
        System.out.println(test.getMatrice().getOrdre());
        resolution.resolv();

        System.out.println("matrice : " + test.getMatrice() + "\n\n");
        System.out.println("VecteurB : " + test.getVecteurB() + "\n\n");
        System.out.println("Maillage : " + test.getPointsDuMaillage() + "\n\n");
        System.out.println("ImagesMaillage : " + test.getImagesPtsDuMaillage() + "\n\n");
        System.out.println("Solution : " + resolution.getSolution() + "\n\n");
        
        stage.setTitle("Line chart");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        final LineChart<Number,Number> linechart=new LineChart<>(xAxis,yAxis);
        linechart.setTitle("Volumes finis VS Réalité");
        
        XYChart.Series series=new XYChart.Series();
        series.setName("exp(x)");
        
        for(int i=0;i<=99;i++){
        
            /*double f_x=Math.sin(Math.PI*i/100.0);
            double pi_carre=Math.PI*Math.PI;*/
            double value=-2;
            series.getData().add(new XYChart.Data<>(i/100.0, value));
        }
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Volumes finis");    
        for(int i=0;i<resolution.getSolution().size();i++){
        
            series2.getData().add(new XYChart.Data<>(test.getPointsDuMaillage().get(i),resolution.getSolution().get(i)));
        }
        
        Scene scene = new Scene(linechart,800,600);
        linechart.getData().addAll(series,series2);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 
    

    
}
