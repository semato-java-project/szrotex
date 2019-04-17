package Szrotex3.ui.rentlist;

import Szrotex3.model.Car;
import Szrotex3.model.Client;
import Szrotex3.model.Reservation;
import Szrotex3.model.Vehicle;
import Szrotex3.service.Container;
import Szrotex3.service.Formatter;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OneRentController {

    private Reservation reservation;

    @FXML
    private Text carBrand;

    @FXML
    private Text carModel;

    @FXML
    private Text dateStart;

    @FXML
    private Text dateEnd;

    @FXML
    private Text rentPrice;

    @FXML
    private Text Price1;

    @FXML
    private Text carId;

    @FXML
    private Text clientId;

    @FXML
    private Text clientName;

    @FXML
    private Text clientSurname;

    @FXML
    private Text rentId;


    private static OneRentController instance;
    public OneRentController() {
        instance = this;
    }
    public static OneRentController getInstance() {
        return instance;
    }

    public void setReservation(Reservation reservation){

        Szrotex3.service.Reservation reservationService = (Szrotex3.service.Reservation) Container.getBean("reservation");
        Formatter formatter = (Formatter) Container.getBean("formatter");

        this.reservation = reservation;

        Vehicle vehicle = reservation.getVehicle();
        Car car = vehicle.getCar();
        Client client = reservation.getClient();

        carBrand.setText(car.getBrand());
        carModel.setText(car.getModel());

        carId.setText(String.valueOf(car.getId()));

        clientId.setText(String.valueOf(client.getId()));
        clientName.setText(client.getFirstName());
        clientSurname.setText(client.getLastName());

        rentId.setText(String.valueOf(reservation.getId()));
        dateStart.setText(formatter.formatDateHumainReadable(reservation.getDateStart()));
        dateEnd.setText(formatter.formatDateHumainReadable(reservation.getDateEnd()));

        rentPrice.setText(formatter.formatPrice(reservationService.countPrice(reservation)));

    }

}
