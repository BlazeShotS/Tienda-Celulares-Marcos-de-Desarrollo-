/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.service;

import com.proyecto.demo.model.CompraDetalle;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.repository.CompraDetalleRepository;
import com.proyecto.demo.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikel
 */
@Service
public class CompraDetalleService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    
    @Autowired
    private CompraDetalleRepository compraDetalleRepository;
    
    

    public void guardar(CompraDetalle detalle) {
        compraDetalleRepository.save(detalle);
    }    
    

    
    //LISTAR TODO LOS PRODUCTOS EN MI CATALOGO , HAGO ESTO PORQUE EL OTRO LISTAR ES DEL ADMINISTRADOR , ESTE ES PARA EL CLIENTE
    public List<Producto>listarTodas(){
        return productoRepository.findAll();//recupera todo los registros de la base de datos es como un get
    }
    
    
    
    
    /*-------------PARA BUSCAR POR ID_COMPRA para ver los productos de cierto cliente (EL ADMINISTRADOR)*/
    public List<CompraDetalle> buscarPorIdCompra(Long idCompra) {
        return compraDetalleRepository.findByCompra_IdCompra(idCompra);
    }

    
}
