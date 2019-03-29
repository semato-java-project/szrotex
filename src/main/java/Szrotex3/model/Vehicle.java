package Szrotex3.model;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="color")
    private String color;

    @Column(name="linkToImg")
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


