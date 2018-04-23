/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionModulosBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Modulo;
import model.Recurso;
import utility.Log_Handler;

/**
 *
 * @author Admin
 */
public class BeanGestionModulos implements Serializable {

    private BeanLogin loginBO;

    private GestionModulosBO gestionModulosBO;
    
    private List<Modulo> listamodulos = new ArrayList<>();

    @PostConstruct
    public void cargarDatos() {
        try {
            getGestionModulosBO().llenarDatos(this);
            List<Recurso> listRecurso = getListamodulos().get(0).getListRecurso();
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
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
     * @return the gestionModulosBO
     */
    public GestionModulosBO getGestionModulosBO() {
        return gestionModulosBO;
    }

    /**
     * @param gestionModulosBO the gestionModulosBO to set
     */
    public void setGestionModulosBO(GestionModulosBO gestionModulosBO) {
        this.gestionModulosBO = gestionModulosBO;
    }

    /**
     * @return the listamodulos
     */
    public List<Modulo> getListamodulos() {
        return listamodulos;
    }

    /**
     * @param listamodulos the listamodulos to set
     */
    public void setListamodulos(List<Modulo> listamodulos) {
        this.listamodulos = listamodulos;
    }

}
