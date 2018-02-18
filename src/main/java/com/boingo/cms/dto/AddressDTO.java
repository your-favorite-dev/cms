package com.boingo.cms.dto;

import com.boingo.cms.entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDTO {
    @JsonProperty("street_address")
    private String streetAddress;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("mailing_postal_code")
    private String postalCode;
    @JsonProperty("mailing_country")
    private String country;

    public AddressDTO(Address address) {
        if(null != address){
            this.state=address.getState();
            this.city=address.getCity();
            this.country=address.getCountry();
            this.postalCode=address.getPostalCode();
            this.streetAddress=address.getStreetAddress();
        }
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
