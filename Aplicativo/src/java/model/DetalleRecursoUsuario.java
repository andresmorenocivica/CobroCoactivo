/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class DetalleRecursoUsuario {
    private long idRecurso;
    private long idUsuario;
    private long id;
    private boolean propiedadVisible;
    private boolean propiedadEnabled;
    private Date fechaInicial;
    private Date fechaFinal;

    /**
     * @return the idRecurso
     */
    public long getIdRecurso() {
        return idRecurso;
    }

    /**
     * @param idRecurso the idRecurso to set
     */
    public void setIdRecurso(long idRecurso) {
        this.idRecurso = idRecurso;
    }

    /**
     * @return the idUsuario
     */
    public long getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the propiedadVisible
     */
    public boolean isPropiedadVisible() {
        return propiedadVisible;
    }

    /**
     * @param propiedadVisible the propiedadVisible to set
     */
    public void setPropiedadVisible(boolean propiedadVisible) {
        this.propiedadVisible = propiedadVisible;
    }

    /**
     * @return the propiedadEnabled
     */
    public boolean isPropiedadEnabled() {
        return propiedadEnabled;
    }

    /**
     * @param propiedadEnabled the propiedadEnabled to set
     */
    public void setPropiedadEnabled(boolean propiedadEnabled) {
        this.propiedadEnabled = propiedadEnabled;
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
    
}
