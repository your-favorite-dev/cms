package com.boingo.cms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerDTO {
    @JsonProperty("billing_address")
    private AddressDTO billingAddress;
    @JsonProperty("mailing_address")
    private AddressDTO mailingAddress;
    @JsonProperty("customer_id")
    private int id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("active_products")
    private List<ProductDTO> products;

    public AddressDTO getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressDTO billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AddressDTO getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(AddressDTO mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
