/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 *
 * @author mikel
 */
@Entity
public class Cliente {

    @Id
    @NotNull
    @Column(name = "id_cliente") 
    private Long idCliente;
    
    @NotBlank(message = "Ingrese un password")
    @NotNull
    private String password;
    
    @NotBlank(message = "Ingrese un nombre")
    @Pattern(regexp = "\\D*",message="No puede contener numeros")
    private String nombre;
    
    @NotBlank(message = "Ingrese un apellido")
    @Pattern(regexp = "\\D*",message="No puede contener numeros")
    private String apellido;
    
    
    @NotBlank(message = "Ingrese un telefono")
    @Pattern(regexp="\\d{9}", message="Su numero debe contener 9 digitos")
    private String telefono;
    
    @Email(message = "Ingrese un correo valido")
    @NotBlank(message = "Ingrese un correo")
    private String email;

    
    
    
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
   
    
  
   
    
}
