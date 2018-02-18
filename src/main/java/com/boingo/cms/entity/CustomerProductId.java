package com.boingo.cms.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerProductId implements Serializable{

    private int customerId;
    private int productId;

    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }
    @Column(name = "product_id")
    public void setProductId(int productId) {
        this.productId = productId;
    }
}
