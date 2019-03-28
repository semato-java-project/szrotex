package Szrotex3.Integration;

import Szrotex3.model.Boat;
import Szrotex3.model.Vehicle;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneToOneTest {

    @Test
    public void vehicleBoatOneToOneTest() {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");

        Vehicle newVehicle = new Vehicle("Maxus 33", 42, "black");
        hibernateSession.getSession().persist(newVehicle);

        Boat newBoat = new Boat(newVehicle,6201);

        hibernateSession.getSession().persist(newBoat);
        hibernateSession.getSession().flush();

        int boatId = newBoat.getId();

        Boat fetchedBoat = (Boat)  hibernateSession.getSession().get(Boat.class, boatId);

        assertNotNull(fetchedBoat);

        assertEquals(newBoat.getDisplacement(), fetchedBoat.getDisplacement());

        Vehicle fetchedVehicle = fetchedBoat.getVehicle();

        assertNotNull(fetchedVehicle);

        assertEquals(newVehicle.getName(), fetchedVehicle.getName());

        int vehicleId = fetchedVehicle.getId();

        hibernateSession.getSession().delete(fetchedBoat);
        hibernateSession.getSession().flush();

        Boat deletedBoat = (Boat)  hibernateSession.getSession().get(Boat.class, boatId);
        Vehicle deletedVehicle = (Vehicle)  hibernateSession.getSession().get(Vehicle.class, vehicleId);

        assertNull(deletedBoat);
        assertNull(deletedVehicle);

    }

}
