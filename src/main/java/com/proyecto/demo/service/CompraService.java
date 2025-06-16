/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.service;

import com.proyecto.demo.model.Cliente;
import com.proyecto.demo.model.Compra;
import com.proyecto.demo.model.CompraDetalle;
import com.proyecto.demo.repository.CompraDetalleRepository;
import com.proyecto.demo.repository.CompraRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikel
 */
@Service
public class CompraService {
    
    
    @Autowired
    private CompraRepository compraRepository;
    
    @Autowired
    private CompraDetalleRepository compraDetalleRepository;
    

    
    // busca una compra asociada a un cliente cuyo campo fechaCompra esté vacío
    public Compra obtenerCompraActiva(Cliente cliente) {
        return compraRepository.findByClienteAndFechaCompraIsNull(cliente);
    }


    
    
    public void finalizarCompra(Compra compra) {
        // Primero, guardamos la compra en la base de datos para que tenga un id_compra asignado.
        compraRepository.save(compra);

        // Luego, guardamos cada detalle de la compra.
        for (CompraDetalle detalle : compra.getDetalles()) {// al hacer compra.getDetalles esta capturando todo un array donde se repite el id_compra
            
            //Al llamar a compra.getDetalles(), se obtiene una lista de todos los CompraDetalle que están actualmente en la colección detalles de esa Compra. Estos detalles están relacionados con la compra, pero aún no se han guardado en la base de datos.
            detalle.setCompra(compra);//Estoy es colocado de mi entidad CompraDetalle

            /*Cuando se guarda cada CompraDetalle en la base de datos, además de almacenar 
            el id_compra como clave foránea, también se guardan sus otros atributos
            (como cantidad, precioUnitario, y subtotal automaticamente , porque su atributo coinciden) tal y como estaban en 
            el objeto detalle*/
            
                        
            compraDetalleRepository.save(detalle);
        }
    }

    
    public Compra obtenerUltimaCompra(Cliente cliente) {
        // Aquí usas tu repositorio para encontrar la compra más reciente del cliente
        return compraRepository.findTopByClienteOrderByFechaCompraDesc(cliente);
    }
    
    
    
    
    // Método para buscar una compra por su ID
    public Compra buscarCompraPorId(Long idCompra) {
        return compraRepository.findById(idCompra).orElse(null); // Retorna la compra o null si no se encuentra
    }
    //EL BUSCAR POR ID , finfById Ya esta cubierto por el JPA es por eso que no es necesario poner en el compraRepository 
    
    
    
    
}
