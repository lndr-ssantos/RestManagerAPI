/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.dao;

import com.pwii.entidades.GenericEntity;
import javax.persistence.EntityManager;

/**
 *
 * @author leand
 */
public class GenericDAO<T extends GenericEntity> {

    DAOHelper daoHelper = new DAOHelper();

    public T salvar(T t) {
        EntityManager em = daoHelper.getEM();
        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Integer id, Class<T> tclass) {
        EntityManager em = daoHelper.getEM();
        T t = em.find(tclass, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
