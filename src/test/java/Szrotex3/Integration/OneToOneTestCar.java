package Szrotex3.Integration;

import Szrotex3.model.Boat;
import Szrotex3.model.Car;
import Szrotex3.model.Vehicle;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import org.junit.Test;

import static org.junit.Assert.*;


public class OneToOneTestCar {

    @Test
    public void vehicleBoatOneToOneTest() {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");


        Vehicle newVehicle = new Vehicle("Maxus 33", 42, "black", "/src/main/resources/assets/jakisorbrazek.img");
        hibernateSession.getSession().persist(newVehicle);

        /*Boat newBoat = new Boat(newVehicle,6201);
        hibernateSession.getSession().persist(newBoat);*/

        Car newCar = new Car(newVehicle, "Peugeot", "206", 1.4, "diesel", "manual", 125, 2000, 2, 5);
        hibernateSession.getSession().persist(newCar);
        hibernateSession.getSession().flush();

        int carId = newCar.getId();
        System.out.println("CarId: " + carId);

        Car fetchedCar = (Car)  hibernateSession.getSession().get(Car.class, carId);

        assertNotNull(fetchedCar);

        assertEquals(newCar.getBrand(), fetchedCar.getBrand());

        Vehicle fetchedVehicle = fetchedCar.getVehicle();


        assertNotNull(fetchedVehicle);

        assertEquals(newVehicle.getName(), fetchedVehicle.getName());

        int vehicleId = fetchedVehicle.getId();

        System.out.println("VehicleId: " + vehicleId);

        hibernateSession.getSession().delete(fetchedCar);
        hibernateSession.getSession().flush();

        Car deletedCar = (Car)  hibernateSession.getSession().get(Car.class, carId);
        Vehicle deletedVehicle = (Vehicle)  hibernateSession.getSession().get(Vehicle.class, vehicleId);

        assertNull(deletedCar);
        assertNull(deletedVehicle);

    }

}
