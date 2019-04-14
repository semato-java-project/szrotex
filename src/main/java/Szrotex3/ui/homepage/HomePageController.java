package Szrotex3.ui.homepage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Szrotex3.ui.MainController;
import Szrotex3.ui.login.LoginController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomePageController extends MainController {

    @FXML
    AnchorPane MainAnchorPane;

    @FXML
    private Text username;

    @FXML
    AnchorPane holderPane;

    @FXML
    AnchorPane oferta_content_pane;

    @FXML
    private JFXButton LogOutButton;

    @FXML
    private JFXButton OfertaButton;

    @FXML
    private JFXButton ClientButton;

    @FXML
    private JFXButton AddClientButton;

    @FXML
    private JFXButton RentButton;


    @FXML
    private Text TopPathInfo;


    private static HomePageController instance;
    public HomePageController(){
        instance = this;
    }
    public static HomePageController getInstance(){
        return instance;
    }


    public void setTopPath(String name){
        TopPathInfo.setText(name);
    }

    public void setUsername(String uname){
        this.username.setText(uname);
    }

    private void setNode(Node node){
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);
    }

    public void createContentPage(AnchorPane Content, String loc)
    {
        try {
            Content = FXMLLoader.load(getClass().getResource(loc));
            setNode(Content);
        } catch(IOException e ) {
            e.printStackTrace();
        }
    }

   @FXML
   void logOut(ActionEvent event){
      ((Stage)LogOutButton.getScene().getWindow()).close();
       loadPage("/Szrotex3/ui/login/login.fxml");
   }

   // Dlaczego musze miec ta funkcje start tutaj, skoro nie chce odpalac apki z tego kontrolera?
    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createContentPage(holderPane, "/Szrotex3/ui/oferta/content_oferta.fxml");
        setUsername("Witaj, " + LoginController.getInstance().getUsername());
        setTopPath("Oferta");

    }

    @FXML
    void changeContentToOferta(ActionEvent event) {
        createContentPage(holderPane, "/Szrotex3/ui/oferta/content_oferta.fxml");
        setTopPath("Oferta");
    }
    @FXML
    public void changeContentToOferta() {
        createContentPage(holderPane, "/Szrotex3/ui/oferta/content_oferta.fxml");
        setTopPath("Oferta");
    }

    @FXML
    public void changeContentToKlienci(ActionEvent event) {
        createContentPage(holderPane, "/Szrotex3/ui/klienci/content_klienci.fxml");
        setTopPath("Klienci");
    }

    @FXML
    void changeContentToWypozyczenia(ActionEvent event) {
        createContentPage(holderPane, "/Szrotex3/ui/wypozyczenia/content_wypozyczenia.fxml");
        setTopPath("Wypożyczenia");
    }

    @FXML
    public void changeContentToAddNewClient(ActionEvent event) {
        createContentPage(holderPane, "/Szrotex3/ui/addNewClient/contentAddNewClient.fxml");
        setTopPath("Dodaj Klienta");
    }

    @FXML
    public void changeContentToEditClient(ActionEvent event) {
        createContentPage(holderPane, "/Szrotex3/ui/addNewClient/contentAddNewClient.fxml");
        setTopPath("Edytuj Klienta");
    }

}
