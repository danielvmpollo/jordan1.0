/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sow.jordan.modelos;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import sun.misc.BASE64Encoder;

/**
 * Clase que servirá como un catalogo que muestra los servicios que brinda 
 * un lical
 * @author GARCÍA CASTRO HÉCTOR JAVIER
 * @author LARA RAMÍREZ JOSÉ JAVIER
 * @author OLIVOS NAVARRO CESAR JONATHAN
 * @author VILLEGAS MORENO ZEUXIS DANIEL
 */
@Entity
@Table(name = "Servicio")
public class Servicio implements Serializable {
    
    /**
     * Variable que indica el id del servicio, las etiquetas indican dicha variable
     * es el id y que se va a ir auto incrementando.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    /**
     * Variable que almacena el nombre del servicio, la etiqueta indica que no
     * puede ser nulo su valor.
     */
    @NotNull
    private String nombre;

    @Lob
    @Column(name = "imagen",columnDefinition = "LONGBLOB")
    @Basic(fetch=FetchType.LAZY)
    private byte[] imagen;
    
    /**
     * Método que regresa el id del servicio
     * @return un entero con la información
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Método que asigna un nuevo id
     * @param id El nuevo valor del id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Método que regresa el nombre del servicio
     * @return Una cadena con la información
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que asigna un nuevo nombre
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que regresa la imagén del servicio
     * @return Una cadena de bytes
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Método que asigna una nueva imagén
     * @param imagen La nueva imagen
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    /**
     * Método que se utiliza para poder ver la imagén
     * @return Una cadena legible para el sistema
     */
    public String getImagenUrl() {
        if (this != null && this.getImagen()!= null) {
            BASE64Encoder encoder = new BASE64Encoder();
            String imageString = encoder.encode(this.getImagen());
            return imageString;
        } else {
            return null;
        }
    }
}