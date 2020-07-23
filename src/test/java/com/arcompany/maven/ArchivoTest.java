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
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
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
        
        //SE CREA LA ORDEN
        Order ord1 = new Order(productList,quantityList);
        
        //SE CREA EL DAO
        DaoImplOrder daoImplOrder = new DaoImplOrder("ArchivoDePrueba.txt");  
        
        //SE GUARDA LA ORDEN EN EL ARCHIVO      
        daoImplOrder.create(ord1);
        
        
        List<Order> expectedOrdersList = new ArrayList<Order>();
        expectedOrdersList.add(ord1);
        
        try{
            List<Order> ordersList = new ArrayList<Order>();
            FileInputStream fileIn = new FileInputStream("ArchivoDePrueba.txt");
            
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
        
        DaoImplOrder dao = new DaoImplOrder("ArchivoDePrueba.txt");
        
        List<Order> ordersList = new ArrayList<Order>();
        
        ordersList = dao.findAll();
        
        //SE CREA EL PRODUCTO
        Product pr1 = new Product("Producto1",25.0); 
        //SE CREA LA LISTA DE PRODUCTO Y LA LISTA DE CANTIDADES
        List<Product> productList = new ArrayList<Product>();
        List<Integer> quantityList = new ArrayList<Integer>();
        //SE AGREGA EL PRODUCTO A LA LISTA
        productList.add(pr1);
        quantityList.add(3);
        
        //SE CREA LA ORDEN
        Order ord1 = new Order(productList,quantityList);
        
        List<Order> expectedOrdersList = new ArrayList<Order>();
        expectedOrdersList.add(ord1);
        
        assertEquals(expectedOrdersList.get(0).getProductList().get(0).getName(), ordersList.get(0).getProductList().get(0).getName());
    }
}
