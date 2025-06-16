/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author mikel
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        
        registry.addViewController("/").setViewName("Inicio");
        registry.addViewController("/Inicio/inicio").setViewName("Inicio");
        /*registry.addViewController("/Inicio/index").setViewName("index"); //ADMINISTRADOR        
        registry.addViewController("/cliente/nuevo").setViewName("RegistroCliente");
        registry.addViewController("/cliente/loginCliente").setViewName("LoginCliente");
        registry.addViewController("/cliente/cerrarSesion").setViewName("CerrarSesionCliente");
                
        registry.addViewController("/CompraDetalle/catalogo").setViewName("catalogo");        
        registry.addViewController("/compras/mostrarCarrito").setViewName("mostrarCarrito");*/     
    }


    
}
