package Szrotex3.ui.rentlist;

import Szrotex3.model.Reservation;
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

        this.reservation = reservation;

        carId.setText(String.valueOf(reservation.getVehicle().getId()));
        ///carId.setText(reservation.getVehicle().getCar().....);

        clientId.setText(String.valueOf(reservation.getClient().getId()));
        clientName.setText(reservation.getClient().getFirstName());
        clientSurname.setText(reservation.getClient().getLastName());

        rentId.setText(String.valueOf(reservation.getId()));
        dateStart.setText(String.valueOf(reservation.getDateStart()));
        dateEnd.setText(String.valueOf(reservation.getDateEnd()));

        ///rentPrice.setText(String.valueOf(reservation.get));

    }

}
