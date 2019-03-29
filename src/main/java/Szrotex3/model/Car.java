package Szrotex3.model;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "engineCapacity")
    private double engineCapacity;

    @Column(name = "engineType")
    private String engineType;

    @Column(name = "transsmision")
    private String transsmision;

    @Column(name = "enginePower")
    private int enginePower;

    @Column(name = "productionYear")
    private int productionYear;

    @Column(name = "doorsQuantity")
    private int doorsQuantity;

    @Column(name = "seatsQuantity")
    private int seatsQuantity;

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Vehicle vehicle;

    public Car()
    {

    }

    public Car(Vehicle vehicle, String brand, String model, double engineCapacity, String engineType, String transsmision, int enginePower, int productionYear, int doorsQuantity, int seatsQuantity) {
        this.setVehicle(vehicle);
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
        this.transsmision = transsmision;
        this.enginePower = enginePower;
        this.productionYear = productionYear;
        this.doorsQuantity = doorsQuantity;
        this.seatsQuantity = seatsQuantity;

    }

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
        this.id= vehicle.getId();
        this.vehicle = vehicle;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getTranssmision() {
        return transsmision;
    }

    public void setTranssmision(String transsmision) {
        this.transsmision = transsmision;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public int getDoorsQuantity() {
        return doorsQuantity;
    }

    public void setDoorsQuantity(int doorQuantity) {
        this.doorsQuantity = doorsQuantity;
    }

    public int getSeatsQuantity() {
        return seatsQuantity;
    }

    public void setSeatsQuantity(int seatsQuantity) {
        this.seatsQuantity = seatsQuantity;
    }
}