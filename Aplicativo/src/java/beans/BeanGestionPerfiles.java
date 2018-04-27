/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionPerfilesBO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import model.TipoRecursos;
import org.primefaces.context.RequestContext;
import utility.Log_Handler;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class BeanGestionPerfiles implements Serializable {

    /**
     * @return the listModulos
     */
    public List<Modulo> getListModulos() {
        return listModulos;
    }

    /**
     * @param listModulos the listModulos to set
     */
    public void setListModulos(List<Modulo> listModulos) {
        this.listModulos = listModulos;
    }

    private BeanLogin loginBO;
    private GestionPerfilesBO gestionPerfilesBO;
    private List<Perfiles> listPerfiles = new ArrayList<>();
    private Perfiles civPerfiles = new Perfiles();
    private Recurso recursos = new Recurso();
    private List<Modulo> listModulos = new ArrayList<>();
    private List<TipoRecursos> listTipoRecursos = new ArrayList<>();
    private boolean editable;
    private long idPerfil;
    private int idTipoRecursoSeleccionado;

    @PostConstruct
    public void iniciar() {
        try {
            getGestionPerfilesBO().llenarDatos(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void save() {
        try {
            getGestionPerfilesBO().save(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#adicionarPerfil').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void update() {
        try {
            getGestionPerfilesBO().update(this);
            getGestionPerfilesBO().eliminarRegistro(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#detalleRecurso').modal('hide')");

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void crearRecurso(long id) {
        try {
            setRecursos(new Recurso());
            setEditable(true);
            setIdPerfil(id);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }
    
    public void saveRecurso(){
        try {
            getGestionPerfilesBO().saveRecurso(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void delete() {
        try {

            getGestionPerfilesBO().eliminarRegistro(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#eliminarRecurso').modal('hide')");

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    //Getter and setter
    public GestionPerfilesBO getGestionPerfilesBO() {
        return gestionPerfilesBO;
    }

    public void setGestionPerfilesBO(GestionPerfilesBO gestionPerfilesBO) {
        this.gestionPerfilesBO = gestionPerfilesBO;
    }

    public BeanLogin getLoginBO() {
        return loginBO;
    }

    public void setLoginBO(BeanLogin loginBO) {
        this.loginBO = loginBO;
    }

    public BeanGestionPerfiles() {
    }

    /**
     * @return the listPerfiles
     */
    public List<Perfiles> getListPerfiles() {
        return listPerfiles;
    }

    /**
     * @param listPerfiles the listPerfiles to set
     */
    public void setListPerfiles(List<Perfiles> listPerfiles) {
        this.listPerfiles = listPerfiles;
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
     * @return the civPerfiles
     */
    public Perfiles getCivPerfiles() {
        return civPerfiles;
    }

    /**
     * @param civPerfiles the civPerfiles to set
     */
    public void setCivPerfiles(Perfiles civPerfiles) {
        this.civPerfiles = civPerfiles;
    }

    /**
     * @return the recursos
     */
    public Recurso getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(Recurso recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the idPerfil
     */
    public long getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(long idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @return the listTipoRecursos
     */
    public List<TipoRecursos> getListTipoRecursos() {
        return listTipoRecursos;
    }

    /**
     * @param listTipoRecursos the listTipoRecursos to set
     */
    public void setListTipoRecursos(List<TipoRecursos> listTipoRecursos) {
        this.listTipoRecursos = listTipoRecursos;
    }

    /**
     * @return the idTipoRecursoSeleccionado
     */
    public int getIdTipoRecursoSeleccionado() {
        return idTipoRecursoSeleccionado;
    }

    /**
     * @param idTipoRecursoSeleccionado the idTipoRecursoSeleccionado to set
     */
    public void setIdTipoRecursoSeleccionado(int idTipoRecursoSeleccionado) {
        this.idTipoRecursoSeleccionado = idTipoRecursoSeleccionado;
    }

}
