package Szrotex3.ui.klienci;


import Szrotex3.model.Client;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import Szrotex3.ui.homepage.HomePageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class contentKlienciController implements Initializable {


    private static  contentKlienciController instance;

    public contentKlienciController() {
        instance = this;
    }

    public static contentKlienciController getInstance(){
        return instance;
    }
    @FXML
    private VBox client_container;

    public AnchorPane getMainAnchorPane() {
        return MainAnchorPane;
    }

    @FXML
    private AnchorPane MainAnchorPane;


    @FXML
    void AddNewClient(ActionEvent event) {
        HomePageController.getInstance().changeContentToAddNewClient(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");
        List<Client> clientObjects = (List<Client>) hibernateSession.getSession().createCriteria(Client.class).list();

        for (int i = 0; i < clientObjects.size(); i++) {
                Node clients;
            try {
                if(clientObjects.get(i).isActive()==true) {
                    clients = FXMLLoader.load(getClass().getResource("client.fxml"));
                    ClientController.getInstance().setClient(clientObjects.get(i));
                    client_container.getChildren().add(clients);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
