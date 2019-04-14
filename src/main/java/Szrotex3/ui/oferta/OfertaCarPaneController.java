package Szrotex3.ui.oferta;

import Szrotex3.ui.homepage.HomePageController;
import Szrotex3.ui.makereservation.MakeReservationController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class OfertaCarPaneController {


    private int CarIdForReservation;

    @FXML
    private Text Brand;

    @FXML
    private Text EngineCapacity;

    @FXML
    private Text Model;

    @FXML
    private Text Transsmision;

    @FXML
    private Text EngineType;

    @FXML
    private Text DoorsQuantity;

    @FXML
    private Text EnginePower;

    @FXML
    private Text SeatsQuantity;

    @FXML
    private JFXButton ReserveButton;

    @FXML
    private ImageView CarImg;


    private static OfertaCarPaneController instance;
    public OfertaCarPaneController() {
        instance = this;
    }
    public static OfertaCarPaneController getInstance() {
        return instance;
    }

    public void setCarInfo(int carId,String brand, String model,double engineCapacity,
                           String engineType, String transsmision,int enginePower,
                           int doorsQuantity,int seatsQuantity, String linkToImg){
        CarIdForReservation = carId;
        Brand.setText(brand);
        Model.setText(model);
        EnginePower.setText(String.valueOf(enginePower));
        EngineType.setText(engineType);
        EngineCapacity.setText(String.valueOf(engineCapacity));
        Transsmision.setText(transsmision);
        SeatsQuantity.setText(String.valueOf(seatsQuantity));
        DoorsQuantity.setText(String.valueOf(doorsQuantity));

        Image image = new Image(new File(linkToImg).toURI().toString());
        System.out.println(new File(linkToImg).toURI().toString()); //do testowania czy poprawna sciezka sie pojawia
        CarImg.setImage(image);

    }

    @FXML
    void ShowReservationDetails(ActionEvent event) {
        OfertaController.getInstance().oferta_content_pane.getChildren().clear();
        HomePageController.getInstance().createContentPage(OfertaController.getInstance().oferta_content_pane,"/Szrotex3/ui/makereservation/content_makereservation.fxml");
        HomePageController.getInstance().setTopPath("Szczegóły rezerwacji");
        MakeReservationController.getInstance().setCarReservationInfo(CarIdForReservation,Brand.getText(),Model.getText());

    }
}