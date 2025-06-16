/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.demo.repository;

import com.proyecto.demo.model.Producto;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mikel
 */                                          //entidad que manejara el repositorio en este caso Producto
public interface ProductoRepository extends JpaRepository <Producto,Long>{
    
    List<Producto> findByMarcaContainingIgnoreCase(String marca); /*El findBy busca un campo en especifico de la database*/
    
    List<Producto> findByFechaIngreso(LocalDate fechaIngreso); /*Esa fechaIngreso tiene que ser tal cual el atributo de mi entidad*/
    
}
