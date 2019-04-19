package Szrotex3.ui.makereservation;

import Szrotex3.model.Car;
import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.Formatter;
import Szrotex3.service.Reservation;
import Szrotex3.ui.MainController;
import Szrotex3.ui.alert.AlertController;
import Szrotex3.ui.exception.UserException;
import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class MakeReservationController extends MainController {

    private Car car;

    private Client client;

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

    @FXML
    private Text rentPrice;

    @FXML
    private JFXDatePicker dateStart;

    @FXML
    private JFXDatePicker dateEnd;

    @FXML
    private JFXTimePicker timeStart;

    @FXML
    private JFXTimePicker timeEnd;

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

    public void setClient(Client client) {
        this.client = client;
        ClientName.setText(client.getFirstName());
        ClientSurname.setText(client.getLastName());
    }

    public void setCar(Car car){

        Formatter formatter = (Formatter) Container.getBean("formatter");

        this.car = car;

        CarId.setText(String.valueOf(car.getId()));
        Brand.setText(car.getBrand());
        Model.setText(car.getModel());
        Price.setText(formatter.formatPrice(car.getVehicle().getPrice()));
        Image image = new Image(new File(car.getVehicle().getLinkToImg()).toURI().toString());
        CarImg.setImage(image);
    }

    @FXML
    void backToOferta(MouseEvent event) {
       makereservation_content_pane.getChildren().clear();
       HomePageController.getInstance().changeContentToOferta();
    }

    @FXML
    void selectClientActon(ActionEvent event) {
        BoxBlur blur = new BoxBlur(5,5,5);
        makereservation_content_pane.setEffect(blur);
        loadPage("/Szrotex3/ui/makereservation/makereservation_select_client.fxml");
    }

    @FXML
    void reservationParamsChangedActon(ActionEvent event) {
        updatePrice();
    }

    @FXML
    void makeReservationActon(ActionEvent event) {

        try {

            if (this.client == null) {
                throw new UserException("Klient nie został wybrany.");
            }

            if (this.car == null) {
                throw new UserException("Pojazd nie został wybrany.");
            }

            Szrotex3.service.Date dateService = (Szrotex3.service.Date) Container.getBean("date");

            Date dateStart = dateService.convertLocalDateLocalTimeToUtilDate(this.dateStart.getValue(), this.timeStart.getValue());
            Date dateEnd = dateService.convertLocalDateLocalTimeToUtilDate(this.dateEnd.getValue(), this.timeEnd.getValue());

            if (dateStart == null || dateEnd == null) {
                throw new UserException("Ramy czasowe rezerwacji nie zostały wprowadzone poprawnie.");
            }

            BoxBlur blur = new BoxBlur(5,5,5);
            makereservation_content_pane.setEffect(blur);

            Reservation reservationService = (Reservation) Container.getBean("reservation");

            boolean isAvailable = reservationService.isAvailable(
                    this.car.getVehicle(),
                    dateStart,
                    dateEnd
            );

            if (! isAvailable) {
                throw new UserException("Rezerwacja nie może zostać wykonana w podanym terminie.");
            }

            boolean confirmed = AlertController.loadTrueFalsePopup("Czy na pewno chcesz dodać tę rezerwację?", makereservation_content_pane);

            if (confirmed) {
                Szrotex3.model.Reservation reservationObiect = reservationService.makeReservation(
                        this.car.getVehicle(),
                        this.client,
                        dateStart,
                        dateEnd
                );

                if (reservationObiect != null) {
                    AlertController.loadOkPopup("Rezerwacja została dodana.", makereservation_content_pane);
                } else {
                    AlertController.loadOkPopup("Rezerwacja nie została dodana.", makereservation_content_pane);
                }

                updatePrice();

            }

        } catch (UserException e) {
            AlertController.loadOkPopup(e.getMessage(), makereservation_content_pane);
        }

    }

    public void updatePrice() {

        Szrotex3.service.Date dateService = (Szrotex3.service.Date) Container.getBean("date");

        Date dateStart = dateService.convertLocalDateLocalTimeToUtilDate(this.dateStart.getValue(), this.timeStart.getValue());
        Date dateEnd = dateService.convertLocalDateLocalTimeToUtilDate(this.dateEnd.getValue(), this.timeEnd.getValue());

        if (dateStart == null || dateEnd == null) {
            this.rentPrice.setText("b/d");
            return;
        }

        Reservation reservationService = (Reservation) Container.getBean("reservation");
        Formatter formatter = (Formatter) Container.getBean("formatter");

        double rentPrice = reservationService.countPrice(this.car.getVehicle(), dateStart, dateEnd);

        this.rentPrice.setText(formatter.formatPrice(rentPrice));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.rentPrice.setText("?");
    }
}
