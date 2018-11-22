/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.restmanagerapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwii.dao.CardapioDAO;
import com.pwii.dao.PedidosDAO;
import com.pwii.entidades.Cardapio;
import com.pwii.entidades.Pedidos;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author leand
 */
@Path("pedidos")
public class PedidosResource {
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public String get() {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List pedidoList = new ArrayList<Pedidos>();

        pedidoList = pedidosDAO.getPedidosList();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pedidoList);
        return json;
    }

    @GET
    @Path("cep/{cep}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public String getByCEP(@PathParam("cep") String cep) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List pedidosByCEPList = new ArrayList<Pedidos>();

        pedidosByCEPList = pedidosDAO.getPedidosByCEPList(cep);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pedidosByCEPList);

        return json;
    }
    
    @GET
    @Path("bairro/{bairro}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public String getByBairro(@PathParam("bairro") String bairro) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        List pedidosByBairroList = new ArrayList<Pedidos>();

        pedidosByBairroList = pedidosDAO.getPedidosByBairroList(bairro);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(pedidosByBairroList);

        return json;
    }

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public void addPedido(String p) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        Gson gson = new Gson();
        
        Pedidos pedido = gson.fromJson(p, Pedidos.class);
        pedidosDAO.salvar(pedido);
    }
    
    @DELETE
    @Path("delete/{id}")
    public void deleteItem(@PathParam("id") String id) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        
        int idInteger = Integer.parseInt(id);
        pedidosDAO.remover(idInteger, Pedidos.class);
    }
    
    @PUT
    @Path("atualiza")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public void updateItem(String p) {
        PedidosDAO pedidosDAO = new PedidosDAO();
        Gson gson = new Gson();
        
        Pedidos pedido = gson.fromJson(p, Pedidos.class);
        pedidosDAO.atualizar(pedido);
    }
}
