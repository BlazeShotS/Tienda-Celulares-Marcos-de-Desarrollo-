/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.controller;

import com.proyecto.demo.model.Reclamos;
import com.proyecto.demo.service.ReclamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.validation.Valid; // para @Valid
import org.springframework.web.bind.annotation.ModelAttribute; // para @ModelAttribute

/**
 *
 * @author mikel
 */

@Controller
@RequestMapping("/servicios")
public class ReclamosController {
    
    @Autowired
    private ReclamosService reclamosService;
    
    
    @GetMapping("/servicio") 
    public String mostrarServicio() {
        return "Servicio"; 
    }
    
    @GetMapping("/reclamosClientes") 
    public String mostrarReclamos() {
        return "Reclamos"; 
    }
    
    
    
    /*Para crear una nueva reclamo*/  /*LLENA EL NAVEGADOR, MUESTRA EN EL NAVEGADOR*/
    @GetMapping("/nuevo") //RECUPERAR DATOS DEL SERVIDOR 
    public String mostrarFormularioNuevaReclamo (Model model){
        model.addAttribute("reclamos",new Reclamos());//creamos una variable producto que es donde se almacenara cada persona que registremos
        return "Reclamos";
    }
    
    
    
    @PostMapping("guardar") //envia datos al servidor   (recibe datos de un formulario)
    public String guardarReclamos(@Valid @ModelAttribute Reclamos reclamos //GUARDANDO EN MI OBJETO Producto Como un set seria, colocando en mi objeto producto
                                  ,BindingResult result, Model model
                                  ){//Creo un parametro producto este producto esta lleno porque antes con mi variable producto que esta arriba de verde ya lo llene, lo que hace este parametro es llevarlo a la db
        
        if (result.hasErrors()) { /*PARA LA VALIDACION*/
            return "Reclamos";
        }                                
                
        reclamosService.guardar(reclamos); //Guarda el objeto Producto en la base de datos 
        model.addAttribute("mensajeExito", "Reclamo enviado correctamente.");//se muestra el mensaje porque hace un return si era redirect , perdia los datos y no se mostraba el mensaje por eso en abajo puse return

        return "/Reclamos"; // sin poner redirect no pierde la solicitud , es por eso que sigue la variable reclamos de @GetMapping("/nuevo")
    }
    
    
    
    
    
    
    
}
