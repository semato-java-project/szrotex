package Szrotex3.ui.rentlist;

import Szrotex3.model.Reservation;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RentListController implements Initializable {


    @FXML
    private AnchorPane rentAnchorPane;

    @FXML
    private VBox rentContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");
        List<Reservation> reservationObjects = (List<Reservation>) hibernateSession.getSession().createCriteria(Reservation.class).list();

        for (int i = 0; i < reservationObjects.size() ; i++) {
            AnchorPane rentPane;
            try {
                rentPane = FXMLLoader.load(getClass().getResource("/Szrotex3/ui/rentlist/OneRent.fxml"));
                OneRentController.getInstance().setReservation(reservationObjects.get(i));
                rentContainer.getChildren().add(rentPane);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
