package Task1_1.a;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class Controller {
    ObservableList<Day> data = FXCollections.observableArrayList();
    @FXML
    TableView<Day> month;
    @FXML
    TableColumn<Day, Integer> numberColumn;
    @FXML
    TableColumn<Day, Integer> temperatureColumn;
    @FXML
    void initialize() throws IOException {
        setData();
        numberColumn.setCellValueFactory(new PropertyValueFactory<Day,Integer>("number"));
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<Day,Integer>("temperature"));
        month.setItems(data);
    }
    void setData() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(new File("temp2.csv")));
        String line ;
        while ((line = bf.readLine())!=null && line.substring(3,5).equals("01")){
            int d = Integer.parseInt(line.substring(0,2));
            int t = Integer.parseInt(line.substring(11));
            data.add(new Day(d,t));
        }
    }
}
