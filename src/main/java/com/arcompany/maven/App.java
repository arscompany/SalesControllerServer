package com.arcompany.maven;

import com.arcompany.maven.DaoImpl.DaoImplOrder;
import com.arcompany.maven.entities.Order;
import com.arcompany.maven.entities.Product;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         //SE CREA EL PRODUCTO
        Product pr1 = new Product("Producto1",25.0); 
        //SE CREA LA LISTA DE PRODUCTO Y LA LISTA DE CANTIDADES
        List<Product> productList = new ArrayList<Product>();
        List<Integer> quantityList = new ArrayList<Integer>();
        //SE AGREGA EL PRODUCTO A LA LISTA
        productList.add(pr1);
        quantityList.add(3);
        
        //SE CREA EL DATE
          
        Date date = new Date();
        
        //SE CREA LA ORDEN
        Order ord1 = new Order(productList,quantityList,date);
        
        //SE CREA EL DAO
        DaoImplOrder daoImplOrder = new DaoImplOrder();
        
        String path = "ordersList.txt";       
        daoImplOrder.create(ord1, path);
    }
}
