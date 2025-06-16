/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.controller;

import com.proyecto.demo.model.Cliente;
import com.proyecto.demo.service.ClienteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mikel
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    
    @GetMapping("/loginCliente") 
    public String mostrarLogin() {
        return "LoginCliente"; 
    }
    
    
    @GetMapping  // aca le digo que /clientes es clientes-list
    public String listarClientes(Model model){ //Carga todas las personas desde el servicio y las agrega al modelo para ser mostradas en la vista persona-list
        model.addAttribute("clientes",clienteService.listarTodo()); //el productoService se encarga del manejo y logica con la base de datos
        return "clientes-list";
    }
        
    
    /*----PARA CREAR UNA CUENTA------*/
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaCliente (Model model){
        model.addAttribute("cliente",new Cliente());//creamos una variable producto que es donde se almacenara cada persona que registremos
        return "RegistroCliente";
    }
    
    
    /*----PARA GUARDAR (CREAR UNA CUENTA)-----*/
    @PostMapping("guardar") //envia datos al servidor   (recibe datos de un formulario)
    public String guardarCliente(@Valid @ModelAttribute   Cliente cliente //GUARDANDO EN MI OBJETO cliente Como un set seria, colocando en mi objeto Cliente
                                  ,BindingResult result){//Creo un parametro producto este producto esta lleno porque antes con mi variable producto que esta arriba de verde ya lo llene, lo que hace este parametro es llevarlo a la db
        
        if (result.hasErrors()) { /*PARA LA VALIDACION*/
            return "RegistroCliente";
        }
        
        clienteService.guardar(cliente); //Guarda el objeto Cliente en la base de datos 
        return "redirect:/cliente/loginCliente";
    }
    
    
    
    /*----CUANDO INICIA SESION , VER SI LAS CREDENCIALES SON CORRECTAS-----*/
    @PostMapping("login")
    public String iniciarSesion(@RequestParam("id") String id, @RequestParam("contrasena") String contrasena, HttpSession session, Model model) {
        // Verificar si el cliente existe con el id (DNI) y la contraseña
        Cliente cliente = clienteService.obtenerPorId(id);  // Ahora usamos el id como parámetro
        
        if (cliente != null && cliente.getPassword().equals(contrasena)) {
            // Guardar el id_cliente en la sesión si la autenticación es exitosa
            session.setAttribute("id_cliente", cliente.getIdCliente());  // Guardamos el id_cliente en la sesión
            // Redirigir al carrito o la página principal
            session.setAttribute("nombre_cliente", cliente.getNombre());
            return "redirect:/CompraDetalle/catalogo";
        } else {
            // Si las credenciales son incorrectas, mostrar mensaje de error
            model.addAttribute("error", "ID o contraseña incorrectos.");
            return "LoginCliente";  // Redirigir al formulario de login cliente nuevamente
        }
    }


    
    /*----PARA ELIMINAR*/
     @GetMapping("/eliminar/{id_cliente}")
    public String eliminarPersona(@PathVariable Long id_cliente){
        clienteService.eliminar(id_cliente);
        return "redirect:/cliente";
    }
    
    
    
    @PostMapping("/cerrarSesion")
    public String cerrarSesion(HttpSession session) {
        // Eliminar el id_cliente de la sesión
        session.invalidate();
        return "redirect:/cliente/loginCliente";  //Redirigir, al hace esto pierde los datos y no hay nadie logeado ahora
    }

    

}
