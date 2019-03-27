package Szrotex3.model;

public class Vehicle {

    private int id;
    private String name;
    private double price;
    private String color;
    private String linkToImg;

    public Vehicle() {

    }

    public Vehicle(String name, double price, String color, String linkToImg) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.linkToImg = linkToImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}


