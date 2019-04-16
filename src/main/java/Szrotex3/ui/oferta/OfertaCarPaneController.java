package Szrotex3.ui.oferta;

import Szrotex3.model.Car;
import Szrotex3.service.Container;
import Szrotex3.service.Formatter;
import Szrotex3.ui.homepage.HomePageController;
import Szrotex3.ui.makereservation.MakeReservationController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;

public class OfertaCarPaneController {

    private int CarIdForReservation;

    private Car car;

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

    @FXML
    private Text Price;


    private static OfertaCarPaneController instance;
    public OfertaCarPaneController() {
        instance = this;
    }
    public static OfertaCarPaneController getInstance() {
        return instance;
    }

    public void setCar(Car car){

        Formatter formatter = (Formatter) Container.getBean("formatter");

        this.car = car;

        CarIdForReservation = car.getId();
        Brand.setText(car.getBrand());
        Model.setText(car.getModel());
        EnginePower.setText(String.valueOf(car.getEnginePower()));
        EngineType.setText(car.getEngineType());
        EngineCapacity.setText(String.valueOf(car.getEngineCapacity()));
        Transsmision.setText(car.getTranssmision());
        SeatsQuantity.setText(String.valueOf(car.getSeatsQuantity()));
        DoorsQuantity.setText(String.valueOf(car.getDoorsQuantity()));
        Price.setText(formatter.formatPrice(car.getVehicle().getPrice()));

        Image image = new Image(new File(car.getVehicle().getLinkToImg()).toURI().toString());
        CarImg.setImage(image);
    }

    @FXML
    void ShowReservationDetails(ActionEvent event) {
        OfertaController.getInstance().oferta_content_pane.getChildren().clear();
        HomePageController.getInstance().createContentPage(OfertaController.getInstance().oferta_content_pane,"/Szrotex3/ui/makereservation/content_makereservation.fxml");
        HomePageController.getInstance().setTopPath("Szczegóły rezerwacji");
        MakeReservationController.getInstance().setCar(this.car);

    }
}