package Szrotex3.ui.oferta;

import Szrotex3.model.Car;
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


public class OfertaController implements Initializable {


    @FXML
    public AnchorPane oferta_content_pane;


    private static OfertaController instance;

    public OfertaController(){
        instance = this;
    }
    public static OfertaController getInstance(){
        return instance;
    }

    @FXML
    private VBox container_oferta;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

       HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");
      List<Car> carObjects = (List<Car>) hibernateSession.getSession().createCriteria(Car.class).list();


        for (int i = 0; i < carObjects.size() ; i++) {
          AnchorPane carsPane;
            try {
                carsPane = FXMLLoader.load(getClass().getResource("one_car_pane.fxml"));
                OfertaCarPaneController.getInstance().setCar(carObjects.get(i));
                container_oferta.getChildren().add(carsPane);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}



