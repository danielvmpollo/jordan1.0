/*
 * Paquete que contiene los controladores del sistema Jordan
 */
package com.sow.jordan.controladores;

import com.sow.jordan.modelos.Local;
import com.sow.jordan.modelos.Lugar;
import com.sow.jordan.modelos.Menu;
import com.sow.jordan.modelos.Servicio;
import com.sow.jordan.modelos.Transporte;
import com.sow.jordan.servicios.ServicioLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Clase que ...
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Controller("controladorLocal") //Indica que la clase es un controlador
@Scope("session")
public class ControladorLocal implements Serializable {

    @Autowired
    private ServicioLocal servicioLocal;
    private List<Local> locales;
    private Local local;
    private List<Lugar> lugares;
    private Lugar lugar;
    private List<Servicio> servicios;
    private Servicio servicio;
    private Menu menu;
    private Transporte transporte;

    @PostConstruct //Indica que se ejecutara despues de la inyeccion de dependencias
    public void inicio() {
        lugares = servicioLocal.cargarLugares();
        locales = servicioLocal.cargarLocales();
        servicios = servicioLocal.cargarServicios();
        this.menu=new Menu();
        this.local.setMenu(new ArrayList<Menu>());
        this.transporte = new Transporte();
        this.local.setTransporte(new ArrayList<Transporte>());
    }

    public void guardarLocal() {
        this.servicioLocal.guardarLocal(local);
        this.locales = servicioLocal.cargarLocales();
        this.local = new Local();
        this.local.setMenu( new ArrayList<Menu>());
        this.local.setTransporte(new ArrayList<Transporte>());
    }
    
    public void eliminarLocal(Local local){
        this.servicioLocal.eliminarLocal(local);
        this.locales = servicioLocal.cargarLocales();
    }
    
    public void guardarLugar(){
        this.servicioLocal.guardarLugar(lugar);
        this.lugares = servicioLocal.cargarLugares();
        this.lugar = new Lugar();
    }
    
    /**
     * Método que guarda los lugares
     */
    public void guardarServicio() {
        this.servicioLocal.guardarSercivio(servicio);
        this.servicios = servicioLocal.cargarServicios();
        servicio = new Servicio();
    }
    
    /**
     * Método que guarda los menus
     */
    public void guardarMenu() {
        this.local.getMenu().add(menu);
        menu = new Menu();
    }
    
    /**
     * Método que guarda los trasportes
     */
    public void guardarTransporte() {
        this.local.getTransporte().add(transporte);
        transporte = new Transporte();
    }
    
    /**
     * 
     * @param event 
     */
    public void imagenServicio(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        this.servicio.setImagen(file.getContents());
    }
    
    public void imagenLocal(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        this.local.setImagen(file.getContents());
    }

    public List<Local> getLocales() {
        return locales;
    }

    public void setLocales(List<Local> locales) {
        this.locales = locales;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    /**
     * Método que regresa un servicio
     * @return Un servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Método que regresa un menu
     * @return Un menu
     */
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * Método que regresa un trasnsporte
     * @return Un transporte
     */
    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public List<Local> getTop5() {
        return locales;
    }

}
