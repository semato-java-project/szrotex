package Szrotex3.ui;

import Szrotex3.ui.alert.AlertController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public abstract class MainController extends Application implements Initializable {

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


    public void loadPage(String path) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL.APPLICATION_MODAL);
            stage.setTitle("Semato - Car Rent App");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            setPosition(stage);
            MovingStage(root, stage);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadAlert(String message, AnchorPane whereIsEffect) {

        try {

            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/Szrotex3/ui/alert/Alert.fxml"));
            loader.setController(new AlertController(message,whereIsEffect));
            final Parent root = loader.load();
            final Scene scene = new Scene(root);
            Stage stage = new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL.APPLICATION_MODAL);
            stage.setTitle("Semato - Alert");
            stage.setScene(scene);
            stage.setWidth(400);
            stage.setHeight(120);
            setPosition(stage);
            stage.showAndWait();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    void setPosition(Stage stage){

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

}
