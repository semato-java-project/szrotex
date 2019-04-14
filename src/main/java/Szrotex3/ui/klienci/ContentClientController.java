package Szrotex3.ui.klienci;

import Szrotex3.model.Client;
import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ContentClientController implements Initializable {

    private Client client;

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
    private Text clientName;

    @FXML
    private Text clientSurname;

    @FXML
    private Text clientEmail;

    @FXML
    private Text clientPhone;

    @FXML
    private Text clientId;

    @FXML
    private Text clientPesel;

    @FXML
    private Text clientIdNumber;

    @FXML
    private Text clientAge;

    @FXML
    private Text clientAddress;

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

    @FXML
    void goToEditForm(ActionEvent event) {
        HomePageController.getInstance().changeContentToEditClient(event);
    }

    public void setClient(Client client)
    {
        this.client=client;

        clientName.setText(client.getFirstName());
        clientSurname.setText(client.getLastName());
        clientEmail.setText(client.getEmail());
        clientPhone.setText(client.getPhone());
        clientId.setText(String.valueOf(client.getId()));
        clientPesel.setText(client.getPesel());
        clientIdNumber.setText(client.getIdNumber());
        clientAge.setText(String.valueOf(client.getAge()));
        clientAddress.setText(client.getAddress());
    }

    private static ContentClientController instance;
    public ContentClientController() {
        instance = this;
    }
    public static ContentClientController getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchorPane.setPrefHeight(74);
        ClientSeparator.setPrefHeight(74);
    }
}
