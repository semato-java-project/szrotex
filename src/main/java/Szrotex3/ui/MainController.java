package Szrotex3.ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public abstract class MainController extends Application implements Initializable{

    private double xOffset = 0;
    private double yOffset = 0;


    @FXML
    private ImageView CloseButton;

    @FXML
    void handleCloseButtonAction(MouseEvent event) {
        System.exit(0);
    }


    public void MovingStage(Parent root, Stage stage) {

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }


    public void loadPage(String path){
        try{

            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setTitle("Semato - Car Rent App");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            MovingStage(root,stage);
        }   catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
