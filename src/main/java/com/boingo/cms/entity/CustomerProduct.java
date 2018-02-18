package com.boingo.cms.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomerProduct {

    private CustomerProductId id;

    private Customer customer;
    private Product product;
    private Date purchaseDate;

    public CustomerProduct() {
    }

    public CustomerProduct(CustomerProductId id, Customer customer, Product product, Date purchaseDate) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.purchaseDate = purchaseDate;
    }

    @EmbeddedId
    public CustomerProductId getId() {
        return id;
    }

    public void setId(CustomerProductId id) {
        this.id = id;
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
    @MapsId("productId")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="purchase_date",nullable=false)
    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
