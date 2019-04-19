package Szrotex3.ui.addNewClient;

import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import Szrotex3.ui.MainController;
import Szrotex3.ui.alert.AlertController;
import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddNewClientController extends MainController {

    private static AddNewClientController instance;

    public AddNewClientController(){
        instance = this;
    }

    public static AddNewClientController getInstance(){
        return instance;
    }

    private Client client;

    @FXML
    private AnchorPane addClientPane;

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
    private JFXButton addOrEditButton;

    @FXML
    private Label clientNameLabel;

    @FXML
    private Label clientEmailLabel;

    @FXML
    private Label clientSurnameLabel;

    @FXML
    private Label clientPhoneLabel;

    @FXML
    private Label clientPeselLabel;

    @FXML
    private Label clientIdNumberLabel;

    @FXML
    private Label clientBirthDateLabel;

    @FXML
    private Label clientCityLabel;

    @FXML
    private Label clientStreetLabel;

    @FXML
    private Label clientApartmentNumberLabel;

    @FXML
    private Label clientPostalCodeLabel;



    @FXML
    void handleAddClientAction(ActionEvent event) {

        clearLabels();

        if(HomePageController.getInstance().getTopPath() == "Dodaj Klienta") {
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

            if (localBirthDate != null) {
                Calendar now = Calendar.getInstance();
                Date createAt = now.getTime();

                Calendar calendarBirthDate = Calendar.getInstance();

                calendarBirthDate.set(
                        localBirthDate.getYear(),
                        localBirthDate.getMonthValue() - 1,
                        localBirthDate.getDayOfMonth()
                );

                Date birthDate = calendarBirthDate.getTime();

                Client newClient = new Client(firstName,
                        lastName,
                        email,
                        phone,
                        createAt,
                        pesel,
                        idNumber,
                        birthDate,
                        city,
                        street,
                        apartmentNumber,
                        postalCode
                );

                if (this.validate(newClient)) {

                    BoxBlur blur = new BoxBlur(5,5,5);
                    addClientPane.setEffect(blur);

                    if(AlertController.loadTrueFalsePopup("Czy napewno dodać nowego klienta?",addClientPane)) {

                        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");

                        hibernateSession.getSession().persist(newClient);

                        hibernateSession.getSession().flush();

                        HomePageController.getInstance().changeContentToKlienci(event);
                    }
                }

            } else {
                clientBirthDateLabel.setText("Wprowadź datę urodzenia!");
            }
        }
        else
        {

            LocalDate localBirthDate=clientBirthDate.getValue();
            if (localBirthDate != null) {
                Calendar calendarBirthDate = Calendar.getInstance();
                calendarBirthDate.set(
                        localBirthDate.getYear(),
                        localBirthDate.getMonthValue() - 1,
                        localBirthDate.getDayOfMonth()
                );

                Date birthDate = calendarBirthDate.getTime();

                this.client.setFirstName(clientName.getText());
                this.client.setLastName(clientSurname.getText());
                this.client.setEmail(clientEmail.getText());
                this.client.setPhone(clientPhone.getText());
                this.client.setPesel(clientPesel.getText());
                this.client.setIdNumber(clientIdNumber.getText());
                this.client.setBirthDate(birthDate);
                this.client.setCity(clientCity.getText());
                this.client.setStreet(clientStreet.getText());
                this.client.setApartmentNumber(clientApartmentNumber.getText());
                this.client.setPostalCode(clientPostalCode.getText());

                if (this.validate(this.client) && AlertController.loadTrueFalsePopup("Zapisać zmiany?", addClientPane))
                {
                    HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");

                    hibernateSession.getSession().update(this.client);

                    hibernateSession.getSession().flush();


                    HomePageController.getInstance().changeContentToKlienci(event);
                }
            } else {

                clientBirthDateLabel.setText("Wprowadź datę urodzenia!");
            }
        }

    }


    private boolean validate(Client clientToValidate)
    {
        boolean validation=true;
        String ifEmpty="Pole jest puste!";

        //Kazdy System.out.println można tutaj zamienić na alerta bądź wstawić do formularza pod każdym fieldem pole które będzie uzupełniane w ifach w momencie wystąpienia błędu

        if(clientToValidate.getFirstName().length() == 0)
        {
            clientNameLabel.setText(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getLastName().length() == 0)
        {
            clientSurnameLabel.setText(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getEmail().length() == 0)
        {
            clientEmailLabel.setText(ifEmpty);
            validation=false;
        }
        else
        {
            Pattern mailPattern = Pattern.compile(
                    "^[a-zA-z0-9]+[\\._a-zA-Z0-9]*@[a-zA-Z0-9]" +
                            "+{2,}\\.[a-zA-Z]{2,}[\\.a-zA-Z0-9]*$");

            Matcher mailMatcher = mailPattern.matcher(clientToValidate.getEmail());

            if(!mailMatcher.matches())
            {
                clientEmailLabel.setText("Wprowadzono niepoprawny mail!");
                validation = false;
            }

        }

        if(clientToValidate.getPhone().length() == 0)
        {
            clientPhoneLabel.setText(ifEmpty);
            validation=false;
        }
        else if(clientToValidate.getPhone().length() != 9)
        {
            clientPhoneLabel.setText("Dlugość telefonu powinna zawierać 9 znaków");
            validation=false;
        }

        if(clientToValidate.getPesel().length() == 0)
        {
            clientPeselLabel.setText(ifEmpty);
            validation=false;
        }
        else if(clientToValidate.getPesel().length() != 11)
        {
            clientPeselLabel.setText("Pesel powinien mieć 11 znaków!");
            validation=false;
        }
        else
        {
            String pesel=clientToValidate.getPesel();
            char[] peselChars = new char[pesel.length()];
            pesel.getChars(0,pesel.length(), peselChars, 0);
            boolean validationPesel = true;
            for(int i=0 ; i<pesel.length();i++)
            {
                if(!Character.isDigit(peselChars[i]))
                {
                    validationPesel = false;
                }
            }

            if(!validationPesel) {
                clientPeselLabel.setText("Użyto nie poprawnych znaków!");
                validation = false;
            }
        }

        if(clientToValidate.getIdNumber().length() == 0)
        {
            clientIdNumberLabel.setText(ifEmpty);
            validation=false;
        }
        else if(clientToValidate.getIdNumber().length() != 9)
        {
            clientIdNumberLabel.setText("Numer powinien mieć 9 znaków!");
            validation=false;
        }
        else
        {
            String idNumber=clientToValidate.getIdNumber();
            char[] idNumberChars = new char[idNumber.length()];
            idNumber.getChars(0,idNumber.length(), idNumberChars, 0);
            boolean validationIdNumber = true;
            for(int i=0;i<2;i++)
            {
                if(!Character.isLetter(idNumberChars[i]))
                {
                    validationIdNumber=false;
                }
            }

            for(int i=3;i<idNumber.length();i++)
            {
                if(!Character.isDigit(idNumberChars[i]))
                {
                    validationIdNumber=false;
                }
            }

            if(!validationIdNumber)
            {
                clientIdNumberLabel.setText("Niepoprawny numer dowodu!");
                validation=false;
            }
        }

        if(clientToValidate.getBirthDate() == null)
        {
            clientBirthDateLabel.setText(ifEmpty);
            validation=false;
        }
        else
        {
            Calendar now= Calendar.getInstance();
            Date today = now.getTime();

            Calendar calendarBirthDate=Calendar.getInstance();

            if(clientToValidate.getBirthDate().after(today))
            {
                clientBirthDateLabel.setText("Wprowadzono niepoprawną datę!");
                validation=false;
            }
        }

        if(clientToValidate.getCity().length() == 0)
        {
            clientCityLabel.setText(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getStreet().length() == 0)
        {
            clientStreetLabel.setText(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getApartmentNumber().length() == 0)
        {
            clientApartmentNumberLabel.setText(ifEmpty);
            validation=false;
        }


        if(clientToValidate.getPostalCode().length() == 0)
        {
            clientPostalCodeLabel.setText(ifEmpty);
            validation=false;
        }
        else
        {
            String postalCode=clientToValidate.getPostalCode();
            char[] postalCodeChars = new char[postalCode.length()];
            postalCode.getChars(0,postalCode.length(), postalCodeChars, 0);
            boolean validationPostalCode = true;
            for(int i=0;i<1;i++)
            {
                if(!Character.isDigit(postalCodeChars[i]))
                {
                    validationPostalCode=false;
                }
            }

            if(postalCodeChars[2]!='-')
            {
                validationPostalCode=false;
            }

            for(int i=3;i<postalCode.length();i++)
            {
                if(!Character.isDigit(postalCodeChars[i]))
                {
                    validationPostalCode=false;
                }
            }

            if(!validationPostalCode)
            {
                clientPostalCodeLabel.setText("Niepoprawny kod pocztowy!");
                validation=false;
            }
        }

        return validation;
    }


    public JFXButton getAddOrEditButton() {
        return addOrEditButton;
    }

    public LocalDate convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public void setClient(Client client)
    {
        this.client=client;

        LocalDate localBirthDate = convertToLocalDateTimeViaInstant(client.getBirthDate());

        clientName.setText(client.getFirstName());
        clientSurname.setText(client.getLastName());
        clientEmail.setText(client.getEmail());
        clientPhone.setText(client.getPhone());
        clientPesel.setText(client.getPesel());
        clientIdNumber.setText(client.getIdNumber());
        clientBirthDate.setValue(localBirthDate);
        clientStreet.setText(client.getStreet());
        clientCity.setText(client.getCity());
        clientApartmentNumber.setText(client.getApartmentNumber());
        clientPostalCode.setText(client.getPostalCode());
    }


    void clearLabels(){

        clientNameLabel.setText("");
        clientEmailLabel.setText("");
        clientSurnameLabel.setText("");
        clientPhoneLabel.setText("");
        clientPeselLabel.setText("");
        clientIdNumberLabel.setText("");
        clientBirthDateLabel.setText("");
        clientCityLabel.setText("");
        clientStreetLabel.setText("");
        clientApartmentNumberLabel.setText("");
        clientPostalCodeLabel.setText("");

    }

    @FXML
    void handleCancelAction(ActionEvent event) {
        HomePageController.getInstance().changeContentToKlienci(event);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}