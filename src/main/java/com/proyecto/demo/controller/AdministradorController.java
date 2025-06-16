/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.controller;

import com.proyecto.demo.model.Administrador;
import com.proyecto.demo.service.AdministradorService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mikel
 */

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
  
    
    @Autowired
    private AdministradorService administradorService;
    
    @GetMapping("/login") 
    public String mostrarLogin() {
        return "login"; 
    }
    
    @GetMapping("/panel") 
    public String dashboard() {
        return "panel"; 
    }
        
    
    
    @PostMapping("/login") // Manejador de la solicitud de inicio de sesión
    public String login(HttpSession session,@RequestParam("id") Long id, @RequestParam("contrasena") String contrasena,Model model ) {
        Administrador administrador = administradorService.validarAdministrador(id, contrasena);      
        
        if (administrador != null) { // Verifica si se recibió un administrador válido
            
            // Guardar el administrador en la sesión
            session.setAttribute("id_administrador", administrador.getId_administrador());
            return "redirect:/administrador/panel"; 
        } else {
            // Si no es válido, agregar un mensaje de error
            model.addAttribute("error", "ID o contraseña incorrectos");
            return "login"; 
        }
    }
    
}
