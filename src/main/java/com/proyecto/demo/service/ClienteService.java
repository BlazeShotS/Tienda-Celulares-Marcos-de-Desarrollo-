/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.service;

import com.proyecto.demo.model.Cliente;
import com.proyecto.demo.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikel
 */
@Service
public class ClienteService {
    
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    public List<Cliente>listarTodo(){
        return clienteRepository.findAll();
    }
    
    public Cliente guardar (Cliente cliente){
        return clienteRepository.save(cliente); //guarda los registros en la base de datos
    }
    
    public Cliente obtenerPorId (Long id_cliente){
        return clienteRepository.findById(id_cliente).orElse(null);
    }
   

     public void eliminar (Long id_cliente){
        clienteRepository.deleteById(id_cliente);
    }
    
     
     
     
    /*-----PÁRA EL INICIO DE SESION , CONFIRMAR SI LAS CREDENCIALES SON CORRECTAS------*/
    public Cliente obtenerPorId(String id) {
        Long idCliente = Long.parseLong(id);  // Convertir String a Long
        return clienteRepository.findByIdCliente(idCliente);
    }

    
}
