/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.DaoImpl;

import com.arcompany.maven.Dao.DaoOrder;
import com.arcompany.maven.entities.Order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriel Rosario
 */
public class DaoImplOrder implements DaoOrder {
    
    private List<Order> ordersList = new ArrayList<Order>();
    private String path;
    
    public DaoImplOrder(String path){
        this.path = path;
    }

    @Override
    public void modify(Order entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Order entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void create(Order entity) {
                
        //LEER
        try{
            FileInputStream fileIn = new FileInputStream(this.path);
            
            ObjectInputStream entrada = new ObjectInputStream(fileIn);
            this.ordersList = (List<Order>) entrada.readObject();
            entrada.close();
            fileIn.close();
            
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        
        //ESCRIBIR
        try{
            FileOutputStream fileOut = new FileOutputStream(path);
            
            ObjectOutputStream salida = new ObjectOutputStream(fileOut);
            this.ordersList.add(entity);
            salida.writeObject(ordersList);
            this.ordersList.clear();
            salida.close();
            fileOut.close();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> ordersList = new ArrayList<Order>();
        
        try{
            FileInputStream fileIn = new FileInputStream(this.path);
            ObjectInputStream entrada = new ObjectInputStream(fileIn);
            ordersList = (List<Order>) entrada.readObject();
            entrada.close();
            fileIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return ordersList;
    }
    
}
