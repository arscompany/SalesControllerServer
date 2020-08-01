/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.controllers;

import com.arcompany.maven.DaoImpl.DaoImplOrder;
import com.arcompany.maven.entities.Order;
import com.arcompany.maven.entities.Product;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Adriel Rosario
 */
public class ServerControllerEliminado implements Initializable {
    
    private DaoImplOrder daoImplOrder = new DaoImplOrder("ordersList.txt");
    private ObservableList listOfRecords = FXCollections.observableArrayList();
    @FXML private TableView<Registry> dataTable = new TableView();
    @FXML private TableColumn<Registry, Long> orderColumn = new TableColumn<Registry, Long>("Order");
    @FXML private TableColumn<Registry, String> productColumn = new TableColumn<Registry, String>("Product");
    @FXML private TableColumn<Registry, Date> dateColumn = new TableColumn<Registry, Date>("Date");
    @FXML private TableColumn<Registry, Integer> quantityColumn = new TableColumn<Registry, Integer>("Quantity");
    @FXML private TableColumn<Registry, Double> incomeColumn = new TableColumn<Registry, Double>("Income");
    
    private void loadTable(){
        
        listOfRecords.clear();
        
        for(Order order: daoImplOrder.findAll()){
            int quantityIt = 0;
            Long idOrder = order.getId();       
            
            for(Product product: order.getProductList()){
                
                String productName = product.getName();
                Date date = order.getDate();
                Integer quantity = order.getQuantityList().get(quantityIt);
                Double income = (quantity)*(product.getPrice());
                Registry registry = new Registry(idOrder, productName, date, quantity, income);
                listOfRecords.add(registry);
                quantityIt++;
                System.out.println(idOrder);
            }
            
        }
        
        /*Iterator<Order> it = daoImplOrder.findAll().iterator();
        while(it.hasNext()){
            int quantityIt = 0;
            Long idOrder = it.next().getId();
            
            for(Product product: it.next().getProductList()){
                String productName = product.getName();
                Date date = it.next().getDate();
                Integer quantity = it.next().getQuantityList().get(quantityIt);
                Double income = (quantity)*(product.getPrice());
                Registry registry = new Registry(idOrder, productName, date, quantity, income);
                listOfRecords.add(registry);
                quantityIt++;
                System.out.println(idOrder);
            }
        }*/
        
        dataTable.getItems().clear();
        dataTable.getItems().addAll(listOfRecords);
    }
    
    @FXML private void refresh(ActionEvent event){
        loadTable();      
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        orderColumn.setCellValueFactory(new PropertyValueFactory<Registry, Long>("idOrder"));
        productColumn.setCellValueFactory(new PropertyValueFactory<Registry, String>("productName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Registry, Date>("date"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Registry, Integer>("quantity"));
        incomeColumn.setCellValueFactory(new PropertyValueFactory<Registry, Double>("income"));
        loadTable();
        
    }
    
}
