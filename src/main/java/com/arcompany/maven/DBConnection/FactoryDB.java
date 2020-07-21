/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.DBConnection;

/**
 *
 * @author Adriel Rosario
 */
public class FactoryDB {
    
    public static GenericDB getDataBase(TypeDB database){
        
        switch(database){
            case MYSQL:
                return new MySqlDB();
                
            default:
                return null;
        }
        
    }
    
}
