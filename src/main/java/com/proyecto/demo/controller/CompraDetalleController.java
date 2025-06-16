/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.controller;

import com.proyecto.demo.model.Producto;
import com.proyecto.demo.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mikel
 */

@Controller
@RequestMapping("/CompraDetalle")
public class CompraDetalleController {
    
    
    @Autowired
    private ProductoService productoService;
    
  
    
    @GetMapping ("/catalogo") // aca le digo que /productos es productos-list
    public String listarProductoCatalogo(Model model){ //Carga todas las personas desde el servicio y las agrega al modelo para ser mostradas en la vista persona-list
        model.addAttribute("productos",productoService.listarTodas()); //el productoService se encarga del manejo y logica con la base de datos
        return "catalogo";
    }
    

    
    /*-------PARA FILTRAR EL BUSCADO POR MARCA EN CATALOGO----*/
     @GetMapping("/buscarCatalogo")
    public String listarProductoMarcaCatalogo(@RequestParam(value = "marca", required = false) String marca, Model model) {
        List<Producto> productos;
        if (marca != null && !marca.isEmpty()) {
            productos = productoService.buscarPorMarca(marca);
        } else {
            productos = productoService.listarTodas();
        }
        model.addAttribute("productos", productos);
        return "catalogo";
    }
    
    
    
    
}
