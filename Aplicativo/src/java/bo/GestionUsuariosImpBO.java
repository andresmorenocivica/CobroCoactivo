/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionUsuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jdbc.dao.ITLogin;
import jdbc.dao.ITPersonas;
import jdbc.dao.ITUsuarios;
import model.Usuarios;
import persistencias.CivPersonas;
import persistencias.CivUsuarios;

/**
 *
 * @author amoreno
 */
public class GestionUsuariosImpBO implements GestionUsuarioBO, Serializable {

    private ITLogin loginDAO;
    private ITUsuarios usuariosDAO;
    private ITPersonas personasDAO;

    @Override
    public void consultar(BeanGestionUsuario bean) throws Exception {
        List<CivUsuarios> listaCivUsuario = new ArrayList<>();
        switch(bean.getTipoBusqueda()){
            case 1:
                listaCivUsuario = getUsuariosDAO().listarUsuarios(bean.getNombreUsuario().toUpperCase());
                break;
        }
        if(listaCivUsuario != null && listaCivUsuario.size() >0){
            for (CivUsuarios civUsuarios : listaCivUsuario) {
                Usuarios usuario = new Usuarios();
                usuario.setId(civUsuarios.getUsuId().intValue());
                usuario.setNombre(civUsuarios.getUsuNombre());
                usuario.setEstado(civUsuarios.getUsuEstado().intValue());
                usuario.setFechaInicial(civUsuarios.getUsuFechainicial());
                usuario.setFechaFinal(civUsuarios.getUsuFechafinal());
                usuario.setIdPersona(civUsuarios.getCivPersonas().getPerId().intValue());
                CivPersonas personaUsuario = getPersonasDAO().consultarPersonasById(civUsuarios.getCivPersonas().getPerId().intValue());
                usuario.setNombrePersona(personaUsuario.getPerNombre1() +" "+personaUsuario.getPerApellido1());
                bean.getListadoUsuarios().add(usuario);
            }
        }
    }

    /**
     * @return the loginDAO
     */
    public ITLogin getLoginDAO() {
        return loginDAO;
    }

    /**
     * @param loginDAO the loginDAO to set
     */
    public void setLoginDAO(ITLogin loginDAO) {
        this.loginDAO = loginDAO;
    }

    /**
     * @return the usuariosDAO
     */
    public ITUsuarios getUsuariosDAO() {
        return usuariosDAO;
    }

    /**
     * @param usuariosDAO the usuariosDAO to set
     */
    public void setUsuariosDAO(ITUsuarios usuariosDAO) {
        this.usuariosDAO = usuariosDAO;
    }

    /**
     * @return the personasDAO
     */
    public ITPersonas getPersonasDAO() {
        return personasDAO;
    }

    /**
     * @param personasDAO the personasDAO to set
     */
    public void setPersonasDAO(ITPersonas personasDAO) {
        this.personasDAO = personasDAO;
    }

   

}
