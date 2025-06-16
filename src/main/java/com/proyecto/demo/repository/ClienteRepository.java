/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.demo.repository;

import com.proyecto.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mikel
 */
public interface ClienteRepository  extends JpaRepository <Cliente,Long> {

    Cliente findByIdCliente(Long idCliente);// Aquí estamos buscando por el id del cliente

}
