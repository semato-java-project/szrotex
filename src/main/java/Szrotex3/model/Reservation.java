package Szrotex3.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;


    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable=false)
    private Vehicle vehicle;


    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;


    @Column(name="date_start")
    private Date dateStart;


    @Column(name="date_end")
    private Date dateEnd;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateStart() {
        return dateStart;
    }


    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }


    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
