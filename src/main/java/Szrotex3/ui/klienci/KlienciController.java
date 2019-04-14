package Szrotex3.ui.klienci;

import Szrotex3.ui.homepage.HomePageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KlienciController implements Initializable {

    @FXML
    private VBox client_container;

    @FXML
    void AddNewClient(ActionEvent event) {
        HomePageController.getInstance().changeContentToAddNewClient(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {

            try {
                nodes[i] = FXMLLoader.load(getClass().getResource("klient.fxml"));
                client_container.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
