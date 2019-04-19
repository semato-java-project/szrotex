package Szrotex3.ui.alert;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class AlertController implements Initializable {


    private final String msg;

    private boolean decision = false;

    private final AnchorPane whereIsEffect;

    private static AlertController instance;

    public AlertController(String msg, AnchorPane whereIsEffect) {
        this.msg = msg;
        this.whereIsEffect = whereIsEffect;
        instance = this;
    }

    public static AlertController getInstance() {
        return instance;
    }


    @FXML
    private Text message;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton confirmButton;


    @FXML
    void hancleCancelAction(ActionEvent event) {
        closeWindow();
    }

    public void closeWindow() {

        ((Stage) cancelButton.getScene().getWindow()).close();
        whereIsEffect.setEffect(null);
    }

    public boolean getDecision() {
        return decision;
    }

    public void setMessage(String messageTxt) {
        this.message.setText(messageTxt);
    }


    @FXML
    void handleConfirmAction(ActionEvent event) {
        decision = true;
        closeWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message.setText(msg);
    }
}


