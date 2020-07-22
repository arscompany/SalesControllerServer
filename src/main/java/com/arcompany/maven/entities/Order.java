/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import java.util.Map;

/**
 *
 * @author Adriel Rosario
 */
public class Order implements Serializable {
    
    private Long id;
    private List<Product> productList;
    private List<Integer> quantityList;
    private Date date;
    
    public Order(List<Product> productList, List<Integer> quantityList, Date date){
        this.productList = productList;
        this.quantityList = quantityList;
        this.date = date;
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
