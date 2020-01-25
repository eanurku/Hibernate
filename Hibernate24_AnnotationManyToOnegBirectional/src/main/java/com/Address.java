package com;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    int id;
    @Column(name = "street")
    String street;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "country")
    String country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "address")
    List<Employee> employee;

    public Address() {
    }

    public Address(String street, String city, String state, String country, List<Employee> employee) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", employee=" + employee +
                '}';
    }
}
