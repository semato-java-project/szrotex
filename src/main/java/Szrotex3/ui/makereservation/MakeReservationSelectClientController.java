package Szrotex3.ui.makereservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class MakeReservationSelectClientController {

    @FXML
    private Pane TopPane;

    @FXML
    private ImageView CloseButton;

    @FXML
    void handleCloseButtonAction(MouseEvent event) {
        ((Stage)CloseButton.getScene().getWindow()).close();
       MakeReservationController.getInstance().makereservation_content_pane.setEffect(null);
    }

}
