/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.dao;

import com.pwii.entidades.Cardapio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class CardapioDAO extends GenericDAO {
    private EntityManager em;

    public List<Cardapio> getCardapioList() {
        em = daoHelper.getEM();
        List<Cardapio> cardapioList;

        Query query = em.createNamedQuery("Cardapio.findAll", Cardapio.class);
        cardapioList = query.getResultList();

        return cardapioList;
    }

    public List<Cardapio> getCardapioByTipoList(String tipo) {
        em = daoHelper.getEM();
        List<Cardapio> cardapioByTipoList;

        Query query = em.createNamedQuery("Cardapio.findByItemTipo", Cardapio.class);
        query.setParameter("itemTipo", tipo);
        cardapioByTipoList = query.getResultList();

        return cardapioByTipoList;
    }
    
    public List<Cardapio> getCardapioByPorcaoList(String porcao) {
        em = daoHelper.getEM();
        List<Cardapio> cardapioByTipoList;
        char porcaoChar = porcao.charAt(0);

        Query query = em.createNamedQuery("Cardapio.findByItemPorcao", Cardapio.class);
        query.setParameter("itemPorcao", porcaoChar);
        cardapioByTipoList = query.getResultList();

        return cardapioByTipoList;
    }

    public void atualizar(Cardapio item) {
        em = daoHelper.getEM();
        try {
            Query query = em.createQuery("UPDATE Cardapio c SET c.itemNome = :itemNome, c.itemValor = :itemValor, c.itemTipo = :itemTipo, c.itemPorcao = :itemPorcao WHERE c.id = :id");
            query.setParameter("itemNome", item.getItemNome());
            query.setParameter("itemValor", item.getItemValor());
            query.setParameter("itemTipo", item.getItemTipo());
            query.setParameter("itemPorcao", item.getItemPorcao());
            query.setParameter("id", item.getId());

            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
        }
    }
}
