/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pwii.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leand
 */
@Entity
@Table(name = "cardapio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cardapio.findAll", query = "SELECT c FROM Cardapio c")
    , @NamedQuery(name = "Cardapio.findById", query = "SELECT c FROM Cardapio c WHERE c.id = :id")
    , @NamedQuery(name = "Cardapio.findByItemNome", query = "SELECT c FROM Cardapio c WHERE c.itemNome = :itemNome")
    , @NamedQuery(name = "Cardapio.findByItemValor", query = "SELECT c FROM Cardapio c WHERE c.itemValor = :itemValor")
    , @NamedQuery(name = "Cardapio.findByItemTipo", query = "SELECT c FROM Cardapio c WHERE c.itemTipo = :itemTipo")
    , @NamedQuery(name = "Cardapio.findByItemPorcao", query = "SELECT c FROM Cardapio c WHERE c.itemPorcao = :itemPorcao")})
public class Cardapio implements GenericEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "itemNome")
    private String itemNome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "itemValor")
    private BigDecimal itemValor;
    @Size(max = 45)
    @Column(name = "itemTipo")
    private String itemTipo;
    @Column(name = "itemPorcao")
    private Character itemPorcao;

    public Cardapio() {
    }

    public Cardapio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNome() {
        return itemNome;
    }

    public void setItemNome(String itemNome) {
        this.itemNome = itemNome;
    }

    public BigDecimal getItemValor() {
        return itemValor;
    }

    public void setItemValor(BigDecimal itemValor) {
        this.itemValor = itemValor;
    }

    public String getItemTipo() {
        return itemTipo;
    }

    public void setItemTipo(String itemTipo) {
        this.itemTipo = itemTipo;
    }

    public Character getItemPorcao() {
        return itemPorcao;
    }

    public void setItemPorcao(Character itemPorcao) {
        this.itemPorcao = itemPorcao;
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
        if (!(object instanceof Cardapio)) {
            return false;
        }
        Cardapio other = (Cardapio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pwii.entidades.Cardapio[ id=" + id + " ]";
    }
    
}
