package Szrotex3.ui.addNewClient;

import Szrotex3.model.Client;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class addNewClientController {

    @FXML
    private AnchorPane AddClientPane;

    @FXML
    private JFXTextField clientName;

    @FXML
    private JFXTextField clientSurname;

    @FXML
    private JFXTextField clientPhone;

    @FXML
    private JFXTextField clientEmail;

    @FXML
    private JFXTextField clientPesel;

    @FXML
    private JFXTextField clientIdNumber;

    @FXML
    private JFXTextField clientBirthDate;

    @FXML
    private JFXTextField clientCity;

    @FXML
    private JFXTextField clientStreet;

    @FXML
    private JFXTextField clientApartmentNumber;

    @FXML
    private JFXTextField clientPostalCode;

    @FXML
    void handleAddClientAction(ActionEvent event) {
        Client newClient(clientName.getText(), clientSurname.getText(), clientEmail.getText(), clientPhone.getText(), clientPesel.getText(), clientIdNumber.getText(), clientBirthDate.getText(), clientCity.getText(), clientStreet.getText(), clientApartmentNumber.getText(), clientPostalCode.getText());

    }

    @FXML
    void handleCancelAction(ActionEvent event) {

    }

}
