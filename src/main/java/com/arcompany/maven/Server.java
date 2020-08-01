/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven;

import com.arcompany.maven.DaoImpl.DaoImplOrder;
import com.arcompany.maven.entities.Order;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriel Rosario
 */
public class Server extends Thread {
    
    DaoImplOrder daoImplOrder = new DaoImplOrder("ordersList.txt");
    
    @Override
    public void run(){
        try{
            ServerSocket server = new ServerSocket(55555);
            while(true){
                Socket socket = server.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Order order = (Order) in.readObject();              
                daoImplOrder.create(order);
                in.close();
                socket.close();
                System.out.println(order.getProductList().get(0).getName());
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
