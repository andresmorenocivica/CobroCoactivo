/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionRecursosBO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import org.primefaces.context.RequestContext;
import utility.Log_Handler;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class BeanGestionRecursos {

    private GestionRecursosBO gestionRecursosBO;
    private List<Recurso> listRecurso = new ArrayList<>();
    ;
    private BeanLogin loginBO;
    private boolean editable = true;
    // se tuliza para saber que recuuso se selecciona en la vista para editarlo, eliminarlo o ingresarlo
    private Recurso recurso;
    // se utiliza para cargar el combo de usuario en la vista
    private List<Perfiles> listPerfiles = new ArrayList<>();
    // se utiliza para cargar el combo de modulos en la vista
    private List<Modulo> listModulo = new ArrayList<>();
    // se utiliza para saber que modulo fue seleccionado en la vista
    private int idModuloSeleccionado;
    private int idPerfil;// identificador del select en la vista
    private int tipoBusqueda;

    /**
     * Creates a new instance of BeanGestionRecursos
     */
    /**
     * @return the gestionRecursosBO
     *
     *
     */
    @PostConstruct
    public void init() {
        try {

            getGestionRecursosBO().listarModulos(this);
            getGestionRecursosBO().listarPerfiles(this);

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }

    }

    public void save() {
        try {
            getGestionRecursosBO().save(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#detalleRecurso').modal('hide')");

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void eliminar() {
        try {
            getGestionRecursosBO().eliminarRegistro(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#eliminarRecurso').modal('hide')");

        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void buscarRecursosByModulo() {
        try {
            setTipoBusqueda(1);
            getGestionRecursosBO().listarRecursos(this);
            
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void buscarRecursosByPerfil() {
        try {
            setTipoBusqueda(2);
            getGestionRecursosBO().listarRecursos(this);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public void crearRegistro() {
        try {
            setEditable(true);
            Recurso recurso2 = new Recurso();
            setRecurso(recurso2);
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }
    
    public void update() {
        try {
            setEditable(true);
            getGestionRecursosBO().update(this);
            RequestContext requestContext = RequestContext.getCurrentInstance();
            requestContext.execute("$('#detalleRecurso').modal('hide')");
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    public GestionRecursosBO getGestionRecursosBO() {
        return gestionRecursosBO;
    }

    /**
     * @param gestionRecursosBO the gestionRecursosBO to set
     */
    public void setGestionRecursosBO(GestionRecursosBO gestionRecursosBO) {
        this.gestionRecursosBO = gestionRecursosBO;
    }

    public List<Recurso> getListRecurso() {
        return listRecurso;
    }

    public void setListRecurso(List<Recurso> listRecurso) {
        this.listRecurso = listRecurso;
    }

    public BeanLogin getLoginBO() {
        return loginBO;
    }

    public void setLoginBO(BeanLogin loginBO) {
        this.loginBO = loginBO;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public List<Perfiles> getListPerfiles() {
        return listPerfiles;
    }

    public void setListPerfiles(List<Perfiles> listPerfiles) {
        this.listPerfiles = listPerfiles;
    }

    /**
     * @return the listMosulo
     */
    public List<Modulo> getListMosulo() {
        return getListModulo();
    }

    /**
     * @param listMosulo the listMosulo to set
     */
    public void setListMosulo(List<Modulo> listMosulo) {
        this.setListModulo(listMosulo);
    }

    /**
     * @return the listModulo
     */
    public List<Modulo> getListModulo() {
        return listModulo;
    }

    /**
     * @param listModulo the listModulo to set
     */
    public void setListModulo(List<Modulo> listModulo) {
        this.listModulo = listModulo;
    }

    /**
     * @return the idModuloSeleccionado
     */
    public int getIdModuloSeleccionado() {
        return idModuloSeleccionado;
    }

    /**
     * @param idModuloSeleccionado the idModuloSeleccionado to set
     */
    public void setIdModuloSeleccionado(int idModuloSeleccionado) {
        this.idModuloSeleccionado = idModuloSeleccionado;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getTipoBusqueda() {
        return tipoBusqueda;
    }

    public void setTipoBusqueda(int tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

}
