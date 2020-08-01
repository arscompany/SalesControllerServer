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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleLongProperty;
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
public class ServerController implements Initializable {

    private DaoImplOrder daoImplOrder = new DaoImplOrder("ordersList.txt");
    private List<Registry> registryList = new ArrayList<Registry>();
    private ObservableList listOfRecords = FXCollections.observableArrayList();
    @FXML private TableView<Registry> dataTable = new TableView();
    @FXML private TableColumn<Registry, SimpleLongProperty> orderColumn = new TableColumn<Registry, SimpleLongProperty>("Order");
    @FXML private TableColumn<Registry, String> productColumn = new TableColumn<Registry, String>("Product");
    @FXML private TableColumn<Registry, Date> dateColumn = new TableColumn<Registry, Date>("Date");
    @FXML private TableColumn<Registry, Integer> quantityColumn = new TableColumn<Registry, Integer>("Quantity");
    @FXML private TableColumn<Registry, Double> incomeColumn = new TableColumn<Registry, Double>("Income");
    
    
    private void loadList(){
        listOfRecords.clear();
        int quantityIt = 0;
        
        for(Order order: daoImplOrder.findAll()){
            
            for(Product p: order.getProductList()){
                Long idOrder = order.getId();
                String productName = p.getName();
                Date date = order.getDate();
                Integer quantity = order.getQuantityList().get(quantityIt);
                Double income = (quantity)*(p.getPrice());
                Registry registry = new Registry(idOrder, productName, date, quantity, income);
                registryList.add(registry);
                listOfRecords.add(registry);
            }
        }
        System.out.println("Se ha cargado la lista exitosamente");
        
    }
    
    
    
    private void loadTable(){
        
        for(Object re: this.listOfRecords){
            Registry r = (Registry) re;
            System.out.println(r.getId()+" "+r.getProductName()+" "+r.getDate()+" "+r.getQuantity()+" "+r.getIncome());
        }
        
       dataTable.setItems(listOfRecords);
    }
    
    @FXML private void refresh(ActionEvent event){
        loadTable();      
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderColumn.setCellValueFactory(new PropertyValueFactory<Registry, SimpleLongProperty>("idOrder"));
        productColumn.setCellValueFactory(new PropertyValueFactory<Registry, String>("productName"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Registry, Date>("date"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Registry, Integer>("quantity"));
        incomeColumn.setCellValueFactory(new PropertyValueFactory<Registry, Double>("income"));
        loadList();
        loadTable();
    }
    
}
