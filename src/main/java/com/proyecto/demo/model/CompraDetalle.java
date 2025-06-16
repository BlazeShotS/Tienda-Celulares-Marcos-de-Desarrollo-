/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author mikel
 */
@Entity
//@Table(name="compradetalle")
public class CompraDetalle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompraDetalle;

    @ManyToOne
    @JoinColumn(name = "id_compra")  // Relación con Compra
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto")  // Relación con Producto
    private Producto producto;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

    
    public void calcularSubtotal() {
        this.subtotal = this.precioUnitario * this.cantidad;
    }
    
    
    
    
    public Long getIdCompraDetalle() {
        return idCompraDetalle;
    }

    public void setIdCompraDetalle(Long idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
    
    
    
    
}
