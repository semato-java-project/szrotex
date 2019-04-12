package Szrotex3.ui.makereservation;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import Szrotex3.ui.homepage.HomePageController;
import Szrotex3.ui.oferta.OfertaController;
import javafx.scene.text.Text;


public class MakeReservationController {

    @FXML
    private Pane backToOfertaButton;

    @FXML
    private AnchorPane makereservation_content_pane;

    @FXML
    private Text Brand;

    @FXML
    private Text Model;

    @FXML
    private Text CarId;

    private static MakeReservationController instance;

    public MakeReservationController(){
        instance = this;
    }
    public static MakeReservationController getInstance(){
        return instance;
    }


    public void setCarReservationInfo(int idCar,String brand, String model){

        CarId.setText(String.valueOf(idCar));
        Brand.setText(brand);
        Model.setText(model);
    }


    @FXML
    void BackToOferta(MouseEvent event) {
       makereservation_content_pane.getChildren().clear();
       HomePageController.getInstance().changeContentToOferta();
    }

}
