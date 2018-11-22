/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leand
 */
public class DAOHelper {
    public EntityManager getEM(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestManagerAPI_PU");
        return emf.createEntityManager();
    }
}
