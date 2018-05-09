/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author pruebadesarrollo
 */
public class Movimientos {

    private BigDecimal movId;
    private BigDecimal deuId;
    private BigDecimal detpropId;
    private String nombreDetalleProceso;
    private Date fechaInicial;
    private Date fechaFinal;
    private BigDecimal usuId;
    private String nombreUsuario;
    private BigDecimal estmovId;

    /**
     * @return the estmovId
     */
    public BigDecimal getEstmovId() {
        return estmovId;
    }

    /**
     * @param estmovId the estmovId to set
     */
    public void setEstmovId(BigDecimal estmovId) {
        this.estmovId = estmovId;
    }

    /**
     * @return the movId
     */
    public BigDecimal getMovId() {
        return movId;
    }

    /**
     * @param movId the movId to set
     */
    public void setMovId(BigDecimal movId) {
        this.movId = movId;
    }


    /**
     * @return the deuId
     */
    public BigDecimal getDeuId() {
        return deuId;
    }

    /**
     * @param deuId the deuId to set
     */
    public void setDeuId(BigDecimal deuId) {
        this.deuId = deuId;
    }

    /**
     * @return the detpropId
     */
    public BigDecimal getDetpropId() {
        return detpropId;
    }

    /**
     * @param detpropId the detpropId to set
     */
    public void setDetpropId(BigDecimal detpropId) {
        this.detpropId = detpropId;
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
     * @return the usuId
     */
    public BigDecimal getUsuId() {
        return usuId;
    }

    /**
     * @param usuId the usuId to set
     */
    public void setUsuId(BigDecimal usuId) {
        this.usuId = usuId;
    }

    /**
     * @return the nombreDetalleProceso
     */
    public String getNombreDetalleProceso() {
        return nombreDetalleProceso;
    }

    /**
     * @param nombreDetalleProceso the nombreDetalleProceso to set
     */
    public void setNombreDetalleProceso(String nombreDetalleProceso) {
        this.nombreDetalleProceso = nombreDetalleProceso;
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
