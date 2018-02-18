package com.boingo.cms.entity;

import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="customer")
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private List<CustomerAddress> addresses = Lists.newArrayListWithCapacity(1);
    private List<CustomerProduct> products = Lists.newArrayListWithCapacity(1);

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, List<CustomerAddress> addresses, List<CustomerProduct> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.products = products;
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
    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    public List<CustomerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddress> addresses) {
        this.addresses = addresses;
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    public List<CustomerProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CustomerProduct> products) {
        this.products = products;
    }
}
