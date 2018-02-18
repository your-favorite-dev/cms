package com.boingo.cms.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerAddressId implements Serializable {


    private int customerId;
    private int addressId;

    @Column(name="customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Column(name="address_id")
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
