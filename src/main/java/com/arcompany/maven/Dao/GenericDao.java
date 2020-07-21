/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arcompany.maven.Dao;

import java.util.List;

/**
 *
 * @author Adriel Rosario
 */
public interface GenericDao <T,ID>{
    
    public void create(T entity);
    public void modify(T entity);
    public void delete(T entity);
    public T findById(ID id);
    public List<T> findAll();
    
}
