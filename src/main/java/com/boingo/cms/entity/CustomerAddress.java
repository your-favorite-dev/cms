package com.boingo.cms.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {


    private CustomerAddressId id;
    private Customer customer;
    private Address address;
    private AddressType type;

    public CustomerAddress() {
    }

    public CustomerAddress(CustomerAddressId id, Customer customer, Address address, AddressType type) {
        this.id = id;
        this.customer = customer;
        this.address = address;
        this.type = type;
    }

    @ManyToOne
    @MapsId("customerId")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @MapsId("addressId")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    @EmbeddedId
    public CustomerAddressId getId() {
        return id;
    }

    public void setId(CustomerAddressId id) {
        this.id = id;
    }
}
