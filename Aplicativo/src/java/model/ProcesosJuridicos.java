/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProcesosJuridicos {
    private long id;
    private long idUsuario;
    private long idDivipo;
    private String nombre;
    private Date fechaInicial;
    private Date fechaFinal;
    private List<DetalleProcesoJuridico> detalleProcesoJuridico;

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
     * @return the idDivipo
     */
    public long getIdDivipo() {
        return idDivipo;
    }

    /**
     * @param idDivipo the idDivipo to set
     */
    public void setIdDivipo(long idDivipo) {
        this.idDivipo = idDivipo;
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
     * @return the detalleProcesoJuridico
     */
    public List<DetalleProcesoJuridico> getDetalleProcesoJuridico() {
        return detalleProcesoJuridico;
    }

    /**
     * @param detalleProcesoJuridico the detalleProcesoJuridico to set
     */
    public void setDetalleProcesoJuridico(List<DetalleProcesoJuridico> detalleProcesoJuridico) {
        this.detalleProcesoJuridico = detalleProcesoJuridico;
    }
    
    
}
