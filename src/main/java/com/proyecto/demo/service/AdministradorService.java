
package com.proyecto.demo.service;

import com.proyecto.demo.model.Administrador;
import com.proyecto.demo.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mikel
 */
@Service
public class AdministradorService {
    
    @Autowired
    private AdministradorRepository administradorRepository;
    
   
    //METODOS QUE TENDRAN INTERACCION CON LA BASE DE DATOS
    // Método que valida y devuelve el objeto Administrador si es válido
    public Administrador validarAdministrador(Long id, String contrasena) {
        Administrador administrador = administradorRepository.findById(id).orElse(null);//captura toda esa fila de la tabla administrador y lo almaceno en el objeto Administrador
        if (administrador != null && administrador.getContrasena().equals(contrasena)) {
            return administrador; // Devuelve el objeto lleno si las credenciales son correctas
        }
        return null; // Devuelve null si no es válido
    }
    
    public Administrador obtenerPorId(Long id) {
        return administradorRepository.findById(id).orElse(null);
    }
    
    
    
    
    /*------PARA EL SPRING SECURITY (LO BUSCA POR CORREO)----*/
     public Administrador buscarCorreo(String correo){
        return administradorRepository.findByCorreo(correo);
    }
    
    
}
