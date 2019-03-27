package Szrotex3.model;

import java.util.Date;

public class Car extends Vehicle {
    private int id;
    private String brand;
    private String model;
    private double engineCapacity;
    private String engineType;
    private int enginePower;
    private int productionYear;
    private int countOfDoors;
    private int countOfSeats;

    public Car()
    {

    }

    public Car(String name, double price, String color, String linkToImg, String brand, String model, double engineCapacity, String engineType, int enginePower, int productionYear, int countOfDoors, int countOfSeats) {
        super(name, price, color, linkToImg);
        this.brand = brand;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.productionYear = productionYear;
        this.countOfDoors = countOfDoors;
        this.countOfSeats = countOfSeats;
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

    public int getCountOfDoors() {
        return countOfDoors;
    }

    public void setCountOfDoors(int countOfDoors) {
        this.countOfDoors = countOfDoors;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public void setCountOfSeats(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }
}