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
import java.util.List;
import jdbc.dao.ITLogin;
import jdbc.dao.ITModulos;
import jdbc.dao.ITPerfiles;
import jdbc.dao.ITRecursos;
import jdbc.dao.ITUsuarios;
import model.Modulo;
import model.Perfiles;
import model.Recurso;
import model.Usuarios;
import persistencias.CivModulos;
import persistencias.CivPerfiles;
import persistencias.CivRecursos;
import persistencias.CivUsuarios;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class GestionRecursosImpBO implements GestionRecursosBO, Serializable {

    private ITLogin loginDAO;
    private ITModulos modulosDAO;
    private ITRecursos recursosDAO;
    private ITPerfiles perfilesDAO;

    @Override
    public void eliminarRegistro(BeanGestionRecursos bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BeanGestionRecursos bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(BeanGestionRecursos bean) throws Exception {
       CivRecursos recursos = new CivRecursos();
       CivModulos civModulos = new CivModulos();
       CivPerfiles civPerfiles = new CivPerfiles();
       recursos.setRecId(BigDecimal.valueOf(bean.getRecurso().getCodigo()));
       recursos.setRecNombre(bean.getRecurso().getNombre());
       recursos.setRecDescripcion(bean.getRecurso().getDescripcion());
       recursos.setRecFechainicial(bean.getRecurso().getFechaInicial());
       recursos.setRecFechafin(bean.getRecurso().getFechaFinal());
       recursos.setRecEstado(BigDecimal.valueOf(bean.getRecurso().getEstado()));
       recursos.setRecCarpeta(bean.getRecurso().getCarpeta());
       civModulos= getModulosDAO().getModuloID(bean.getRecurso().getModuloId());
       civPerfiles = getPerfilesDAO().consultarPerfilById(bean.getRecurso().getPerfilId());
       recursos.setRecTipo(new BigDecimal(bean.getRecurso().getTipo()));
       recursos.setCivModulos(civModulos);
       recursos.setCivPerfiles(civPerfiles);
       getRecursosDAO().insert(recursos);
       
    }

    @Override
    public void listarRecursos(BeanGestionRecursos bean) throws Exception {
        bean.setListRecurso(new ArrayList<>());
         List<CivRecursos> listadoCivRecursos = new ArrayList<>();
        switch (bean.getTipoBusqueda()) {
            case 1:
                listadoCivRecursos= getRecursosDAO().getRecursosByModulo(bean.getIdModuloSeleccionado());
                break;
            case 2:
                listadoCivRecursos=getRecursosDAO().getRecursosByIdPerfil(bean.getIdPerfil());
                break;
        }
        if(listadoCivRecursos != null || listadoCivRecursos.size() != 0){
        for (CivRecursos civRecurso : listadoCivRecursos) {
            Recurso recurso = new Recurso();
            recurso.setCodigo(civRecurso.getRecId().intValue());
            recurso.setDescripcion(civRecurso.getRecDescripcion());
            recurso.setNombre(civRecurso.getRecNombre());
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

}
