/*
 * Paquete que contienje los repositorios del sistema Jordan
 */
package com.sow.jordan.repositorios;

import com.sow.jordan.modelos.Lugar;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface RepositorioLugar extends CrudRepository<Lugar, Integer> {
    
    @Query("SELECT lugar FROM Lugar lugar")
    List<Lugar> cargarLugares();
    
    @Query("SELECT lugar FROM Lugar lugar WHERE lugar.id = ?")
    List<Lugar> buscarLugar(Integer id);
    
}
