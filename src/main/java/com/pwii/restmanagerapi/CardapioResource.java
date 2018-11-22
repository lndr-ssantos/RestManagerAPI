/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.restmanagerapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pwii.dao.CardapioDAO;
import com.pwii.entidades.Cardapio;
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
@Path("cardapio")
public class CardapioResource {
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public String get() {
        CardapioDAO cardapioDAO = new CardapioDAO();
        List<Cardapio> cardapioList = new ArrayList<Cardapio>();

        cardapioList = cardapioDAO.getCardapioList();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(cardapioList);
        return json;
    }

    @GET
    @Path("tipo/{tipo}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public String getByTipo(@PathParam("tipo") String tipo) {
        CardapioDAO cardapioDAO = new CardapioDAO();
        List cardapioByTipoList = new ArrayList<Cardapio>();

        cardapioByTipoList = cardapioDAO.getCardapioByTipoList(tipo);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(cardapioByTipoList);

        return json;
    }
    
    @GET
    @Path("porcao/{porcao}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public String getByPorcao(@PathParam("porcao") String porcao) {
        CardapioDAO cardapioDAO = new CardapioDAO();
        List cardapioByPorcaoList = new ArrayList<Cardapio>();

        cardapioByPorcaoList = cardapioDAO.getCardapioByPorcaoList(porcao);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(cardapioByPorcaoList);

        return json;
    }

    @POST
    @Path("add")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public void addItem(String c) {
        CardapioDAO cardapioDAO = new CardapioDAO();
        Gson gson = new Gson();
        
        Cardapio cardapio = gson.fromJson(c, Cardapio.class);
        cardapioDAO.salvar(cardapio);
    }
    
    @DELETE
    @Path("delete/{id}")
    public void deleteItem(@PathParam("id") String id) {
        CardapioDAO cardapioDAO = new CardapioDAO();
        
        int idInteger = Integer.parseInt(id);
        cardapioDAO.remover(idInteger, Cardapio.class);
    }
    
    @PUT
    @Path("atualiza")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public void updateItem(String c) {
        CardapioDAO cardapioDAO = new CardapioDAO();
        Gson gson = new Gson();
        
        Cardapio item = gson.fromJson(c, Cardapio.class);
        cardapioDAO.atualizar(item);
    }
}
