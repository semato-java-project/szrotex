package Szrotex3.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="pesel")
    private String pesel;

    @Column(name="id_number")
    private String idNumber;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="apartment_number")
    private String apartmentNumber;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="is_active")
    private boolean isActive = true;

    public Client()
    {
    }

    public Client(String firstName, String lastName, String email, String phone, Date createdAt, String pesel, String idNumber, Date birthDate, String city, String street, String apartmentNumber, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.pesel = pesel;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.city = city;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.postalCode = postalCode;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getAge()
    {

        Calendar now = Calendar.getInstance();
        now.setTime(Calendar.getInstance().getTime());

        Calendar calBirthDate = Calendar.getInstance();
        calBirthDate.setTime(birthDate);

        int age=now.get(Calendar.YEAR)-calBirthDate.get(Calendar.YEAR);
        if(now.get(Calendar.MONTH)<calBirthDate.get(Calendar.MONTH)) {
            age--;
        }
        else if(now.get(Calendar.MONTH)==calBirthDate.get(Calendar.MONTH))
        {
             if(now.get(Calendar.DAY_OF_MONTH)<=calBirthDate.get(Calendar.DAY_OF_MONTH)) {
                 age--;
             }
        }


        return age;
    }

    public String getAddress()
    {
        String address=this.city + ", " + this.street + " " + this.apartmentNumber + ", " + this.postalCode;
        return address;
    }

}
