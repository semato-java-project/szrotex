package Szrotex3.ui.makereservation;

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

    @FXML
    void SelectThisClient(ActionEvent event) {
        MakeReservationController.getInstance().getClientName().setText(Client_name.getText());
        MakeReservationController.getInstance().getClientSurname().setText(Client_surname.getText());

        MakeReservationSelectClientController.getInstance().CloseWindow();
        MakeReservationController.getInstance().makereservation_content_pane.setEffect(null);

    }
}
