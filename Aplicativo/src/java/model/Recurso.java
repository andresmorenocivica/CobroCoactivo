/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 * Clase que define un recurso del sistema. Por ejemplo una vista que se llama
 * desde el menú principal.
 *
 * @author ing_jefreypadilla
 */
public class Recurso implements Serializable {

    public static long serialVersionUID = 7526423451548L;

    public int codigo;
    @NotNull(message = "el nombre no puede estar vacio")
    public String nombre;
    @NotNull(message = "la carpeta no puede estar vacio")
    public String carpeta;
    @NotNull(message = "la descripcion no puede estar vacio")
    public String descripcion;
    
    public int tipo;
    private EstadosRecursos estadosRecursos;
    public int moduloId;
    public int perfilId;
    @NotNull(message = "la fecha no puede estar vacia")
    public Date fechaInicial;
    public Date fechaFinal;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the carpeta
     */
    public String getCarpeta() {
        return carpeta;
    }

    /**
     * @param carpeta the carpeta to set
     */
    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }



    /**
     * @return the moduloId
     */
    public int getModuloId() {
        return moduloId;
    }

    /**
     * @param moduloId the moduloId to set
     */
    public void setModuloId(int moduloId) {
        this.moduloId = moduloId;
    }

    /**
     * @return the perfilId
     */
    public int getPerfilId() {
        return perfilId;
    }

    /**
     * @param perfilId the perfilId to set
     */
    public void setPerfilId(int perfilId) {
        this.perfilId = perfilId;
    }

    /**
     * @return the fechaInicial
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return the fechaFinal
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param fechaFinal the fechaFinal to set
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return the estadosRecursos
     */
    public EstadosRecursos getEstadosRecursos() {
        return estadosRecursos;
    }

    /**
     * @param estadosRecursos the estadosRecursos to set
     */
    public void setEstadosRecursos(EstadosRecursos estadosRecursos) {
        this.estadosRecursos = estadosRecursos;
    }
}
