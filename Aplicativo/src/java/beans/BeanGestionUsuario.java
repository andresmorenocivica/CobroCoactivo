/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import bo.GestionUsuarioBO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Perfiles;
import model.Usuarios;
import utility.Log_Handler;

/**
 *
 * @author amoreno
 */
public class BeanGestionUsuario {

    private GestionUsuarioBO gestionUsariosBO;
    private BeanLogin loginBO;
    private String NombreUsuario;
    private List<Usuarios> listadoUsuarios = new ArrayList<>();
    private int tipoBusqueda;

    public void consultarUsuario(int tipo) {
        try {
            setTipoBusqueda(tipo);
            getLoginBO().getNombrePersonaUsuario();
            getGestionUsariosBO().consultar(this);
            getListadoUsuarios().size();
        } catch (Exception e) {
            Log_Handler.registrarEvento("Error al cargar datos : ", e, Log_Handler.ERROR, getClass(), Integer.parseInt(getLoginBO().getID_Usuario()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", Log_Handler.solucionError(e)));
            FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("gestionParametros" + "messageGeneral");
        }
    }

    /**
     * @return the gestionUsariosBO
     */
    public GestionUsuarioBO getGestionUsariosBO() {
        return gestionUsariosBO;
    }

    /**
     * @param gestionUsariosBO the gestionUsariosBO to set
     */
    public void setGestionUsariosBO(GestionUsuarioBO gestionUsariosBO) {
        this.gestionUsariosBO = gestionUsariosBO;
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
     * @return the NombreUsuario
     */
    public String getNombreUsuario() {
        return NombreUsuario;
    }

    /**
     * @param NombreUsuario the NombreUsuario to set
     */
    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    /**
     * @return the listadoUsuarios
     */
    public List<Usuarios> getListadoUsuarios() {
        return listadoUsuarios;
    }

    /**
     * @param listadoUsuarios the listadoUsuarios to set
     */
    public void setListadoUsuarios(List<Usuarios> listadoUsuarios) {
        this.listadoUsuarios = listadoUsuarios;
    }

    /**
     * @return the tipoBusqueda
     */
    public int getTipoBusqueda() {
        return tipoBusqueda;
    }

    /**
     * @param tipoBusqueda the tipoBusqueda to set
     */
    public void setTipoBusqueda(int tipoBusqueda) {
        this.tipoBusqueda = tipoBusqueda;
    }

}
