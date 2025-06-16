/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.demo.repository;

import com.proyecto.demo.model.Administrador;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mikel
 */
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

    Optional<Administrador> findById(Long id_administrador); //se encarga de buscar un administrador en la base de datos utilizando su ID, o un Optional.empty() si no se encuentra.
                                // parámetro llamado id_administrador

    Administrador findByCorreo(String correo);

}

//INTERACTUO CON LA BASE DE DATOS
