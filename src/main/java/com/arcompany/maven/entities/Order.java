/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Adriel Rosario
 */
public class Order implements Serializable {
    
    private Long id;
    private List<Product> productList;
    private List<Integer> quantityList;
    Date date;
    
    public Order(List<Product> productList, List<Integer> quantityList){
        this.productList = productList;
        this.quantityList = quantityList;
        this.date = new Date();      
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Integer> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(List<Integer> quantityList) {
        this.quantityList = quantityList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
}
