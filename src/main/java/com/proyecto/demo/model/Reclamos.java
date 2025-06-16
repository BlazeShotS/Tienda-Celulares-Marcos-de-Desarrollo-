
package com.proyecto.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Reclamos {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reclamos;
    
    
    @NotBlank(message = "Ingrese un tipo de problema")
    @NotNull
    private String tipoProblema;
     
    @PositiveOrZero(message = "El numero no puede ser negativo")
    @NotNull
    private int numero;
    
    
    @NotBlank(message = "Ingrese su detalle para seguir mejorando")
    @NotNull
    private String detalle;

    
    public Long getId_reclamos() {
        return id_reclamos;
    }

    public void setId_reclamos(Long id_reclamos) {
        this.id_reclamos = id_reclamos;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    
    
}
