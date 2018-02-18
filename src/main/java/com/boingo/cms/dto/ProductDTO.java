package com.boingo.cms.dto;

import com.boingo.cms.entity.CustomerProduct;
import com.boingo.cms.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ProductDTO {

    @JsonProperty("name")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    @JsonProperty("purchased_date")
    private Date purchasedDate;

    public ProductDTO(CustomerProduct cp) {
        if(null != cp){
            Product product = cp.getProduct();
            name = null != product ? product.getName():null;
            purchasedDate = cp.getPurchaseDate();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }
}
