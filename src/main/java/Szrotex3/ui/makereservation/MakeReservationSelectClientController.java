package Szrotex3.ui.makereservation;

import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MakeReservationSelectClientController implements Initializable {

    @FXML
    private Pane TopPane;

    @FXML
    private ImageView CloseButton;

    @FXML
    private VBox SelectClient_container;

    private static MakeReservationSelectClientController instance;

    public MakeReservationSelectClientController(){
        instance = this;
    }
    public static MakeReservationSelectClientController getInstance(){
        return instance;
    }

    @FXML
    public void handleCloseButtonAction(MouseEvent event) {
        CloseWindow();
        MakeReservationController.getInstance().makereservation_content_pane.setEffect(null);
    }

     public void CloseWindow(){
        ((Stage) CloseButton.getScene().getWindow()).close();
     }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");
        List<Client> clientObjects = (List<Client>) hibernateSession.getSession().createCriteria(Client.class).list();

        for (int i = 0; i < clientObjects.size(); i++) {
            AnchorPane clientsPane;
            try {
                clientsPane = FXMLLoader.load(getClass().getResource("mk_reserv_one_client_pane.fxml"));
                MkReservOneClientController.getInstance().setClient_name(clientObjects.get(i).getFirstName());
                MkReservOneClientController.getInstance().setClient_surname(clientObjects.get(i).getLastName());
                SelectClient_container.getChildren().add(clientsPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
