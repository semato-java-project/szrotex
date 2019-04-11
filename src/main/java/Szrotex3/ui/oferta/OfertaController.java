package Szrotex3.ui.oferta;

import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class OfertaController implements Initializable {


    @FXML
    public AnchorPane oferta_content_pane;


    private static OfertaController instance;

    public OfertaController(){
        instance = this;
    }
    public static OfertaController getInstance(){
        return instance;
    }

    @FXML
    private VBox container_oferta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Node[] cars = new Node[10];
        for (int i = 0; i < cars.length; i++) {

            try {
                cars[i] = FXMLLoader.load(getClass().getResource("one_car_pane.fxml"));
                container_oferta.getChildren().add(cars[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
