package Szrotex3.ui.makereservation;

import Szrotex3.ui.homepage.HomePageController;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
