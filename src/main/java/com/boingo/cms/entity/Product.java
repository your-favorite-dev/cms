package com.boingo.cms.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="product")
public class Product {

    private int id;
    private String name;

    public Product() {
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Column(name="product_name",nullable=false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

