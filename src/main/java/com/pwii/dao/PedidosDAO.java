/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.dao;

import com.pwii.entidades.Cardapio;
import com.pwii.entidades.Pedidos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leand
 */
public class PedidosDAO extends GenericDAO {
    private EntityManager em;

    public List<Pedidos> getPedidosList() {
        em = daoHelper.getEM();
        List<Pedidos> pedidoList;

        Query query = em.createNamedQuery("Pedidos.findAll", Pedidos.class);
        pedidoList = query.getResultList();

        return pedidoList;
    }

    public List<Pedidos> getPedidosByCEPList(String cep) {
        em = daoHelper.getEM();
        List<Pedidos> pedidosByCEPList;

        Query query = em.createNamedQuery("Pedidos.findByPedidoEnderecoCep", Pedidos.class);
        query.setParameter("pedidoEnderecoCep", cep);
        pedidosByCEPList = query.getResultList();

        return pedidosByCEPList;
    }
    
    public List<Pedidos> getPedidosByBairroList(String bairro) {
        em = daoHelper.getEM();
        List<Pedidos> pedidosByBairroList;

        Query query = em.createNamedQuery("Pedidos.findByPedidoEnderecoBairro", Pedidos.class);
        query.setParameter("pedidoEnderecoBairro", bairro);
        pedidosByBairroList = query.getResultList();

        return pedidosByBairroList;
    }

    public void atualizar(Pedidos pedido) {
        em = daoHelper.getEM();
        
        try {
            Query query = em.createQuery("UPDATE Pedidos p "
                    + "SET p.idItem = :idItem, p.pedidoData = :pedidoData, p.pedidoEnderecoCep = :pedidoEnderecoCep, p.pedidoEnderecoNumero = :pedidoEnderecoNumero, p.pedidoEnderecoBairro = :pedidoEnderecoBairro "
                    + "WHERE p.id = :id");
            query.setParameter("idItem", pedido.getIdItem());
            query.setParameter("pedidoData", pedido.getPedidoData());
            query.setParameter("pedidoEnderecoCep", pedido.getPedidoEnderecoCep());
            query.setParameter("pedidoEnderecoNumero", pedido.getPedidoEnderecoNumero());
            query.setParameter("pedidoEnderecoBairro", pedido.getPedidoEnderecoBairro());
            query.setParameter("id", pedido.getId());

            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
