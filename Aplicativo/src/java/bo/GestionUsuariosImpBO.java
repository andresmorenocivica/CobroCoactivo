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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jdbc.dao.ITLogin;
import jdbc.dao.ITPerfilRecursos;
import jdbc.dao.ITPerfiles;
import jdbc.dao.ITPersonas;
import jdbc.dao.ITTipoDocumento;
import jdbc.dao.ITUsuarios;
import model.PerfilRecurso;
import model.Perfiles;
import model.Personas;
import model.TipoDocumentos;
import model.Usuarios;
import persistencias.CivPerfiles;
import persistencias.CivPerfilrecurso;
import persistencias.CivPersonas;
import persistencias.CivTipodocumentos;
import persistencias.CivUsuarios;

/**
 *
 * @author amoreno
 */
public class GestionUsuariosImpBO implements GestionUsuarioBO, Serializable {

    private ITLogin loginDAO;
    private ITUsuarios usuariosDAO;
    private ITPersonas personasDAO;
    private ITTipoDocumento tiposDocumentosDAO;
    private ITPerfiles perfilesDAO;
    private ITPerfilRecursos perfilRecursoDAO;

    @Override
    public void consultar(BeanGestionUsuario bean) throws Exception {
        List<CivUsuarios> listaCivUsuario = new ArrayList<>();
        switch (bean.getTipoBusqueda()) {
            case 1:
                listaCivUsuario = getUsuariosDAO().listarUsuarios(bean.getNombreUsuario().toUpperCase());
                break;
        }
        if (listaCivUsuario != null && listaCivUsuario.size() > 0) {
            for (CivUsuarios civUsuarios : listaCivUsuario) {
                Usuarios usuario = new Usuarios();
                usuario.setId(civUsuarios.getUsuId().intValue());
                usuario.setNombre(civUsuarios.getUsuNombre());
                usuario.setEstado(civUsuarios.getCivEstadousuarios().getEstusuId().intValue());
                usuario.setFechaInicial(civUsuarios.getUsuFechainicial());
                usuario.setFechaFinal(civUsuarios.getUsuFechafinal());
                usuario.setFechaProceso(civUsuarios.getUsuFechaproceso());
                usuario.setIdPersona(civUsuarios.getCivPersonas().getPerId().intValue());
                CivPersonas personaUsuario = getPersonasDAO().consultarPersonasById(civUsuarios.getCivPersonas().getPerId().intValue());
                Personas persona = new Personas();
                
                persona.setId(personaUsuario.getPerId().intValue());
                persona.setNombre1(personaUsuario.getPerNombre1());
                persona.setNombre2(personaUsuario.getPerNombre2());
                persona.setApellido1(personaUsuario.getPerApellido1());
                persona.setApellido2(personaUsuario.getPerApellido2());
                persona.setDocumento(personaUsuario.getPerDocumento());
                
                CivTipodocumentos civTipoDocumento = getTiposDocumentosDAO().getTipoDocumento(personaUsuario.getCivTipodocumentos().getTipdocId());
                TipoDocumentos tipoDocumentoPersona = new TipoDocumentos();
                tipoDocumentoPersona.setCodigo(civTipoDocumento.getTipdocCodigo().intValue());
                tipoDocumentoPersona.setNombre(civTipoDocumento.getTipdocNombre());
                tipoDocumentoPersona.setNombreCorto(civTipoDocumento.getTipdocNombrecorto());
                
                persona.setTipoDocumentoPersona(tipoDocumentoPersona);
                
                usuario.setNombrePersona(personaUsuario.getPerNombre1() + " " + personaUsuario.getPerApellido1());
                usuario.setPersona(persona);
                bean.getListadoUsuarios().add(usuario);
            }
        }else{
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
               "No se Encontro Usuario en el sistema", null));
        }
    }

     @Override
    public void listarPerfiles(BeanGestionUsuario bean) throws Exception {
        List<CivPerfiles> listCivPerfiles = getPerfilesDAO().listarPerfilesUsuario((int)bean.getUsuarioDetalle().getId());
         for (CivPerfiles civPerfiles : listCivPerfiles) {
             Perfiles perfil = new Perfiles();
             perfil.setId(civPerfiles.getPerfId().intValue());
             perfil.setNombre(civPerfiles.getPerfNombre());
             bean.getListadoPerfiles().add(perfil);
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

    /**
     * @return the tiposDocumentosDAO
     */
    public ITTipoDocumento getTiposDocumentosDAO() {
        return tiposDocumentosDAO;
    }

    /**
     * @param tiposDocumentosDAO the tiposDocumentosDAO to set
     */
    public void setTiposDocumentosDAO(ITTipoDocumento tiposDocumentosDAO) {
        this.tiposDocumentosDAO = tiposDocumentosDAO;
    }

    /**
     * @return the perfilesDAO
     */
    public ITPerfiles getPerfilesDAO() {
        return perfilesDAO;
    }

    /**
     * @param perfilesDAO the perfilesDAO to set
     */
    public void setPerfilesDAO(ITPerfiles perfilesDAO) {
        this.perfilesDAO = perfilesDAO;
    }

    /**
     * @return the perfilRecursoDAO
     */
    public ITPerfilRecursos getPerfilRecursoDAO() {
        return perfilRecursoDAO;
    }

    /**
     * @param perfilRecursoDAO the perfilRecursoDAO to set
     */
    public void setPerfilRecursoDAO(ITPerfilRecursos perfilRecursoDAO) {
        this.perfilRecursoDAO = perfilRecursoDAO;
    }

   

}
