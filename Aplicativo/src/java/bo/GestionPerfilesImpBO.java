/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionPerfiles;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import jdbc.dao.ITLogin;
import jdbc.dao.ITModulos;
import jdbc.dao.ITPerfiles;
import jdbc.dao.ITRecursos;
import jdbc.dao.ITTipoRecursos;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import model.TipoRecursos;
import persistencias.CivModulos;
import persistencias.CivPerfiles;
import persistencias.CivRecursos;
import persistencias.CivTiporecursos;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class GestionPerfilesImpBO implements GestionPerfilesBO, Serializable {

    private ITLogin loginDAO;
    private ITPerfiles perfilesDAO;
    private ITRecursos recursosDAO;
    private ITModulos modulosDAO;
    private ITTipoRecursos tipoRecursosDAO;

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

    @Override
    public void saveRecurso(BeanGestionPerfiles bean) throws Exception {
        CivRecursos civRecursos = new CivRecursos();
        civRecursos.setRecNombre(bean.getRecursos().getNombre());
        civRecursos.setRecDescripcion(bean.getRecursos().getDescripcion());
        civRecursos.setRecFechainicial(bean.getRecursos().getFechaInicial());
        civRecursos.setRecFechafin(bean.getRecursos().getFechaFinal());
        //civRecursos.setRecEstado(new BigDecimal(bean.getRecursos().getEstado()));
        civRecursos.setRecCarpeta(bean.getRecursos().getCarpeta());
        civRecursos.setCivModulos(getModulosDAO().getModuloID(bean.getRecursos().getModuloId()));
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        civRecursos.setCivTiporecursos(tipoRecurso);
        civRecursos.setCivPerfiles(getPerfilesDAO().consultarPerfilById((int) bean.getIdPerfil()));
        getRecursosDAO().insert(civRecursos);

    }

    @Override
    public void llenarDatos(BeanGestionPerfiles bean) throws Exception {
        List<CivPerfiles> listCivPerfiles = getPerfilesDAO().getAllPerfiles();
        List<CivModulos> lisCivModulos = getModulosDAO().getAll();
        List<CivTiporecursos> listCivTipoRecurso = getTipoRecursosDAO().listAll();

        for (CivTiporecursos civTipoRecurso : listCivTipoRecurso) {
            TipoRecursos tipoRecursos = new TipoRecursos();
            tipoRecursos.setCodigo(civTipoRecurso.getTiprecCodigo().intValue());
            tipoRecursos.setDescripcion(civTipoRecurso.getTiprecDescripcion());
            tipoRecursos.setId(civTipoRecurso.getTiprecId().intValue());
            bean.getListTipoRecursos().add(tipoRecursos);
        }

        for (CivModulos civModulos : lisCivModulos) {
            Modulo modulo = new Modulo();
            modulo.setId(civModulos.getModId().intValue());
            modulo.setNombre(civModulos.getModNombre());
            bean.getListModulos().add(modulo);
        }
        int registro = 0;
        for (CivPerfiles listCivPerfile : listCivPerfiles) {

            Perfiles perfiles = new Perfiles();
            perfiles.setId(listCivPerfile.getPerfId().longValue());
            perfiles.setNombre(listCivPerfile.getPerfNombre());
            bean.getListPerfiles().add(perfiles);
            List<CivRecursos> listCivRecursos = getRecursosDAO().getRecursosByIdPerfil(listCivPerfile.getPerfId().intValue());
            if (listCivRecursos != null && listCivRecursos.size() > 0) {
                for (CivRecursos listCivRecurso : listCivRecursos) {
                    Recurso recurso = new Recurso();
                    recurso.setCodigo(listCivRecurso.getRecId().intValue());
                    recurso.setNombre(listCivRecurso.getRecNombre());
                    recurso.setDescripcion(listCivRecurso.getRecDescripcion());
                    recurso.setFechaInicial(listCivRecurso.getRecFechainicial());
                    recurso.setFechaFinal(listCivRecurso.getRecFechafin());
                    //recurso.setEstado(listCivRecurso.getRecEstado().intValue());
                    recurso.setCarpeta(listCivRecurso.getRecCarpeta());
                    //recurso.setModuloId(listCivRecurso.getCivModulos().getModId().intValue());
                    recurso.setTipo(listCivRecurso.getCivTiporecursos().getTiprecId().intValue());
                    recurso.setPerfilId(listCivRecurso.getCivPerfiles().getPerfId().intValue());
                    bean.getListPerfiles().get(registro).getListRecursos().add(recurso);
                }
            }
            registro++;
        }

    }

    @Override
    public void eliminarRegistro(BeanGestionPerfiles bean) throws Exception {
        CivRecursos civRecursos = new CivRecursos();
        civRecursos.setRecId(BigDecimal.valueOf(bean.getRecursos().getCodigo()));
        civRecursos.setRecNombre(bean.getRecursos().getNombre());
        civRecursos.setRecDescripcion(bean.getRecursos().getDescripcion());
        civRecursos.setRecFechainicial(bean.getRecursos().getFechaInicial());
        civRecursos.setRecFechafin(new Date());
        //civRecursos.setRecEstado(new BigDecimal(2));
        //civRecursos.setRecEstado(BigDecimal.valueOf(bean.getRecursos().getEstado()));
        civRecursos.setRecCarpeta(bean.getRecursos().getCarpeta());
        civRecursos.setCivModulos(getModulosDAO().getModuloID(bean.getRecursos().getModuloId()));
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        civRecursos.setCivTiporecursos(tipoRecurso);
        civRecursos.setCivPerfiles(getPerfilesDAO().consultarPerfilById(bean.getRecursos().getPerfilId()));
        getRecursosDAO().update(civRecursos);

    }

    @Override
    public void update(BeanGestionPerfiles bean) throws Exception {
        CivRecursos civRecursos = new CivRecursos();
        civRecursos.setRecId(BigDecimal.valueOf(bean.getRecursos().getCodigo()));
        civRecursos.setRecNombre(bean.getRecursos().getNombre());
        civRecursos.setRecDescripcion(bean.getRecursos().getDescripcion());
        civRecursos.setRecFechainicial(bean.getRecursos().getFechaInicial());
        civRecursos.setRecFechafin(bean.getRecursos().getFechaFinal());
//        civRecursos.setRecEstado(BigDecimal.valueOf(bean.getRecursos().getEstado()));
//        civRecursos.setRecEstado(BigDecimal.valueOf(bean.getRecursos().getEstado()));
        civRecursos.setRecCarpeta(bean.getRecursos().getCarpeta());
        civRecursos.setCivModulos(getModulosDAO().getModuloID(bean.getRecursos().getModuloId()));
        CivTiporecursos tipoRecurso = getTipoRecursosDAO().getTipoDocumento(new BigDecimal(bean.getIdTipoRecursoSeleccionado()));
        civRecursos.setCivTiporecursos(tipoRecurso);
        civRecursos.setCivPerfiles(getPerfilesDAO().consultarPerfilById(bean.getRecursos().getPerfilId()));
        getRecursosDAO().update(civRecursos);
    }

    @Override
    public void save(BeanGestionPerfiles bean) throws Exception {
        CivPerfiles civPerfiles = new CivPerfiles();
        civPerfiles.setPerfNombre(bean.getCivPerfiles().getNombre());
        getPerfilesDAO().insert(civPerfiles);
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

}
