package service;

import Szrotex3.model.Client;
import Szrotex3.model.Vehicle;
import Szrotex3.service.Container;
import Szrotex3.service.HibernateSession;
import Szrotex3.service.Reservation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReservationTest {

    private Date getDate(int year,int month,int day, int hour, int minute, int second){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        return cal.getTime();
    }

    @Test
    public void isAvailableTest() {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");
        Reservation reservationService = (Reservation) Container.getBean("reservation");

        Vehicle vehicle = new Vehicle(42, "black", "img.jpg");
        hibernateSession.getSession().persist(vehicle);

        Client client = new Client();
        client.setEmail("reservationTest@example.com");
        client.setFirstName("Test");
        client.setLastName("Test");
        client.setPhone("123456");
        hibernateSession.getSession().persist(client);

        Szrotex3.model.Reservation reservation = new Szrotex3.model.Reservation();
        reservation.setClient(client);
        reservation.setDateStart(getDate(1975, 01, 20, 12,52,33));
        reservation.setDateEnd(getDate(1975, 01, 25, 12,52,33));
        reservation.setVehicle(vehicle);
        hibernateSession.getSession().persist(reservation);

        hibernateSession.getSession().flush();

        assertFalse(reservationService.isAvailable(
                vehicle,
                getDate(1975, 01, 19, 12,52,33),
                getDate(1975, 01, 26, 12,52,33)
        ));

        assertFalse(reservationService.isAvailable(
                vehicle,
                getDate(1975, 01, 25, 12,52,33),
                getDate(1975, 01, 29, 12,52,33)
        ));

        assertFalse(reservationService.isAvailable(
                vehicle,
                getDate(1975, 01, 17, 12,52,33),
                getDate(1975, 01, 20, 12,52,33)
        ));

        assertTrue(reservationService.isAvailable(
                vehicle,
                getDate(1975, 01, 10, 12,52,33),
                getDate(1975, 01, 20, 12,52,32)
        ));

        assertTrue(reservationService.isAvailable(
                vehicle,
                getDate(1975, 01, 25, 12,52,34),
                getDate(1975, 01, 29, 12,52,33)
        ));

        try {
            reservationService.isAvailable(
                    vehicle,
                    getDate(1975, 01, 25, 12,52,34),
                    getDate(1975, 01, 24, 12,52,33)
            );
            assertFalse(true); // Nie powinno dojść do tej linijki bo wyjątek.
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "End date must be greather than start date.");
        }

        hibernateSession.getSession().delete(reservation);
        hibernateSession.getSession().delete(vehicle);
        hibernateSession.getSession().delete(client);
        hibernateSession.getSession().flush();

    }

    @Test
    public void makeReservationTest() {

        HibernateSession hibernateSession = (HibernateSession) Container.getBean("hibernateSession");
        Reservation reservationService = (Reservation) Container.getBean("reservation");

        Vehicle vehicle = new Vehicle(42, "black", "img.jpg");
        hibernateSession.getSession().persist(vehicle);

        Client client = new Client();
        client.setEmail("reservationTest@example.com");
        client.setFirstName("Test");
        client.setLastName("Test");
        client.setPhone("123456");
        hibernateSession.getSession().persist(client);

        Date dateStart = getDate(1975, 02, 20, 12,52,33);
        Date dateEnd = getDate(1975, 02, 25, 12,52,33);

        Szrotex3.model.Reservation reservation = reservationService.makeReservation(vehicle, client, dateStart, dateEnd);

        Criteria criteria = hibernateSession.getSession().createCriteria(Szrotex3.model.Reservation.class);
        criteria.add(Restrictions.eq("vehicle", vehicle));
        criteria.add(Restrictions.eq("client", client));
        criteria.add(Restrictions.eq("dateStart", dateStart));
        criteria.add(Restrictions.eq("dateEnd", dateEnd));

        List<Reservation> reservationObjects = (List<Reservation>) criteria.list();

        assertEquals(reservationObjects.size(), 1);

        hibernateSession.getSession().delete(reservation);
        hibernateSession.getSession().delete(vehicle);
        hibernateSession.getSession().delete(client);
        hibernateSession.getSession().flush();

    }

}
