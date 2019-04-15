package Szrotex3.ui.rentlist;

public class OneRentController {


    private static OneRentController instance;
    public OneRentController() {
        instance = this;
    }
    public static OneRentController getInstance() {
        return instance;
    }

}
