/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionEstadosBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.EstadosDatos;
import model.tablaEstadosParametricos;
import utility.Log_Handler;

/**
 *
 * @author amoreno
 */
public class BeanGestionEstados  implements Serializable{
    
    private GestionEstadosBO gestionEstadosBO;
    private List<tablaEstadosParametricos> listaTablaEstadosParametricos = new ArrayList<>();
    private BeanLogin loginBO;
    private EstadosDatos registroEstado;
    
    
     @PostConstruct
    public void cargarDatos() {
        try {
            getGestionEstadosBO().llenarDatos(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }
    
      public void crearRegistro(EstadosDatos estadoDato) {
        try {
            setRegistroEstado(new EstadosDatos());
            getRegistroEstado().setEditable(false);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }
    
    
    /**
     * @return the gestionEstadosBO
     */
    public GestionEstadosBO getGestionEstadosBO() {
        return gestionEstadosBO;
    }

    /**
     * @param gestionEstadosBO the gestionEstadosBO to set
     */
    public void setGestionEstadosBO(GestionEstadosBO gestionEstadosBO) {
        this.gestionEstadosBO = gestionEstadosBO;
    }

    /**
     * @return the listaTablaEstadosParametricos
     */
    public List<tablaEstadosParametricos> getListaTablaEstadosParametricos() {
        return listaTablaEstadosParametricos;
    }

    /**
     * @param listaTablaEstadosParametricos the listaTablaEstadosParametricos to set
     */
    public void setListaTablaEstadosParametricos(List<tablaEstadosParametricos> listaTablaEstadosParametricos) {
        this.listaTablaEstadosParametricos = listaTablaEstadosParametricos;
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
     * @return the registroEstado
     */
    public EstadosDatos getRegistroEstado() {
        return registroEstado;
    }

    /**
     * @param registroEstado the registroEstado to set
     */
    public void setRegistroEstado(EstadosDatos registroEstado) {
        this.registroEstado = registroEstado;
    }
    
}
