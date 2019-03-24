package Szrotex3.ui.oferta;

import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


public class OfertaController  {


    @FXML
    private AnchorPane oferta_content_pane;

    @FXML
    private JFXButton ReserveButton;

    @FXML
    void ShowReservationDetails(ActionEvent event) {
        oferta_content_pane.getChildren().clear();
        HomePageController.getInstance().createContentPage(oferta_content_pane,"/Szrotex3/ui/makereservation/content_makereservation.fxml");
        HomePageController.getInstance().setTopPath("Szczegóły rezerwacji");
    }


}
