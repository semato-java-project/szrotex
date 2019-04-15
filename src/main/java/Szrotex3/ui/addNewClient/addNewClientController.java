package Szrotex3.ui.addNewClient;

import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import Szrotex3.ui.homepage.HomePageController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addNewClientController {

    private static addNewClientController instance;

    public addNewClientController(){
        instance = this;
    }
    public static addNewClientController getInstance(){
        return instance;
    }

    private Client client;

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
    private JFXButton addOrEditButton;



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

        if(localBirthDate != null) {
            Calendar now = Calendar.getInstance();
            Date createAt = now.getTime();

            Calendar calendarBirthDate = Calendar.getInstance();

            calendarBirthDate.set(
                    localBirthDate.getYear(),
                    localBirthDate.getMonthValue() - 1,
                    localBirthDate.getDayOfMonth()
            );

            Date birthDate = calendarBirthDate.getTime();

            Client newClient = new Client(firstName, lastName, email, phone, createAt, pesel, idNumber, birthDate, city, street, apartmentNumber, postalCode);

            if (addNewClientController.getInstance().validate(newClient)) {

                HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");

                hibernateSession.getSession().persist(newClient);
                hibernateSession.getSession().flush();

                //prompt o dodaniu nowego klienta, wymazanie pol.
            }
        }
        else
        {
            System.out.println("Wprowadź datę urodzenia!");
        }


        //HomePageController.getInstance().changeContentToKlienci(event);



        //TODO: dodac walidacje, poprawic polskie znaki, zastanowić się nad iteracyjnym dodawaniem id (następny w tablicy)


    }


    private boolean validate(Client clientToValidate)
    {
        boolean validation=true;
        String ifEmpty="Pole nie może być puste!";

        if(clientToValidate.getFirstName().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getLastName().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getEmail().length() == 0)
        {
            System.out.println(ifEmpty);
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
                System.out.println("Wprowadzono nie poprawny mail!");
            }

        }

        if(clientToValidate.getPhone().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }
        else if(clientToValidate.getPhone().length() != 9)
        {
            System.out.println("Dlugość telefonu musi wynosić 9 znaków");
            validation=false;
        }

        if(clientToValidate.getPesel().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }
        else if(clientToValidate.getPesel().length() != 11)
        {
            System.out.println("Pesel ma 11 znaków!");
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
                System.out.println("Użyto nie poprawnych znaków!");
                validation = false;
            }
        }

        if(clientToValidate.getIdNumber().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }
        else if(clientToValidate.getIdNumber().length() != 9)
        {
            System.out.println("Numer dowodu ma 9 znaków!");
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
                System.out.println("Niepoprawny numer dowodu!");
                validation=false;
            }
        }

        if(clientToValidate.getBirthDate() == null)
        {
            System.out.println(ifEmpty);
            validation=false;
        }
        else
        {
            Calendar now= Calendar.getInstance();
            Date today = now.getTime();

            Calendar calendarBirthDate=Calendar.getInstance();

            if(clientToValidate.getBirthDate().after(today))
            {
                System.out.println("Wprowadzono niepoprawną datę!");
                validation=false;
            }
        }

        if(clientToValidate.getCity().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getStreet().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }

        if(clientToValidate.getApartmentNumber().length() == 0)
        {
            System.out.println(ifEmpty);
            validation=false;
        }


        if(clientToValidate.getPostalCode().length() == 0)
        {
            System.out.println(ifEmpty);
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
                System.out.println("Niepoprawny kod pocztowy!");
                validation=false;
            }
        }

        return validation;
    }


    public JFXButton getAddOrEditButton() {
        return addOrEditButton;
    }

    public void setClient(Client client)
    {
        this.client=client;

        clientName.setText(client.getFirstName());
        clientSurname.setText(client.getLastName());
        clientEmail.setText(client.getEmail());
        clientPhone.setText(client.getPhone());
        clientPesel.setText(client.getPesel());
        clientIdNumber.setText(client.getIdNumber());
        //aclientBirthDate.setText(String.valueOf(client.getBirthDate()));
        clientStreet.setText(client.getStreet());
        clientCity.setText(client.getCity());
        clientApartmentNumber.setText(client.getApartmentNumber());
        clientPostalCode.setText(client.getPostalCode());
    }


    @FXML
    void handleCancelAction(ActionEvent event) {
        HomePageController.getInstance().changeContentToKlienci(event);
    }

}