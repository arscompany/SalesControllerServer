/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.DBConnection;

import java.sql.Connection;

/**
 *
 * @author Adriel Rosario
 */
public abstract class GenericDB {
    
    public abstract void connect();
    public abstract void close();
    public abstract Connection getConnection();
    
}
