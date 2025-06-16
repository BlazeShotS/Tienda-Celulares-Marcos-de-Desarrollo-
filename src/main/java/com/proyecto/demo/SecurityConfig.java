/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 *
 * @author mikel
 */
/*
@Configuration
@EnableWebSecurity //FALTA AGREGAR DEPENDENCIA
public class SecurityConfig {
    
    
    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(
                auth -> auth //PAGINAS QUE PUEO ACCEDER DE FORMA LIBRE , SIN UN REGISTRO
                        .requestMatchers("/", "/Inicio/inicio", "/cliente/nuevo", "/Inicio/index",
                                "/servicios/servicio","/servicios/nuevo",
                                "/cliente/nuevo","/cliente/loginCliente",
                                "/cliente/cerrarSesion","/CompraDetalle/catalogo","/compras/mostrarCarrito",
                                
                                "/compras/comprar", "/compras/añadirAlCarrito",
                                "/cliente/login", "/compras/comprar",
                                "/img/", "/css/", "/cliente/guardar", "/CompraDetalle/*", "/cliente/cerrarSesion",
                                "/imgEstilosIcon")
                        .permitAll()
                        .requestMatchers("/administrador/login")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()).exceptionHandling(
                            ex -> ex.accessDeniedPage("/Inicio/inicio")
                        );
        http.formLogin(
               login -> login.loginPage("/administrador/login")
                .defaultSuccessUrl("/Inicio/inicio").permitAll());
        http.logout(
            logout -> logout.logoutSuccessUrl("/Inicio/inicio").permitAll()
        );


        return http.build();
        
    }
    
    
    
}
*/