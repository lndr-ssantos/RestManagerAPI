/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leand
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findById", query = "SELECT p FROM Pedidos p WHERE p.id = :id")
    , @NamedQuery(name = "Pedidos.findByIdItem", query = "SELECT p FROM Pedidos p WHERE p.idItem = :idItem")
    , @NamedQuery(name = "Pedidos.findByPedidoData", query = "SELECT p FROM Pedidos p WHERE p.pedidoData = :pedidoData")
    , @NamedQuery(name = "Pedidos.findByPedidoEnderecoCep", query = "SELECT p FROM Pedidos p WHERE p.pedidoEnderecoCep = :pedidoEnderecoCep")
    , @NamedQuery(name = "Pedidos.findByPedidoEnderecoNumero", query = "SELECT p FROM Pedidos p WHERE p.pedidoEnderecoNumero = :pedidoEnderecoNumero")
    , @NamedQuery(name = "Pedidos.findByPedidoEnderecoBairro", query = "SELECT p FROM Pedidos p WHERE p.pedidoEnderecoBairro = :pedidoEnderecoBairro")})
public class Pedidos implements GenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "idItem")
    private Integer idItem;
    @Column(name = "pedidoData")
    @Temporal(TemporalType.DATE)
    private Date pedidoData;
    @Size(max = 9)
    @Column(name = "pedidoEnderecoCep")
    private String pedidoEnderecoCep;
    @Column(name = "pedidoEnderecoNumero")
    private Integer pedidoEnderecoNumero;
    @Size(max = 85)
    @Column(name = "pedidoEnderecoBairro")
    private String pedidoEnderecoBairro;

    public Pedidos() {
    }

    public Pedidos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Date getPedidoData() {
        return pedidoData;
    }

    public void setPedidoData(Date pedidoData) {
        this.pedidoData = pedidoData;
    }

    public String getPedidoEnderecoCep() {
        return pedidoEnderecoCep;
    }

    public void setPedidoEnderecoCep(String pedidoEnderecoCep) {
        this.pedidoEnderecoCep = pedidoEnderecoCep;
    }

    public Integer getPedidoEnderecoNumero() {
        return pedidoEnderecoNumero;
    }

    public void setPedidoEnderecoNumero(Integer pedidoEnderecoNumero) {
        this.pedidoEnderecoNumero = pedidoEnderecoNumero;
    }

    public String getPedidoEnderecoBairro() {
        return pedidoEnderecoBairro;
    }

    public void setPedidoEnderecoBairro(String pedidoEnderecoBairro) {
        this.pedidoEnderecoBairro = pedidoEnderecoBairro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pwii.entidades.Pedidos[ id=" + id + " ]";
    }
    
}
