/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mikel
 */
@Entity
//@Table(name="compra")
public class Compra {
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @ManyToOne
    @JoinColumn(name = "id_cliente")  // Relación con la entidad Cliente
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    
    private Double total;

    //mappedBy evita la creación de una columna adicional en la tabla Compra, ya que la relación es gestionada desde el lado de CompraDetalle
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true) //cascade es si elimino o guardo una Compra se hace lo mismo con su CompraDetalle
    private List<CompraDetalle> detalles = new ArrayList<>();//Inicializacion directa de detalles (inicialmente vacio)
        
    //detalle , contiene la infomacion de un producto en especifico
    //en una lista "detalles" guarda todo los productos (EN ESTE ARRAY DETALLES SE ALMACENA CADA PRODUCTO QUE VA AGREGANDO)
    public void agregarDetalle(CompraDetalle detalle) {
        
        this.detalles.add(detalle);
    }
    
    
    public Double calcularTotal() { //Suma los subtotales de CompraDetalle
        return detalles.stream()
            .mapToDouble(CompraDetalle::getSubtotal)
            .sum();
    }
    
    
    
    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<CompraDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<CompraDetalle> detalles) {
        this.detalles = detalles;
    }    
    
    
}
