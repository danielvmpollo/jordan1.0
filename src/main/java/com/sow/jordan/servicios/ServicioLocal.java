/*
 * Paquete que contiene ...
 */
package com.sow.jordan.servicios;

import com.sow.jordan.modelos.Local;
import com.sow.jordan.modelos.Lugar;
import com.sow.jordan.modelos.Servicio;
import java.util.List;

/**
 * 
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public interface ServicioLocal {
    /**
     * Método para guardar la información de los locales 
     * @param local El local a guardar
     */
    public void guardarLocal(Local local);
    
    public void eliminarLocal(Local local);
    /**
     * Método para guardar la información de los lugares 
     * @param lugar El lugar a guardar
     */
    public void guardarLugar(Lugar lugar);
    
    /**
     * Método para guardar la información de los servicios
     * @param servicio El servicio a guardar
     */
    public void guardarSercivio(Servicio servicio);
    
    /**
     * Método que carga la información de los locales
     * @return Una lista con la información
     */
    List<Local> cargarLocales();
    
    
    List<Lugar> cargarLugares();
    /**
     * Método que carga la información de los servicios
     * @return Una lista con la información
     */
    List<Servicio> cargarServicios();   
}
