/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author mikel
 */

@Entity
@Table(name = "administrador") //NOMBRE DE LA TABLA DE LA DATABASE QUE CORRESPONDE CON ESTA ENTIDAD
public class Administrador {
    
    @Id
    /*@Pattern(regexp = "\\d{8}", message = "Debe contener 8 dígitos")*/
    private Long id_administrador;
    
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipo;

    
    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    
}
