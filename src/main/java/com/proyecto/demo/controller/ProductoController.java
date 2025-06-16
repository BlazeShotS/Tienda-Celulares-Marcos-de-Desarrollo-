/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo.controller;

import com.proyecto.demo.model.Administrador;
import com.proyecto.demo.model.Producto;
import com.proyecto.demo.service.AdministradorService;
import com.proyecto.demo.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mikel
 */
@Controller
@RequestMapping("/administrador/productos")
public class ProductoController {
    
    @GetMapping("/mostrarCarrito") 
    public String mostrarLogin() {
        return "mostrarCarrito"; 
    }
    
    private static String UPLOAD_DIR = "src/main/resources/static/img/"; // Directorio para guardar imágenes

    
    @Autowired
    private ProductoService productoService;        

    @Autowired
    private AdministradorService administradorService;
    

    @GetMapping  // aca le digo que /productos es productos-list
    public String listarProducto(Model model){ //Carga todo los producotos desde el servicio y las agrega al modelo para ser mostradas en la vista persona-list
        model.addAttribute("productos",productoService.listarTodas()); //el productoService se encarga del manejo y logica con la base de datos
        return "producto-list";
    }   
    
    
    /*Para crear una nueva producto*/  /*LLENA EL NAVEGADOR, MUESTRA EN EL NAVEGADOR*/
    @GetMapping("/nuevo") //RECUPERAR DATOS DEL SERVIDOR 
    public String mostrarFormularioNuevaProducto (Model model){
        model.addAttribute("producto",new Producto());//creamos una variable producto que es donde se almacenara cada persona que registremos
        return "producto-form";
    }
            
    
    
    
    /*AL LLENAR LOS DATOS DE MI FORMULARIO EL POST DE MI FORMULARIO  ES ENVIADO A ESTE METODO Y RECIEN ESTE METODO ES EL QUE SE ENCARGA DE ENVIARLO A LA BASE DE DATOSS*/     
    @PostMapping("guardar") //envia datos al servidor   (recibe datos de un formulario)
    public String guardarProducto(@Valid @ModelAttribute Producto producto //GUARDANDO EN MI OBJETO Producto Como un set seria, colocando en mi objeto producto
                                  ,BindingResult result
                                  ,@RequestParam("foto") MultipartFile foto
                                  ,HttpSession session){//Creo un parametro producto este producto esta lleno porque antes con mi variable producto que esta arriba de verde ya lo llene, lo que hace este parametro es llevarlo a la db
        
        if (result.hasErrors()) { /*PARA LA VALIDACION*/
            return "producto-form";
        }
        
        
        // Obtener el ID del administrador desde la sesión (Controlador del administrador)
        Long idAdministrador = (Long) session.getAttribute("id_administrador");
        
        // Buscar el administrador usando el idAdministrador recuperado
        Administrador administrador = administradorService.obtenerPorId(idAdministrador);
           
         if (administrador == null) {
            throw new RuntimeException("Administrador no encontrado");
        }  
         
        // Asocia el administrador al producto
        producto.setAdministrador(administrador);
               
        if (!foto.isEmpty()) {
            try {
                // Creo la ruta donde se almacenará el archivo
                byte[] bytes = foto.getBytes();
                Path path = Paths.get(UPLOAD_DIR + foto.getOriginalFilename());
                Files.write(path, bytes);

                // Guardo la referencia de la imagen en el producto
                producto.setRutaImagen("/img/" + foto.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }                
                
        productoService.guardar(producto); //Guarda el objeto Producto en la base de datos 
        return "redirect:/administrador/productos";
    }
    
    

    /*Get Mapping es mas que todo para traer datos de la database*/
    @GetMapping("/editar/{id_producto}")//SE MOSTRARA EN LA URL DE MI NAVEGADOR , @PathVariable le dice a spring que tome el id de la URL
    public String mostrarFormularioEditarPersona (@PathVariable Long id_producto,Model model){
        model.addAttribute("producto", productoService.obtenerPorId(id_producto));
        return "producto-form";
    }
    
    @GetMapping("/eliminar/{id_producto}")
    public String eliminarPersona(@PathVariable Long id_producto){
        productoService.eliminar(id_producto);
        return "redirect:/administrador/productos";
    }
    
    
    /*----------BUSCAR POR MARCA----------*/
    @GetMapping("/buscar")
    public String listarProductoMarca(@RequestParam(value = "marca", required = false) String marca, Model model) {
        List<Producto> productos;
        if (marca != null && !marca.isEmpty()) {
            productos = productoService.buscarPorMarca(marca);
        } else {
            productos = productoService.listarTodas();
        }
        model.addAttribute("productos", productos);
        return "producto-list";
    }
    
    
    
    /*--------BUSCAR POR FECHA--------*/
    @GetMapping("/buscarPorFecha")
    public String buscarPorFecha(@RequestParam("fecha") String fechaStr, Model model) {
        LocalDate fechaIngreso = LocalDate.parse(fechaStr); // Convierte la cadena a LocalDate
        List<Producto> productos = productoService.buscarPorFechaIngreso(fechaIngreso);
        model.addAttribute("productos", productos);
        return "producto-list"; // Retorna la vista con los productos filtrados
    }
    
    
    
    
    
    /*-------PARA EL BACKUP------------*/
    @GetMapping("/backup")
    public String showBackupPage() {
        return "backup"; // Nombre de la vista HTML (backup.html)
    }
    
    
    @PostMapping("/backup")
    public String realizarBackup(@RequestParam("password") String inputPassword, Model model) {
        String dbName = "proyecto";
        String user = "backup";
        String password = "202420252026";
        String backupPath = "C:\\Users\\mikel\\Desktop\\proyecto_backup.sql";

        if ("1234".equals(inputPassword)) { // Contraseña predeterminada
            String comando = "C:\\xampp\\mysql\\bin\\mysqldump.exe -u" + user + " -p" + password + " " + dbName;
            String completeCommand = comando + " > \"" + backupPath + "\"";

            try {
                ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", completeCommand);
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }

                process.waitFor();

                if (process.exitValue() == 0) {
                    model.addAttribute("message", "Copia de seguridad creada exitosamente en: " + backupPath);
                } else {
                    model.addAttribute("message", "Error al crear la copia de seguridad.\nSalida:\n" + output.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("message", "Ocurrió un error: " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "Contraseña incorrecta. No se puede realizar el backup.");
        }

        return "backup"; // Regresa a la vista con el mensaje actualizado
    }

    
}
