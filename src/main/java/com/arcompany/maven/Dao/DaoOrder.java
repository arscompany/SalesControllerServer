/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.Dao;

import com.arcompany.maven.entities.Order;
import java.util.List;

/**
 *
 * @author Adriel Rosario
 */
public interface DaoOrder extends GenericDao <Order,Long> {
    
    public void create(Order entity, String path);
    public List<Order> findAll(String path);
    
}
