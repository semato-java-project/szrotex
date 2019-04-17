package Szrotex3.model;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="price")
    private double price;

    @Column(name="color")
    private String color;

    @Column(name="link_to_img")
    private String linkToImg;

    @PrimaryKeyJoinColumn
    @OneToOne(optional = true)
    private Car car;


    public Vehicle() {

    }

    public Vehicle(double price, String color, String linkToImg) {
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

    public String getLinkToImg() {
        return linkToImg;
    }

    public void setLinkToImg(String linkToImg) {
        this.linkToImg = linkToImg;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}


