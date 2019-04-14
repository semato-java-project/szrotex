package Szrotex3.ui.makereservation;

import Szrotex3.model.Client;
import Szrotex3.ui.oferta.OfertaCarPaneController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MkReservOneClientController {

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


    @FXML
    void SelectThisClient(ActionEvent event) {
        MakeReservationController.getInstance().getClientName().setText(Client_name.getText());
        MakeReservationController.getInstance().getClientSurname().setText(Client_surname.getText());

        MakeReservationSelectClientController.getInstance().CloseWindow();
        MakeReservationController.getInstance().makereservation_content_pane.setEffect(null);

    }

    public void setClient_name(String name) {
        Client_name.setText(name);
    }

    public void setClient_surname(String surname) {
        Client_surname.setText(surname);
    }
}
