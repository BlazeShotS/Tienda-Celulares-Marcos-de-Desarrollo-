/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.demo.repository;

import com.proyecto.demo.model.CompraDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mikel
 */
public interface CompraDetalleRepository extends JpaRepository <CompraDetalle,Long> {

    List<CompraDetalle> findByCompra_IdCompra(Long idCompra);//captura el fk id_compra

    
}
