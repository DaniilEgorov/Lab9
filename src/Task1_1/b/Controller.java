package Task1_1.b;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {
    @FXML
    AnchorPane pane;
    @FXML
    TableView<Day> year;

    @FXML
    void initialize() throws IOException {
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        BufferedReader bf = new BufferedReader(new FileReader(new File("temp2.csv")));
        String line = "";
        for (int i = 0; i < months.length; i++) {
            ObservableList<Day> data = FXCollections.observableArrayList();
            if (i != 0) data.add(new Day(Integer.parseInt(line.substring(0, 2)), Integer.parseInt(line.substring(11))));
            TableColumn<Day, Integer> month = new TableColumn<>(months[i]);
            TableColumn<Day, Integer> number = new TableColumn<>("Число");
            TableColumn<Day, Integer> temp = new TableColumn<>("Температура");
            while ((line = bf.readLine()) != null && (i + 1) == Integer.parseInt(line.substring(3, 5))) {
                int d = Integer.parseInt(line.substring(0, 2));
                int t = Integer.parseInt(line.substring(11));
                data.add(new Day(d, t));
            }
            number.setCellValueFactory(new PropertyValueFactory<>("number"));
            temp.setCellValueFactory(new PropertyValueFactory<>("temperature"));
            month.getColumns().addAll(number, temp);
            year.getColumns().add(month);
            year.setItems(data);
        }
    }
}
