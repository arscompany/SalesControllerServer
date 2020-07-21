/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.entities;

import java.io.Serializable;

/**
 *
 * @author Adriel Rosario
 */

public class Product implements Serializable {
    
    private Long id;
    private String name;
    private Double price;
    
    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
