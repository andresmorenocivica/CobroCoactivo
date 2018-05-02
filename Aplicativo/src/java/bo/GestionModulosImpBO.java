/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionModulos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jdbc.dao.ITEstadoModulos;
import jdbc.dao.ITEstadoRecursos;
import jdbc.dao.ITLogin;
import jdbc.dao.ITModulos;
import jdbc.dao.ITPerfiles;
import jdbc.dao.ITRecursos;
import jdbc.dao.ITTipoRecursos;
import model.EstadoModulos;
import model.EstadosRecursos;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import model.TipoRecursos;
import persistencias.CivEstadomodulos;
import persistencias.CivEstadorecursos;
import persistencias.CivModulos;
import persistencias.CivPerfiles;
import persistencias.CivRecursos;
import persistencias.CivTiporecursos;

/**
 *
 * @author Admin
 */
public class GestionModulosImpBO implements GestionModulosBO, Serializable {

    private ITModulos modulosDAO;
    private ITRecursos recursosDAO;
    private ITLogin loginDAO;
    private ITPerfiles perfilesDAO;
    private ITTipoRecursos tipoRecursosDAO;
    private ITEstadoRecursos estadosRecursosDAO;
    private ITEstadoModulos estadosModulosDAO;

    @Override
    public void listarperfiles(BeanGestionModulos bean) throws Exception {
        List<CivPerfiles> listaCivPefiles = getPerfilesDAO().getAllPerfiles();
        for (CivPerfiles civPerfiles : listaCivPefiles) {
            Perfiles perfil = new Perfiles();
            perfil.setId(civPerfiles.getPerfId().intValue());
            perfil.setNombre(civPerfiles.getPerfNombre());
            bean.getListaperfil().add(perfil);

        }
    }

    @Override
    public void llenarDatos(BeanGestionModulos bean) throws Exception {
        List<CivModulos> listaCivModulos = getModulosDAO().getAll();
        List<CivTiporecursos> listCivTipoRecurso = getTipoRecursosDAO().listAll();
        for (CivTiporecursos civTipoRecurso : listCivTipoRecurso) {
            TipoRecursos tipoRecursos = new TipoRecursos();
            tipoRecursos.setCodigo(civTipoRecurso.getTiprecCodigo().intValue());
            tipoRecursos.setDescripcion(civTipoRecurso.getTiprecDescripcion());
            tipoRecursos.setId(civTipoRecurso.getTiprecId().intValue());
            bean.getListTipoRecursos().add(tipoRecursos);
        }

        int registro = 0;
        for (CivModulos civModulos : listaCivModulos) {
            Modulo modulo = new Modulo();
            modulo.setId(civModulos.getModId().intValue());
            modulo.setNombre(civModulos.getModNombre());
            modulo.setEstado(civModulos.getCivEstadomodulos().getEstmodId().intValue());
            modulo.setFechaFinal(civModulos.getModFechafin());
            modulo.setFechaInicial(civModulos.getModFechaini());
            modulo.setIcon(civModulos.getIcon());
            bean.getListamodulos().add(modulo);
            List<CivRecursos> listaCivRecursos = getRecursosDAO().getRecursosByModulo(civModulos.getModId().intValue());
            if (listaCivRecursos != null) {
                for (CivRecursos civRecurso : listaCivRecursos) {
                    Recurso recurso = new Recurso();
                    recurso.setCodigo(civRecurso.getRecId().intValue());
                    recurso.setDescripcion(civRecurso.getRecDescripcion());
                    recurso.setNombre(civRecurso.getRecNombre());
                    recurso.setFechaInicial(civRecurso.getRecFechainicial());
                    recurso.setFechaFinal(civRecurso.getRecFechafin());
                    EstadosRecursos estadosRecursos = new EstadosRecursos();
                    estadosRecursos.setId(civRecurso.getCivEstadorecursos().getEstrecId().longValue());
                    estadosRecursos.setDescripcion(civRecurso.getCivEstadorecursos().getEstrecDescripcion());
                    estadosRecursos.setFechaInicial(civRecurso.getCivEstadorecursos().getEstrecFechainicial());
                    estadosRecursos.setFechaFinal(civRecurso.getCivEstadorecursos().getEstrecFechafinal());
                    recurso.setEstadosRecursos(estadosRecursos);
                    recurso.setCarpeta(civRecurso.getRecCarpeta());
                    recurso.setModuloId(civRecurso.getCivModulos().getModId().intValue());
                    recurso.setPerfilId(civRecurso.getCivPerfiles().getPerfId().intValue());
                    bean.getListamodulos().get(registro).getListRecurso().add(recurso);
                }
            }
            registro++;
        }
        
        //llenar combo gestiopn modulos estados 
        List<CivEstadomodulos> listaEstadomodulos = getEstadosModulosDAO().listAll();
        for (CivEstadomodulos listaEstadoModulo : listaEstadomodulos) {
            EstadoModulos estadoModulos = new EstadoModulos();
            estadoModulos.setId(listaEstadoModulo.getEstmodId().longValue());
            estadoModulos.setDescripcion(listaEstadoModulo.getEstmodDescripcion());
            estadoModulos.setFechaInicial(listaEstadoModulo.getEstmodFechainicial());
            estadoModulos.setFechaFinal(listaEstadoModulo.getEstmodFechafinal());
            bean.getListaEstadoMudulos().add(estadoModulos);
            
            
        }
       
        
    }

