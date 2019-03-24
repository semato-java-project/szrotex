package Szrotex3;

import Szrotex3.model.Vehicle;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");

        Vehicle vehicle = (Vehicle)  hibernateSession.getSession().load(Vehicle.class, new Integer(1));
        if(vehicle != null)
            System.out.println(vehicle.getName());


        launch();
    }

}
