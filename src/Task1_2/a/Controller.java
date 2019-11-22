package Task1_2.a;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.io.*;

public class Controller {
    @FXML
    LineChart<Integer,Integer> chart ;
    @FXML
    void initialize() throws IOException {
        ObservableList<XYChart.Series<Integer,Integer>> lineChartData = FXCollections.observableArrayList();
        LineChart.Series<Integer,Integer> series = new LineChart.Series<>();
        BufferedReader bf = new BufferedReader(new FileReader(new File("temp2.csv")));
        String line;
        while ((line=bf.readLine())!=null ){
            if(line.substring(3,5).equals("04")) {
                int d = Integer.parseInt(line.substring(0, 2));
                int t = Integer.parseInt(line.substring(11));
                series.getData().add(new XYChart.Data<>(d, t));
            }
        }
        series.setName("Апрель");
        lineChartData.add(series);
        chart.setData(lineChartData);
    }
}
