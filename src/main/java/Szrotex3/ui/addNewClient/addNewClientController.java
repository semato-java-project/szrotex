package Szrotex3.ui.addNewClient;

import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class addNewClientController {

    @FXML
    private AnchorPane AddClientPane;

    @FXML
    private JFXTextField clientName;

    @FXML
    private JFXTextField clientSurname;

    @FXML
    private JFXTextField clientPhone;

    @FXML
    private JFXTextField clientEmail;

    @FXML
    private JFXTextField clientPesel;

    @FXML
    private JFXTextField clientIdNumber;

    @FXML
    private JFXDatePicker clientBirthDate;

    @FXML
    private JFXTextField clientCity;

    @FXML
    private JFXTextField clientStreet;

    @FXML
    private JFXTextField clientApartmentNumber;

    @FXML
    private JFXTextField clientPostalCode;

    @FXML
    void handleAddClientAction(ActionEvent event) {
        String firstName = clientName.getText();
        String lastName = clientSurname.getText();
        String email = clientEmail.getText();
        String phone = clientPhone.getText();
        String pesel = clientPesel.getText();
        String idNumber = clientIdNumber.getText();
        LocalDate localBirthDate = clientBirthDate.getValue();
        String city = clientCity.getText();
        String street = clientStreet.getText();
        String apartmentNumber = clientApartmentNumber.getText();
        String postalCode = clientPostalCode.getText();

        Calendar now= Calendar.getInstance();
        Date createAt = now.getTime();

        Calendar calendarBirthDate=Calendar.getInstance();

        calendarBirthDate.set(
                localBirthDate.getYear(),
                localBirthDate.getMonthValue() - 1,
                localBirthDate.getDayOfMonth()
        );

        Date birthDate = calendarBirthDate.getTime();

        Client newClient=new Client(firstName, lastName, email, phone, createAt, pesel, idNumber, birthDate, city, street, apartmentNumber, postalCode);

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");

        hibernateSession.getSession().persist(newClient);
        hibernateSession.getSession().flush();

        //prompt o dodaniu nowego klienta, wymazanie pol.

        HomePageController.getInstance().changeContentToKlienci(event);



        //TODO: dodac walidacje, poprawic polskie znaki, zastanowić się nad iteracyjnym dodawaniem id (następny w tablicy)


    }

    @FXML
    void handleCancelAction(ActionEvent event) {
        HomePageController.getInstance().changeContentToKlienci(event);
    }

}
