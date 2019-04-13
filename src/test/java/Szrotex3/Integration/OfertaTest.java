package Szrotex3.Integration;

import Szrotex3.Main;
import Szrotex3.model.Car;
import Szrotex3.model.Vehicle;
import org.junit.Test;

public class OfertaTest {
    @Test
    public void vehicleInOfertaTest() {
       // Main.main();
        Vehicle v1 = new Vehicle(230000, "black", "xxx");
        Car s1 = new Car(v1, "Marka", "Model", 4400, "rodzaj paliwa", "automat", 420, 2018, 5, 5);
    }
}
