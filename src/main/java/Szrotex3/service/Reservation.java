package Szrotex3.service;

import Szrotex3.model.Client;
import Szrotex3.model.Vehicle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Reservation {

    private HibernateSession hibernateSession;

    @Autowired
    public Reservation(HibernateSession hibernateSession) {

        this.hibernateSession = hibernateSession;
    }

    public boolean isAvailable(Vehicle vehicle, Date dateStart, Date dateEnd) {

        if (dateStart.compareTo(dateEnd) >= 0) {
            throw new RuntimeException("End date must be greather than start date.");
        }

        Session session = this.hibernateSession.getSession();

        Criteria criteria = session.createCriteria(Szrotex3.model.Reservation.class);
        criteria.add(Restrictions.eq("vehicle", vehicle));
        criteria.add(Restrictions.or()
                .add(Restrictions.and()
                        .add(Restrictions.ge("dateStart", dateStart))
                        .add(Restrictions.le("dateStart", dateEnd))
                )
                .add(Restrictions.and()
                        .add(Restrictions.ge("dateEnd", dateStart))
                        .add(Restrictions.le("dateEnd", dateEnd))
                )
                .add(Restrictions.and()
                        .add(Restrictions.ge("dateEnd", dateEnd))
                        .add(Restrictions.le("dateStart", dateStart))
                )
        );

        List<Reservation> reservationObjects = (List<Reservation>) criteria.list();

        if (reservationObjects.size() > 0) {
            return false;
        }

        return true;

    }


    public Szrotex3.model.Reservation makeReservation(Vehicle vehicle, Client client, Date dateStart, Date dateEnd) {

        if (! isAvailable(vehicle, dateStart, dateEnd)) {
            return null;
        }

        Szrotex3.model.Reservation reservation = new Szrotex3.model.Reservation();
        reservation.setClient(client);
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);
        reservation.setVehicle(vehicle);

        hibernateSession.getSession().persist(reservation);
        hibernateSession.getSession().flush();

        return reservation;
    }

    public double countPrice(Szrotex3.model.Reservation reservation) {
        long diff = reservation.getDateEnd().getTime() - reservation.getDateStart().getTime();
        return (reservation.getVehicle().getPrice() * diff) / (1000 * 60 * 60 * 24);
    }


}
