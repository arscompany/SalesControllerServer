/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.controllers;

import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.SimpleLongProperty;

/**
 *
 * @author Adriel Rosario
 */
public class Registry implements Serializable {
    
    private SimpleLongProperty idOrder;
    private String productName;
    private Date date;
    private Integer quantity;
    private Double income;

    public Registry(long idOrder, String productName, Date date, Integer quantity, Double income) {
        this.idOrder = new SimpleLongProperty(idOrder);
        this.productName = productName;
        this.date = date;
        this.quantity = quantity;
        this.income = income;
    }
    
    public Registry(){
        
    }
    
    //public Registry(){}

    public SimpleLongProperty getId() {
        return idOrder;
    }

    public void setId(long idOrder) {
        this.idOrder = new SimpleLongProperty(idOrder);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
    
}
