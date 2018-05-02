/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionRecursos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jdbc.dao.ITEstadoRecursos;
import jdbc.dao.ITLogin;
import jdbc.dao.ITModulos;
import jdbc.dao.ITPerfiles;
import jdbc.dao.ITRecursos;
import jdbc.dao.ITTipoRecursos;
import model.EstadosRecursos;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import model.TipoRecursos;
import persistencias.CivEstadorecursos;
import persistencias.CivModulos;
import persistencias.CivPerfiles;
import persistencias.CivRecursos;
import persistencias.CivTiporecursos;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class GestionRecursosImpBO implements GestionRecursosBO, Serializable {

    private ITLogin loginDAO;
    private ITModulos modulosDAO;
    private ITRecursos recursosDAO;
    private ITPerfiles perfilesDAO;
    private ITTipoRecursos tipoRecursosDAO;
    private ITEstadoRecursos estadosRecursosDAO;

    @Override
    public void eliminarRegistro(BeanGestionRecursos bean) throws Exception {
        CivRecursos civRecursos = new CivRecursos();
        civRecursos = getRecursosDAO().getRecursosbyId(bean.getRecurso().getCodigo());
        civRecursos.setRecFechafin(new Date());
        civRecursos.setCivEstadorecursos(getEstadosRecursosDAO().consultarEstadoRecursoById(2));
        getRecursosDAO().update(civRecursos);
    }

    @Override
    public void update(BeanGestionRecursos bean) throws Exception {
        CivModulos civModulos = new CivModulos();
        civModulos = getModulosDAO().getModuloID(bean.getRecurso().getModuloId());
        CivPerfiles civPerfiles = new CivPerfiles();
        civPerfiles = getPerfilesDAO().consultarPerfilById(bean.getRecurso().getPerfilId());
        CivRecursos civRecursos = new CivRecursos();
        civRecursos.setRecId(BigDecimal.valueOf(bean.getRecurso().getCodigo()));
        civRecursos.setRecNombre(bean.getRecurso().getNombre());
        civRecursos.setRecDescripcion(bean.getRecurso().getDescripcion());
        civRecursos.setRecFechainicial(bean.getRecurso().getFechaInicial());
        civRecursos.setCivEstadorecursos(getEstadosRecursosDAO().consultarEstadoRecursoById(bean.getEstadoSelecionado()));
        civRecursos.setRecCarpeta(bean.getRecurso().getCarpeta());
        civRecursos.setCivModulos(civModulos);
        civRecursos.setCivPerfiles(civPerfiles);
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        civRecursos.setCivTiporecursos(tipoRecurso);
        getRecursosDAO().update(civRecursos);

    }

    @Override
    public void save(BeanGestionRecursos bean) throws Exception {
        CivRecursos recursos = new CivRecursos();
        CivModulos civModulos = new CivModulos();
        civModulos.setModId(new BigDecimal(bean.getRecurso().getModuloId()));
        CivPerfiles civPerfiles = new CivPerfiles();
        civPerfiles = getPerfilesDAO().consultarPerfilById(bean.getRecurso().getPerfilId());
        recursos.setRecId(BigDecimal.valueOf(bean.getRecurso().getCodigo()));
        recursos.setRecNombre(bean.getRecurso().getNombre());
        recursos.setRecDescripcion(bean.getRecurso().getDescripcion());
        recursos.setRecFechainicial(bean.getRecurso().getFechaInicial());
        recursos.setRecFechafin(bean.getRecurso().getFechaFinal());
        recursos.setCivEstadorecursos(getEstadosRecursosDAO().consultarEstadoRecursoById(bean.getEstadoSelecionado()));
        recursos.setRecCarpeta(bean.getRecurso().getCarpeta());
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        recursos.setCivTiporecursos(tipoRecurso);
        recursos.setCivModulos(civModulos);
        recursos.setCivPerfiles(civPerfiles);
        getRecursosDAO().insert(recursos);
        bean.setRecurso(new Recurso());
    }

    @Override
    public void listarRecursos(BeanGestionRecursos bean) throws Exception {
        bean.setListRecurso(new ArrayList<>());
        List<CivRecursos> listadoCivRecursos = new ArrayList<>();
        switch (bean.getTipoBusqueda()) {
            case 1:
                listadoCivRecursos = getRecursosDAO().getRecursosByModulo(bean.getIdModuloSeleccionado());
                break;
            case 2:
                listadoCivRecursos = getRecursosDAO().getRecursosByIdPerfil(bean.getIdPerfil());
                break;
        }
        if (listadoCivRecursos != null && listadoCivRecursos.size() != 0) {
            for (CivRecursos civRecurso : listadoCivRecursos) {
                Recurso recurso = new Recurso();
                EstadosRecursos estadosRecursos = new EstadosRecursos();
                estadosRecursos.setId(civRecurso.getCivEstadorecursos().getEstrecId().longValue());
                estadosRecursos.setDescripcion(civRecurso.getCivEstadorecursos().getEstrecDescripcion());
                estadosRecursos.setFechaInicial(civRecurso.getCivEstadorecursos().getEstrecFechainicial());
                estadosRecursos.setFechaFinal(civRecurso.getCivEstadorecursos().getEstrecFechafinal());
                recurso.setCodigo(civRecurso.getRecId().intValue());
                recurso.setDescripcion(civRecurso.getRecDescripcion());
                recurso.setNombre(civRecurso.getRecNombre());
                recurso.setFechaInicial(civRecurso.getRecFechainicial());
                recurso.setFechaFinal(civRecurso.getRecFechafin());
                recurso.setEstadosRecursos(estadosRecursos);
                recurso.setCarpeta(civRecurso.getRecCarpeta());
                recurso.setModuloId(civRecurso.getCivModulos().getModId().intValue());
                recurso.setPerfilId(civRecurso.getCivPerfiles().getPerfId().intValue());
                recurso.setTipo(civRecurso.getCivTiporecursos().getTiprecId().intValue());
                bean.getListRecurso().add(recurso);
            }
        }

    }

    @Override
    public void listarModulos(BeanGestionRecursos bean) throws Exception {
        List<CivModulos> lisCivModulos = getModulosDAO().getAll();
        for (CivModulos civModulos : lisCivModulos) {
            Modulo modulo = new Modulo();
            modulo.setId(civModulos.getModId().intValue());
            modulo.setNombre(civModulos.getModNombre());
            bean.getListMosulo().add(modulo);
        }
    }

    @Override
    public void listarPerfiles(BeanGestionRecursos bean) throws Exception {
        List<CivPerfiles> listPerfiles = getPerfilesDAO().getAllPerfiles();
        for (CivPerfiles civPerfiles : listPerfiles) {
            Perfiles perfiles = new Perfiles();
            perfiles.setId(civPerfiles.getPerfId().intValue());
            perfiles.setNombre(civPerfiles.getPerfNombre());
            bean.getListPerfiles().add(perfiles);

        }
    }

    @Override
    public void listarTipoRecursos(BeanGestionRecursos bean) throws Exception {
        List<CivTiporecursos> listTipoRecursos = getTipoRecursosDAO().listAll();
        for (CivTiporecursos civTipoRecurso : listTipoRecursos) {
            TipoRecursos tipoRecursos = new TipoRecursos();
            tipoRecursos.setCodigo(civTipoRecurso.getTiprecCodigo().intValue());
            tipoRecursos.setDescripcion(civTipoRecurso.getTiprecDescripcion());
            tipoRecursos.setId(civTipoRecurso.getTiprecId().intValue());
            bean.getListTipoRecursos().add(tipoRecursos);
        }
    }

    @Override
    public void listarEstadoRecursos(BeanGestionRecursos bean) throws Exception {
        List<CivEstadorecursos> listEstadoRecursos = getEstadosRecursosDAO().listAll();
        for (CivEstadorecursos listEstadoRecurso : listEstadoRecursos) {
            EstadosRecursos estadosRecursos = new EstadosRecursos();
            estadosRecursos.setId(listEstadoRecurso.getEstrecId().longValue());
            estadosRecursos.setDescripcion(listEstadoRecurso.getEstrecDescripcion());
            estadosRecursos.setFechaInicial(listEstadoRecurso.getEstrecFechainicial());
            estadosRecursos.setFechaFinal(listEstadoRecurso.getEstrecFechafinal());
            bean.getListaEstadoRecursos().add(estadosRecursos);
        }
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

    public ITPerfiles getPerfilesDAO() {
        return perfilesDAO;
    }

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

}