    @Override
    public void actualizarRecurso(BeanGestionModulos bean) throws Exception {

        CivRecursos recursos = new CivRecursos();
        CivModulos civModulos = new CivModulos();
        civModulos.setModId(new BigDecimal(bean.getRegistroRecurso().getModuloId()));
        CivPerfiles civPerfiles = new CivPerfiles();
        civPerfiles = getPerfilesDAO().consultarPerfilById(bean.getRegistroRecurso().getPerfilId());
        recursos.setRecId(BigDecimal.valueOf(bean.getRegistroRecurso().getCodigo()));
        recursos.setRecNombre(bean.getRegistroRecurso().getNombre());
        recursos.setRecDescripcion(bean.getRegistroRecurso().getDescripcion());
        recursos.setRecFechainicial(bean.getRegistroRecurso().getFechaInicial());
        recursos.setRecFechafin(bean.getRegistroRecurso().getFechaFinal());
        recursos.setCivEstadorecursos(getEstadosRecursosDAO().consultarEstadoRecursoById(bean.getIdEstadoSelecionado()));
        recursos.setRecCarpeta(bean.getRegistroRecurso().getCarpeta());
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        recursos.setCivTiporecursos(tipoRecurso);
        recursos.setCivModulos(civModulos);
        recursos.setCivPerfiles(civPerfiles);
        getRecursosDAO().update(recursos);
        bean.setRegistroRecurso(new Recurso());

    }

    @Override
    public void guardarRecurso(BeanGestionModulos bean) throws Exception {

        CivRecursos recursos = new CivRecursos();
        CivModulos civModulos = new CivModulos();
        CivEstadorecursos civEstadorecursos = getEstadosRecursosDAO().consultarEstadoRecursoById(bean.getIdEstadoSelecionado());
        civModulos.setModId(new BigDecimal(bean.getRegistroRecurso().getModuloId()));
        CivPerfiles civPerfiles = new CivPerfiles();
        civPerfiles = getPerfilesDAO().consultarPerfilById(bean.getRegistroRecurso().getPerfilId());
        recursos.setRecId(BigDecimal.valueOf(bean.getRegistroRecurso().getCodigo()));
        recursos.setRecNombre(bean.getRegistroRecurso().getNombre());
        recursos.setRecDescripcion(bean.getRegistroRecurso().getDescripcion());
        recursos.setRecFechainicial(bean.getRegistroRecurso().getFechaInicial());
        recursos.setRecFechafin(bean.getRegistroRecurso().getFechaFinal());
        recursos.setCivModulos(civModulos);
        recursos.setCivEstadorecursos(civEstadorecursos);
        recursos.setRecCarpeta(bean.getRegistroRecurso().getCarpeta());
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        recursos.setCivTiporecursos(tipoRecurso);
        recursos.setCivModulos(civModulos);
        recursos.setCivPerfiles(civPerfiles);
        getRecursosDAO().insert(recursos);
        bean.setRegistroRecurso(new Recurso());
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarRecurso(BeanGestionModulos bean) throws Exception {
        CivRecursos civrecurso = new CivRecursos();
        civrecurso.setRecId(BigDecimal.valueOf(bean.getRegistroRecurso().getCodigo()));
        civrecurso.setRecFechafin(bean.getRegistroRecurso().getFechaFinal());
        civrecurso.setCivEstadorecursos(getEstadosRecursosDAO().consultarEstadoRecursoById(2));
        getRecursosDAO().update(civrecurso);

    }

    @Override
    public void guardar(BeanGestionModulos bean) throws Exception {
        CivModulos civmodulos = new CivModulos();
        CivEstadomodulos civEstadomodulos =  getEstadosModulosDAO().consultarModuloById(bean.getIdEstadoSelecionado());
        civmodulos.setModNombre(bean.getRegistromodulo().getNombre());
        civmodulos.setModId(BigDecimal.valueOf(bean.getRegistromodulo().getId()));
        civmodulos.setModFechaini(bean.getRegistromodulo().getFechaInicial());
        civmodulos.setModFechafin(bean.getRegistromodulo().getFechaFinal());
        civmodulos.setCivEstadomodulos(civEstadomodulos);
        civmodulos.setIcon(bean.getRegistromodulo().getIcon());
        getModulosDAO().insert(civmodulos);
    }

    /**
     * @return the modulosDAO
     */
    public ITModulos getModulosDAO() {
        return modulosDAO;
    }

    /**
     * @param modulosDAO the modulosDAO to set
     */
    public void setModulosDAO(ITModulos modulosDAO) {
        this.modulosDAO = modulosDAO;
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
     * @return the recursosDAO
     */
    public ITRecursos getRecursosDAO() {
        return recursosDAO;
    }

    /**
     * @param recursosDAO the recursosDAO to set
     */
    public void setRecursosDAO(ITRecursos recursosDAO) {
        this.recursosDAO = recursosDAO;
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
     * @return the tipoRecursosDAO
     */
    public ITTipoRecursos getTipoRecursosDAO() {
        return tipoRecursosDAO;
    }

    /**
     * @param tipoRecursosDAO the tipoRecursosDAO to set
     */
    public void setTipoRecursosDAO(ITTipoRecursos tipoRecursosDAO) {
        this.tipoRecursosDAO = tipoRecursosDAO;
    }

    /**
     * @return the estadosRecursosDAO
     */
    public ITEstadoRecursos getEstadosRecursosDAO() {
        return estadosRecursosDAO;
    }

    /**
     * @param estadosRecursosDAO the estadosRecursosDAO to set
     */
    public void setEstadosRecursosDAO(ITEstadoRecursos estadosRecursosDAO) {
        this.estadosRecursosDAO = estadosRecursosDAO;
    }

    /**
     * @return the estadosModulosDAO
     */
    public ITEstadoModulos getEstadosModulosDAO() {
        return estadosModulosDAO;
    }

    /**
     * @param estadosModulosDAO the estadosModulosDAO to set
     */
    public void setEstadosModulosDAO(ITEstadoModulos estadosModulosDAO) {
        this.estadosModulosDAO = estadosModulosDAO;
    }

}
