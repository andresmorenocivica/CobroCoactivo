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
import model.EstadosDatos;
import model.EstadosRecursos;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import model.TipoRecursos;
import org.primefaces.context.RequestContext;
import utility.Log_Handler;

/**
 *
 * @author Admin
 */
public class BeanGestionModulos implements Serializable {

    private BeanLogin loginBO;
    private GestionModulosBO gestionModulosBO;
    private List<Modulo> listamodulos = new ArrayList<>();
    private List<Perfiles> listaperfil = new ArrayList<>();
    private Modulo registromodulo;
    private boolean editable;
    private Recurso registroRecurso;
    private int idTipoRecursoSeleccionado;
    private List<TipoRecursos> listTipoRecursos = new ArrayList<>();
    private List<EstadosRecursos> listaEstadoRecursos = new ArrayList<>();
    
    @PostConstruct
    public void cargarDatos() {
        try {
            getGestionModulosBO().llenarDatos(this);
            getGestionModulosBO().listarperfiles(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void eliminarRecurso() {
        try {
            getGestionModulosBO().eliminarRecurso(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#eliminarRecurso').modal('hide')");

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }
    }

    public void crearRegistroModulo() {
        try {
            setEditable(false);
            setRegistromodulo(new Modulo());
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }

    }

    public void crearRegistroRecurso(int idModulo) {
        try {
            setEditable(false);
            setRegistroRecurso(new Recurso());
            getRegistroRecurso().setModuloId(idModulo);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");
        }

    }

    public void guardarRegistro() {
        try {
            getGestionModulosBO().guardar(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#modalModulo').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");

        }

    }

    public void editarRecurso() {

        try {
            getGestionModulosBO().actualizarRecurso(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#modalagregarRecurso').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionModulos" + "messageGeneral");

        }

    }

    public void guardarRegistroRecurso() {
        try {
            getGestionModulosBO().guardarRecurso(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#modalagregarRecurso').modal('hide')");

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

    /**
     * @return the registromodulo
     */
    public Modulo getRegistromodulo() {
        return registromodulo;
    }

    /**
     * @param registromodulo the registromodulo to set
     */
    public void setRegistromodulo(Modulo registromodulo) {
        this.registromodulo = registromodulo;
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
     * @return the registroRecurso
     */
    public Recurso getRegistroRecurso() {
        return registroRecurso;
    }

    /**
     * @param registroRecurso the registroRecurso to set
     */
    public void setRegistroRecurso(Recurso registroRecurso) {
        this.registroRecurso = registroRecurso;
    }

    /**
     * @return the listaperfil
     */
    public List<Perfiles> getListaperfil() {
        return listaperfil;
    }

    /**
     * @param listaperfil the listaperfil to set
     */
    public void setListaperfil(List<Perfiles> listaperfil) {
        this.listaperfil = listaperfil;
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
     * @return the listaEstadoRecursos
     */
    public List<EstadosDatos> getListaEstadoRecursos() {
        return listaEstadoRecursos;
    }

    /**
     * @param listaEstadoRecursos the listaEstadoRecursos to set
     */
    public void setListaEstadoRecursos(List<EstadosDatos> listaEstadoRecursos) {
        this.listaEstadoRecursos = listaEstadoRecursos;
    }

}
