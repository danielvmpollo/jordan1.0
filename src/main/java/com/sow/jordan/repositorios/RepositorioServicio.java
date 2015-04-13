/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Servicio;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HectorJavier
 */
public interface RepositorioServicio extends CrudRepository<Servicio, Integer> {
    
    /**
     * Método que carga la información de la tabla Servicio
     * @return La información de la consulta
     */
    @Query("SELECT servicio FROM Servicio servicio")
    List<Servicio> cargarServicios();
}
