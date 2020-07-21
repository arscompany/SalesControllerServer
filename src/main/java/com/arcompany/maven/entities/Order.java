/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

/**
 *
 * @author Adriel Rosario
 */
public class Order implements Serializable {
    
    private Long id;
    private Map<Product,Integer> productList;
    private Date date;
    
    public Order(Map<Product,Integer> productList, Date date){
        this.productList = productList;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<Product, Integer> productList) {
        this.productList = productList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
     
}
