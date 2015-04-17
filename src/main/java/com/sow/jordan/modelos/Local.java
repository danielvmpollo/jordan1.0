/*
 * Paquete que contiene los modelos del sistema Jordan
 */
package com.sow.jordan.modelos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import sun.misc.BASE64Encoder;

/**
 *
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Local")
public class Local implements Serializable{
    
    @Id //indica que es la llave de la tabla
    @GeneratedValue(strategy=GenerationType.AUTO)// Indica que se va a auto incrementar
    private Integer id;
    
    @NotNull
    private String nombre;
    
    private String alias;
    
    @ManyToOne
    private Lugar lugar;
    
    @NotNull
    private Double latitud;
    
    @NotNull
    private Double longitud;
    
    private String especialidad;
    
    private String descripcion;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Servicio> servicios;
    
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "local",
            orphanRemoval = true)
    private List<Menu> menu;
    
    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "local",
            orphanRemoval = true)
    private List<Transporte> transportes;
    
    @Lob
    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    @Basic(fetch = FetchType.LAZY)
    private byte[] imagen;

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public List<Transporte> getTransporte() {
        return transportes;
    }

    public void setTransporte(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    public byte[] getImagen() {
        return imagen;
    }
    
    public String getImagenUrl() {
        if (this != null && this.getImagen()!= null) {
            BASE64Encoder encoder = new BASE64Encoder();
            String imageString = encoder.encode(this.getImagen());
            return imageString;
        } else {
            return null;
        }
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    
    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.alias);
        hash = 53 * hash + Objects.hashCode(this.especialidad);
        hash = 53 * hash + Objects.hashCode(this.latitud);
        hash = 53 * hash + Objects.hashCode(this.longitud);
        hash = 53 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }    
    
    public int getCalificacion(){
        return 5;
    }
    
}