package Szrotex3.model;

import javax.persistence.*;

@Entity
@Table(name = "boat")
public class Boat {

    @Id
    @Column(name = "id")
    private int id;

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Vehicle vehicle;

    @Column(name = "displacement")
    private int displacement;

    public Boat() {

    }

    public Boat(Vehicle vehicle, int displacement) {
        this.setVehicle(vehicle);
        this.displacement = displacement;
    }

    public int getId() {
        return id;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.vehicle = vehicle;
    }

}


