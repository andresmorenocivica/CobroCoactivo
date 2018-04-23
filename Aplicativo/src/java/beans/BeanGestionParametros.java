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
import model.tablasParametricas;
import utility.Log_Handler;
import bo.GestionParametrosBO;
import model.Parametros;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Admin
 */
public class BeanGestionParametros implements Serializable {

    private List<tablasParametricas> listaTablasParametricas = new ArrayList<>();
    private BeanLogin loginBO;
    private GestionParametrosBO gestionParametrosBO;
     private Parametros registroParametro = new Parametros();
    private boolean editable = true;

    private String nombreCorto;

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

    public void eliminar() {
        try {
            getGestionParametrosBO().eliminarRegistro(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void update() {
        try {
            getGestionParametrosBO().update(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#detalleParametro').modal('hide')");

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");

        }

    }

    public void save() {
        try {
            getGestionParametrosBO().save(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#detalleParametro').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }

    }

    public void crearRegistro(tablasParametricas tablaParametrica) {
        try {
            setEditable(false);
            Parametros nuevoRegistroParametro = new Parametros();
            nuevoRegistroParametro.setNombreTabla(tablaParametrica.getNombreTabla());
            setRegistroParametro(nuevoRegistroParametro);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
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

    /**
     * @return the registroParametro
     */
    public Parametros getRegistroParametro() {
        return registroParametro;
    }

    /**
     * @param registroParametro the registroParametro to set
     */
    public void setRegistroParametro(Parametros registroParametro) {
        this.registroParametro = registroParametro;
    }

    /**
     * @return the nombreCorto
     */
    public String getNombreCorto() {
        return nombreCorto;
    }

    /**
     * @param nombreCorto the nombreCorto to set
     */
    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
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

}
