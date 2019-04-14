package Szrotex3.ui.klienci;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ContentClientController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXButton EditClientButton;

    @FXML
    private JFXButton DeleteClientButton;

    @FXML
    private JFXButton ShowDetailsButton;

    @FXML
    private Pane LeftPane;

    @FXML
    private Separator ClientSeparator;

    @FXML
    void ShowDetailsButtonAction(ActionEvent event) {

        if(ShowDetailsButton.getText().equals("Pokaż szczegóły")){
            anchorPane.setPrefHeight(140);
            ShowDetailsButton.setText("Ukryj szczegóły");
            LeftPane.setPrefHeight(140);
            ClientSeparator.setPrefHeight(140);

        }
        else
        {
            anchorPane.setPrefHeight(74);
            ShowDetailsButton.setText("Pokaż szczegóły");
            LeftPane.setPrefHeight(74);
            ClientSeparator.setPrefHeight(74);
        }


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setPrefHeight(74);
        ClientSeparator.setPrefHeight(74);
    }
}
