package com.boingo.cms.entity;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="address")
public class Address {

    private int id;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private List<CustomerAddress> customers = Lists.newArrayListWithCapacity(1);

    public Address() {
    }

    public Address(int id, String streetAddress, String city, String state, String postalCode, String country, List<CustomerAddress> customers) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.customers = customers;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="street_address",nullable=false)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    @Column(name="city",nullable=false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(name="state",nullable=false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @Column(name="mailing_postal_code",nullable=false)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    @Column(name="mailing_country",nullable=false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
    public List<CustomerAddress> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerAddress> customers) {
        this.customers = customers;
    }
}
