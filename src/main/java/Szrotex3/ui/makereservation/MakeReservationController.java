package Szrotex3.ui.makereservation;

import Szrotex3.model.Car;
import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.Reservation;
import Szrotex3.ui.MainController;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
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

        this.car = car;

        CarId.setText(String.valueOf(car.getId()));
        Brand.setText(car.getBrand());
        Model.setText(car.getModel());
        Price.setText(String.valueOf(car.getVehicle().getPrice()));
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
    void makeReservationActon(ActionEvent event) {

        try {

            if (this.client == null) {
                throw new UserException("Klient nie został wybrany.");
            }

            if (this.car == null) {
                throw new UserException("Pojazd nie został wybrany.");
            }

            LocalDate localDateStart = this.dateStart.getValue();
            LocalDate localDateEnd = this.dateEnd.getValue();

            LocalTime localTimeStart = this.timeStart.getValue();
            LocalTime localTimeEnd = this.timeEnd.getValue();

            Calendar calendarStart = Calendar.getInstance();
            Calendar calendarEnd = Calendar.getInstance();

            calendarStart.set(
                    localDateStart.getYear(),
                    localDateStart.getMonthValue() - 1,
                    localDateStart.getDayOfMonth(),
                    localTimeStart.getHour(),
                    localTimeStart.getMinute(),
                    0
            );

            calendarEnd.set(
                    localDateEnd.getYear(),
                    localDateEnd.getMonthValue() - 1,
                    localDateEnd.getDayOfMonth(),
                    localTimeEnd.getHour(),
                    localTimeEnd.getMinute(),
                    0
            );

            Instant instantStart = Instant.from(localDateStart.atStartOfDay(ZoneId.systemDefault()));
            Instant instantEnd = Instant.from(localDateEnd.atStartOfDay(ZoneId.systemDefault()));

            Date dateStart = calendarStart.getTime();
            Date dateEnd = calendarEnd.getTime();

            Reservation reservationService = (Reservation) Container.getBean("reservation");
            Szrotex3.model.Reservation reservationObiect = reservationService.makeReservation(
                    this.car.getVehicle(),
                    this.client,
                    dateStart,
                    dateEnd
            );

            if (reservationObiect == null) {
                throw new UserException("Rezerwacja nie może zostać wykonana w podanym terminie.");
            }
        } catch (UserException e) {
            String message = e.getMessage();
            throw e; // wyświetlić popup/komunikat z message zamiast throwa
        }

        // wyświetlić popup/komunikat, że się udało

    }

    // Jest opcja zeby wywalic te dwie metody? bez tego sie nie kompiluje
    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
