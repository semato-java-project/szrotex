package Szrotex3.ui.addNewClient;

import Szrotex3.model.Client;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


public class AddNewClientController {

    private static AddNewClientController instance;

    public AddNewClientController(){
        instance = this;
    }
    public static AddNewClientController getInstance(){
        return instance;
    }

    private Client client;

    @FXML
    private AnchorPane AddClientPane;

    @FXML
    private JFXTextField ClientName;

    @FXML
    private JFXTextField ClientSurname;

    @FXML
    private JFXTextField ClientPESEL;

    @FXML
    private JFXTextField ClientAge;

    @FXML
    private JFXTextField ClientMail;

    @FXML
    private JFXTextField ClientNumber;

    @FXML
    private JFXTextField ClientCode;

    @FXML
    private JFXTextField ClientCity;

    @FXML
    private JFXTextField ClientHouseNumber;

    @FXML
    private JFXTextField ClientStreet;

    @FXML
    private JFXTextField ClientPostalCode;

    @FXML
    private JFXButton addoreditButton;

    public JFXButton getAddoreditButton() {
        return addoreditButton;
    }

    @FXML
    void handleAddClientAction(ActionEvent event) {

    }

    public void setClient(Client client)
    {
        this.client=client;

        ClientName.setText(client.getFirstName());
        ClientSurname.setText(client.getLastName());
        ClientMail.setText(client.getEmail());
        ClientNumber.setText(client.getPhone());
        ClientPESEL.setText(client.getPesel());
        ClientCode.setText(client.getIdNumber());
        ClientAge.setText(String.valueOf(client.getBirthDate()));
        ClientStreet.setText(client.getStreet());
        ClientCity.setText(client.getCity());
        ClientHouseNumber.setText(client.getApartmentNumber());
        ClientPostalCode.setText(client.getPostalCode());
    }

    @FXML
    void handleCancelAction(ActionEvent event) {

    }

}
