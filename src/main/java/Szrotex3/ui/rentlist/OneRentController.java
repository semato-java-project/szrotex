package Szrotex3.ui.rentlist;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class OneRentController {

    @FXML
    private Text carBrand;

    @FXML
    private Text carModel;

    @FXML
    private Text dateStart;

    @FXML
    private Text dateEnd;

    @FXML
    private Text rentPrice;

    @FXML
    private Text Price1;

    @FXML
    private Text carId;

    @FXML
    private Text clientId;

    @FXML
    private Text clientName;

    @FXML
    private Text clientSurname;

    @FXML
    private Text rentId;


    private static OneRentController instance;
    public OneRentController() {
        instance = this;
    }
    public static OneRentController getInstance() {
        return instance;
    }

}
