package Szrotex3.ui.makereservation;

import Szrotex3.model.Client;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MkReservOneClientController {

    Client client;

    @FXML
    private Text Client_name;

    @FXML
    private Text Client_surname;

    @FXML
    private JFXButton SelectClientBtn;

    @FXML
    private Text Client_id;

    private static MkReservOneClientController instance;
    public MkReservOneClientController() {
        instance = this;
    }
    public static MkReservOneClientController getInstance() {
        return instance;
    }

    public void setClient(Client client) {
        this.client = client;
        Client_name.setText(client.getFirstName());
        Client_surname.setText(client.getLastName());
        Client_id.setText(String.valueOf(client.getId()));
    }

    @FXML
    void SelectThisClient(ActionEvent event) {
        MakeReservationController.getInstance().setClient(client);
        MakeReservationSelectClientController.getInstance().CloseWindow();
        MakeReservationController.getInstance().makereservation_content_pane.setEffect(null);
    }

}
