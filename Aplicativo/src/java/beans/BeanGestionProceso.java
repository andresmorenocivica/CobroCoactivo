/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionProcesoBO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.DetalleProcesoJuridico;
import model.Estado;
import model.ProcesosJuridicos;
import org.primefaces.context.RequestContext;
import utility.Log_Handler;

/**
 *
 * @author pruebadesarrollo
 */
public class BeanGestionProceso {

    private BeanLogin loginBO;
    private GestionProcesoBO gestionProcesoBO;
    private List<ProcesosJuridicos> ProcesoList = new ArrayList<>();
    private ProcesosJuridicos registroProcesoJuridico = new ProcesosJuridicos();
    private List<Estado> estadoProceso = new ArrayList<>();
    private boolean editable = false;
    private DetalleProcesoJuridico detalleProcesoJuridico = new DetalleProcesoJuridico();
    

    @PostConstruct
    public void cargarDatos() {
        try {
            getGestionProcesoBO().cargarListaProceso(this);
            getGestionProcesoBO().cargarEstadoProceso(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void guardarProceso() {
        try {
            getGestionProcesoBO().guardarProcesoJuridico(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#modalagregarProceso').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void crearRegistro() {
        try {
            setRegistroProcesoJuridico(new ProcesosJuridicos());
            setEditable(false);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void actualizarRegistro() {
        try {
            setEditable(true);
            getGestionProcesoBO().actualizarProceso(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#modalagregarProceso').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void eliminarRegistro() {
        try {
            if (getRegistroProcesoJuridico().getEstado() == 2) {
                getRegistroProcesoJuridico().setFechaFinal(new Date());
            } else {
                getRegistroProcesoJuridico().setFechaFinal(null);
            }
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void guardarFases() {
        try {
            getGestionProcesoBO().guardarFases(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#modalagregarFases').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }
    public void actualizar(){
        try{
            getGestionProcesoBO().actulizarFases(this);
        }catch (Exception e){
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
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
     * @return the gestionProcesoBO
     */
    public GestionProcesoBO getGestionProcesoBO() {
        return gestionProcesoBO;
    }

    /**
     * @param gestionProcesoBO the gestionProcesoBO to set
     */
    public void setGestionProcesoBO(GestionProcesoBO gestionProcesoBO) {
        this.gestionProcesoBO = gestionProcesoBO;
    }

    /**
     * @return the ProcesoList
     */
    public List<ProcesosJuridicos> getProcesoList() {
        return ProcesoList;
    }

    /**
     * @param ProcesoList the ProcesoList to set
     */
    public void setProcesoList(List<ProcesosJuridicos> ProcesoList) {
        this.ProcesoList = ProcesoList;
    }

    /**
     * @return the registroProcesoJuridico
     */
    public ProcesosJuridicos getRegistroProcesoJuridico() {
        return registroProcesoJuridico;
    }

    /**
     * @param registroProcesoJuridico the registroProcesoJuridico to set
     */
    public void setRegistroProcesoJuridico(ProcesosJuridicos registroProcesoJuridico) {
        this.registroProcesoJuridico = registroProcesoJuridico;
    }

    /**
     * @return the estadoProceso
     */
    public List<Estado> getEstadoProceso() {
        return estadoProceso;
    }

    /**
     * @param estadoProceso the estadoProceso to set
     */
    public void setEstadoProceso(List<Estado> estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    /**
     * @return the detalleProcesoJuridico
     */
    public DetalleProcesoJuridico getDetalleProcesoJuridico() {
        return detalleProcesoJuridico;
    }

    /**
     * @param detalleProcesoJuridico the detalleProcesoJuridico to set
     */
    public void setDetalleProcesoJuridico(DetalleProcesoJuridico detalleProcesoJuridico) {
        this.detalleProcesoJuridico = detalleProcesoJuridico;
    }

}
