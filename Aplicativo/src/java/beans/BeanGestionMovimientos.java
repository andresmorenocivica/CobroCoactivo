/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionMovimientosBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DetalleProcesoJuridico;
import model.ProcesosJuridicos;
import utility.Log_Handler;

/**
 *
 * @author jvergara
 */
public class BeanGestionMovimientos {

    
    private GestionMovimientosBO gestionMovimientosBO;
    private BeanLogin loginBO;
    private List<ProcesosJuridicos> listaProcesoJuridisco = new ArrayList<>();
    private List<DetalleProcesoJuridico> listDetalleProcesoJuridico;
    
    
        @PostConstruct
    public void cargarDatos() {
        try {
          
            getGestionMovimientosBO().cargarListaProceso(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    
    
    /**
     * @return the gestionMovimientosBO
     */
    
    public GestionMovimientosBO getGestionMovimientosBO() {
        return gestionMovimientosBO;
    }

    /**
     * @param gestionMovimientosBO the gestionMovimientosBO to set
     */
    public void setGestionMovimientosBO(GestionMovimientosBO gestionMovimientosBO) {
        this.gestionMovimientosBO = gestionMovimientosBO;
    }

    /**
     * @return the loginBO
     */
    public BeanLogin getLoginBO() {
        return loginBO;
    }

    /**
     * @param loginBO the loginBO to set
     */
    public void setLoginBO(BeanLogin loginBO) {
        this.loginBO = loginBO;
    }

    /**
     * @return the listaProcesoJuridisco
     */
    public List<ProcesosJuridicos> getListaProcesoJuridisco() {
        return listaProcesoJuridisco;
    }

    /**
     * @param listaProcesoJuridisco the listaProcesoJuridisco to set
     */
    public void setListaProcesoJuridisco(List<ProcesosJuridicos> listaProcesoJuridisco) {
        this.listaProcesoJuridisco = listaProcesoJuridisco;
    }

    /**
     * @return the listDetalleProcesoJuridico
     */
    public List<DetalleProcesoJuridico> getListDetalleProcesoJuridico() {
        return listDetalleProcesoJuridico;
    }

    /**
     * @param listDetalleProcesoJuridico the listDetalleProcesoJuridico to set
     */
    public void setListDetalleProcesoJuridico(List<DetalleProcesoJuridico> listDetalleProcesoJuridico) {
        this.listDetalleProcesoJuridico = listDetalleProcesoJuridico;
    }
    
}
