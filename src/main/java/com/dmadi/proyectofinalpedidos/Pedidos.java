/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dmadi.proyectofinalpedidos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Damian
 */
@Entity
@Table(name = "pedidos")
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedidos")
    private Integer idPedidos;
    @Column(name = "producto")
    private String producto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "precio")
    private Float precio;
    @JoinColumn(name = "id_vendedor", referencedColumnName = "id_vendedor")
    @ManyToOne
    private Vendedor idVendedor;

    public Pedidos() {
    }

    public Pedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Integer getIdPedidos() {
        return idPedidos;
    }

    public Pedidos(Integer idPedidos, String producto, Float cantidad, Float precio, Vendedor idVendedor) {
        this.idPedidos = idPedidos;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idVendedor = idVendedor;
    }

    public void setIdPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }
 public Pedidos(String producto, Float candidad, Float precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedidos != null ? idPedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedidos == null && other.idPedidos != null) || (this.idPedidos != null && !this.idPedidos.equals(other.idPedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dmadi.proyectofinalpedidos.Pedidos[ idPedidos=" + idPedidos + " ]";
    }
    
}
