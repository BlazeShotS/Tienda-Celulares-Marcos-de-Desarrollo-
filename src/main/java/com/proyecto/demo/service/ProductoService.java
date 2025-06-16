/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.service;

import com.proyecto.demo.model.Producto;
import com.proyecto.demo.repository.ProductoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikel
 */
@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    
    //DEFINO LOS METODOS PARA EL CRUD
    public List<Producto>listarTodas(){
        return productoRepository.findAll();//recupera todo los registros de la base de datos es como un get
    }
    
    
    public Producto guardar (Producto producto){
        return productoRepository.save(producto); //guarda los registros en la base de datos
    }
    
    public Producto obtenerPorId (Long id_producto){
        return productoRepository.findById(id_producto).orElse(null);
    }
    
    public void eliminar (Long id_producto){
        productoRepository.deleteById(id_producto);
    }
    
    /*-----------------------------------*/
    
    /*Para Buscar por marca*/    
    public List<Producto> buscarPorMarca(String marca) {
        return productoRepository.findByMarcaContainingIgnoreCase(marca);
    }
   
    /*Para buscar por fecha*/
    public List<Producto> buscarPorFechaIngreso(LocalDate fechaIngreso) {
        return productoRepository.findByFechaIngreso(fechaIngreso);
    }
    
    

    // Método para actualizar un producto
    public void actualizarProducto(Producto producto) {
        productoRepository.save(producto);  // Guarda los cambios del producto en la base de datos
    }
    
}
