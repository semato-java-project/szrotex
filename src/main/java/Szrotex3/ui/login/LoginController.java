package Szrotex3.ui.login;
import Szrotex3.model.User;
import Szrotex3.service.Authorisation;
import Szrotex3.service.Container;
import Szrotex3.service.Registry;
import Szrotex3.ui.MainController;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends MainController {

    @FXML
    private ImageView CloseButton;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label login_label;


    private static LoginController instance;

    public LoginController() {
        instance = this;
    }

    public static LoginController getInstance() {
        return instance;
    }

    public String getUsername() {
        return username.getText();
    }


    @FXML
    void handleCloseButtonAction(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) {

        login_label.setText(" ");
        String uname = username.getText();
        String pass = password.getText();

        Authorisation authorisation = (Authorisation) Container.getBean("authorisation");

        try {
            User signedUser = authorisation.getAuthorizedUser(uname, pass);
            Registry registry = (Registry) Container.getBean("registry");
            registry.setSignedUser(signedUser);
            closeStage();
            loadPage("/Szrotex3/ui/homepage/homepage.fxml");
        } catch (Authorisation.InvalidCredentialsException e) {
            login_label.setText("Podano niepoprawne dane.");
        }


    }

    private void closeStage() {
        ((Stage) CloseButton.getScene().getWindow()).close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadPage("/Szrotex3/ui/login/login.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

