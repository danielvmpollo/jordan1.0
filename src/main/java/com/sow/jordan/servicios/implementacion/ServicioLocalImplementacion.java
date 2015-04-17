/*
 * Paquete en el que se implementan los Servicios
 */
package com.sow.jordan.servicios.implementacion;

import com.sow.jordan.modelos.Local;
import com.sow.jordan.modelos.Lugar;
import com.sow.jordan.modelos.Menu;
import com.sow.jordan.modelos.Servicio;
import com.sow.jordan.repositorios.RepositorioLocal;
import com.sow.jordan.repositorios.RepositorioLugar;
import com.sow.jordan.repositorios.RepositorioServicio;
import com.sow.jordan.servicios.ServicioLocal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
public class ServicioLocalImplementacion implements ServicioLocal{

    @Autowired
    private RepositorioLocal repositorioLocal; 
    
    @Autowired
    private RepositorioLugar repositorioLugar;
    
    /**
     * Variable que almacena el repositorio servicio.
     */
    @Autowired
    private RepositorioServicio repositorioServicio;

    /**
     * Método para guardar la información de los locales 
     * @param local El local a guardar
     */
    @Override
    public void guardarLocal(Local local) {
        for(Menu menu:local.getMenu()){
            menu.setLocal(local);
        }
        repositorioLocal.save(local);
    }

    @Override
    public void eliminarLocal(Local local) {
        repositorioLocal.delete(local);
    }
    
    @Override
    public void guardarLugar(Lugar lugar) {
        repositorioLugar.save(lugar);
    }

    @Override
    public void guardarSercivio(Servicio servicio) {
        repositorioServicio.save(servicio);
    }
    
    @Override
    public List<Lugar> cargarLugares() {
        return repositorioLugar.cargarLugares();
    }
    
    @Override
    public List<Local> cargarLocales() {
        return repositorioLocal.cargarLocales();
    }
    
    /**
     * Método que carga la información de los locales
     * @return Una lista con la información
     */
    @Override
    public List<Servicio> cargarServicios() {
        return repositorioServicio.cargarServicios();
    }

    @Override
    public List<Lugar> buscarLugar(int id) {
        return repositorioLugar.buscarLugar(id);
    }
    
}
