/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que define los módulos y recursos a los cuales los usuarios tienen
 * acceso.
 *
 * @author ing_jefreypadilla
 */
public class Modulo implements Serializable {

    private static long serialVersionUID = 752642345145887L;

    private int id,estado;
    private String nombre;
    private String icon;
    private Date fechaInicial,FechaFinal;
    private List<Recurso> listRecurso = new ArrayList<>();

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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

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
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
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
     * @return the FechaFinal
     */
    public Date getFechaFinal() {
        return FechaFinal;
    }

    /**
     * @param FechaFinal the FechaFinal to set
     */
    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    /**
     * @return the listRecurso
     */
    public List<Recurso> getListRecurso() {
        return listRecurso;
    }

    /**
     * @param listRecurso the listRecurso to set
     */
    public void setListRecurso(List<Recurso> listRecurso) {
        this.listRecurso = listRecurso;
    }

    
}
