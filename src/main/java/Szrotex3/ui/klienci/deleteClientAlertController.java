package Szrotex3.ui.klienci;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class deleteClientAlertController {

    @FXML
    private Text Message;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton confirmButton;

    @FXML
    void hancleCancelAction(ActionEvent event) {
        CloseWindow();
        contentKlienciController.getInstance().getMainAnchorPane().setEffect(null);
    }

    public void CloseWindow(){
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

    @FXML
    void handleConfirmAction(ActionEvent event) {

    }
}
