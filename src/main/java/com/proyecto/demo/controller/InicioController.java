/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Inicio")
public class InicioController {
    
    /*---PANTALLA DE INICIO---*/
    @GetMapping("/inicio") 
    public String mostrarLogin() {
        return "Inicio"; 
    }
    
    
    /*--PARA EL ADMINISTRADOR---*/
    @GetMapping("/index")
    public String mostrarIndex() {
        return "index"; 
    }
    
    
}
