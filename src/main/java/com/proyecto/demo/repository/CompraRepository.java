/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.demo.repository;

import com.proyecto.demo.model.Cliente;
import com.proyecto.demo.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mikel
 */
public interface CompraRepository extends JpaRepository <Compra, Long> {
    
    // Método para obtener la compra activa de un cliente (sin fecha de compra)
    Compra findByClienteAndFechaCompraIsNull(Cliente cliente);
    
    // Método para obtener la última compra de un cliente POR FECHA
    Compra findTopByClienteOrderByFechaCompraDesc(Cliente cliente);
    
}
