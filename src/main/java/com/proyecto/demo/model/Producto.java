/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

/**
 *
 * @author mikel
 */

@Entity
//@Table(name="producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    
    @NotBlank(message = "Ingrese un nombre")
    @NotNull
    private String nombre;
    
    @NotBlank(message = "Ingrese la descripcion")
    @NotNull
    private String descripcion;
    
    @NotBlank(message = "Ingrese una marca")
    @NotNull
    private String marca;
    
    @PositiveOrZero(message = "El precio no puede ser negativo")
    @NotNull
    private Double precio;
    
    @PositiveOrZero(message = "La cantidad no puede ser negativo")
    @NotNull
    private int stock;
    
    
    @Column (name="fecha_ingreso")
    @PastOrPresent(message= "La fecha no puede ser futura")
    @NotNull
    LocalDate fechaIngreso;
    
    
    @Column(name = "ruta_Imagen")
    private String rutaImagen;

    
    @ManyToOne // Indica que este producto está relacionado con un administrador
               //Columna de la tabla producto         , Columna de la tabla administrador
    @JoinColumn(name = "id_administrador", referencedColumnName = "id_administrador")
    private Administrador administrador; // Relación con la entidad Administrador

    
    
   public void descontarStock(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("No hay suficiente stock disponible");
        }
    }

   
   
    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
   
    
    
}
