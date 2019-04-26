package Szrotex3.ui.alert;


import Szrotex3.ui.MainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AlertController implements Initializable {


    private final String msg;

    private boolean decision;

    private final AnchorPane whereIsEffect;

    private static AlertController instance;

    @FXML
    private Text message;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXButton confirmButton;

    public AlertController(String msg, AnchorPane whereIsEffect) {
        this.msg = msg;
        this.whereIsEffect = whereIsEffect;
        instance = this;
    }

    public static AlertController getInstance() {
        return instance;
    }

    public void closeWindow() {

        ((Stage) cancelButton.getScene().getWindow()).close();
        whereIsEffect.setEffect(null);
    }

    public boolean getDecision() {
        return decision;
    }

    @FXML
    void handleCancelAction(ActionEvent event) {
        decision = false;
        closeWindow();
    }

    @FXML
    void handleConfirmAction(ActionEvent event) {
        decision = true;
        closeWindow();
    }

    @FXML
    void handleOkAction(ActionEvent event) {
        closeWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        message.setText(msg);
    }

    public static boolean loadTrueFalsePopup(String msg, AnchorPane whereIsEffect) {
        AlertController alertController = new AlertController(msg, whereIsEffect);
        return alertController.loadTrueFalsePopup();
    }

    public boolean loadTrueFalsePopup() {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("/Szrotex3/ui/alert/AlertTrueOrFalse.fxml"));
        showAndWait(loader);
        return decision;
    }

    public static void loadOkPopup(String msg, AnchorPane whereIsEffect) {
        AlertController alertController = new AlertController(msg, whereIsEffect);
        alertController.loadOkPopup();
    }

    public void loadOkPopup() {
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("/Szrotex3/ui/alert/AlertOk.fxml"));
        showAndWait(loader);
    }

    private void showAndWait(FXMLLoader loader) {

        try {
            loader.setController(this);
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL.APPLICATION_MODAL);
            stage.setTitle("Semato - Alert");
            stage.setScene(scene);
            stage.setWidth(400);
            stage.setHeight(120);
            MainController.setPosition(stage);
            stage.showAndWait();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }


    }



}


