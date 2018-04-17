/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.TipoDocumentos;
import model.tablasParametricas;
import utility.Log_Handler;
import bo.GestionParametrosBO;

/**
 *
 * @author Admin
 */
public class BeanGestionParametros implements Serializable {

    private List<TipoDocumentos> listaTipoDocumentos = new ArrayList<>();
    private List<tablasParametricas> listaTablasParametricas = new ArrayList<>();
    private BeanLogin loginBO;
    private GestionParametrosBO gestionParametrosBO;

    @PostConstruct
    public void cargarDatos() {
        try {
            getLoginBO().getNombre();
            getGestionParametrosBO().llenarDatos(this);
            
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    /**
     * @return the listaTipoDocumentos
     */
    public List<TipoDocumentos> getListaTipoDocumentos() {
        return listaTipoDocumentos;
    }

    /**
     * @param listaTipoDocumentos the listaTipoDocumentos to set
     */
    public void setListaTipoDocumentos(List<TipoDocumentos> listaTipoDocumentos) {
        this.listaTipoDocumentos = listaTipoDocumentos;
    }

    /**
     * @return the listaTablasParametricas
     */
    public List<tablasParametricas> getListaTablasParametricas() {
        return listaTablasParametricas;
    }

    /**
     * @param listaTablasParametricas the listaTablasParametricas to set
     */
    public void setListaTablasParametricas(List<tablasParametricas> listaTablasParametricas) {
        this.listaTablasParametricas = listaTablasParametricas;
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
     * @return the gestionParametrosBO
     */
    public GestionParametrosBO getGestionParametrosBO() {
        return gestionParametrosBO;
    }

    /**
     * @param gestionParametrosBO the gestionParametrosBO to set
     */
    public void setGestionParametrosBO(GestionParametrosBO gestionParametrosBO) {
        this.gestionParametrosBO = gestionParametrosBO;
    }

}
