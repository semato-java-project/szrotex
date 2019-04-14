package Szrotex3.ui.makereservation;

import Szrotex3.ui.MainController;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import Szrotex3.ui.homepage.HomePageController;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class MakeReservationController extends MainController {

    @FXML
    private Pane backToOfertaButton;

    @FXML
    public AnchorPane makereservation_content_pane;

    @FXML
    private Text Brand;

    @FXML
    private Text Model;

    @FXML
    private Text CarId;

    @FXML
    private Text ClientName;

    @FXML
    private Text ClientSurname;

    @FXML
    private JFXButton SelectClientButton;

    @FXML
    private ImageView CarImg;

    @FXML
    private Text Price;


    public Text getClientName() {
        return ClientName;
    }

    public Text getClientSurname() {
        return ClientSurname;
    }

    private static MakeReservationController instance;

    public MakeReservationController(){
        instance = this;
    }

    public static MakeReservationController getInstance(){
        return instance;
    }


    public void setCarReservationInfo(int idCar, String brand, String model, Image CarImgOferta, Text PriceFromOferta){

        CarId.setText(String.valueOf(idCar));
        Brand.setText(brand);
        Model.setText(model);
        Price.setText(PriceFromOferta.getText());
        CarImg.setImage(CarImgOferta);

    }

    @FXML
    void BackToOferta(MouseEvent event) {
       makereservation_content_pane.getChildren().clear();
       HomePageController.getInstance().changeContentToOferta();
    }

    @FXML
    void SelectClientActon(ActionEvent event) {

        BoxBlur blur = new BoxBlur(5,5,5);
        makereservation_content_pane.setEffect(blur);
        loadPage("/Szrotex3/ui/makereservation/makereservation_select_client.fxml");
    }




    // Jest opcja zeby wywalic te dwie metody? bez tego sie nie kompiluje
    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
