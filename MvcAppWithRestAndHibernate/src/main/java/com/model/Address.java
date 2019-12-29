package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "address")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("address_id")
    int id;

    @Column(name = "country")
    @JsonProperty("address_country")
    String country;

    @Column(name = "state")
    @JsonProperty("address_state")
    String state;

    @Column(name = "city")
    @JsonProperty("address_city")
    String city;

    @Column(name = "pin")
    @JsonProperty("address_pin")
    Long pin;

    public Address() {
    }

    public Address(String country, String state, String city, Long pin) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.pin = pin;
    }

    public Address(int id, String country, String state, String city, Long pin) {
        this.id = id;
        this.country = country;
        this.state = state;
        this.city = city;
        this.pin = pin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", pin=" + pin +
                '}';
    }
}
