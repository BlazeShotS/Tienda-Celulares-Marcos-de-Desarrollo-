/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.service;

import com.proyecto.demo.model.Reclamos;
import com.proyecto.demo.repository.ReclamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReclamosService {
    
    @Autowired
    private ReclamosRepository reclamosRepository;
    
    
    public Reclamos guardar (Reclamos reclamo){
        return reclamosRepository.save(reclamo); //guarda los registros en la base de datos
    }
    
    
}
