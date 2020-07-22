package com.arcompany.maven;

import com.arcompany.maven.DaoImpl.DaoImplOrder;
import com.arcompany.maven.DaoImpl.DaoImplProduct;
import com.arcompany.maven.entities.Order;
import com.arcompany.maven.entities.Product;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ArchivoTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCreate()
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
        
        //SE GUARDA LA ORDEN EN EL ARCHIVO
        String path = "ArchivoDePrueba.txt";       
        daoImplOrder.create(ord1, path);
        
        
        List<Order> expectedOrdersList = new ArrayList<Order>();
        expectedOrdersList.add(ord1);
        
        try{
            List<Order> ordersList = new ArrayList<Order>();
            FileInputStream fileIn = new FileInputStream(path);
            
            ObjectInputStream entrada = new ObjectInputStream(fileIn);
            ordersList = (List<Order>) entrada.readObject();
            entrada.close();
            fileIn.close();
            //SE COMPARAN LOS NOMBRES DE LOS PRIMEROS PRODUCTOS
            assertEquals(expectedOrdersList.get(0).getProductList().get(0).getName(), ordersList.get(0).getProductList().get(0).getName());
            
            
        }
        catch (Exception ex){
            ex.printStackTrace();
        } 
        
        
    }
    
    @Test
    public void testFindAll(){
        
        DaoImplOrder dao = new DaoImplOrder();
        
        List<Order> ordersList = new ArrayList<Order>();
        
        ordersList = dao.findAll("ArchivoDePrueba.txt");
        
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
        
        List<Order> expectedOrdersList = new ArrayList<Order>();
        expectedOrdersList.add(ord1);
        
        assertEquals(expectedOrdersList.get(0).getProductList().get(0).getName(), ordersList.get(0).getProductList().get(0).getName());
    }
}
