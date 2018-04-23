/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionModulos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jdbc.dao.ITLogin;
import jdbc.dao.ITModulos;
import jdbc.dao.ITRecursos;
import model.Modulo;
import model.Recurso;
import persistencias.CivModulos;
import persistencias.CivRecursos;

/**
 *
 * @author Admin
 */
public class GestionModulosImpBO implements GestionModulosBO, Serializable {

    private ITModulos modulosDAO;
    private ITRecursos recursosDAO;
    private ITLogin loginDAO;

    @Override
    public void llenarDatos(BeanGestionModulos bean) throws Exception {
        List<CivModulos> listaCivModulos = getModulosDAO().getAll();
        int registro = 0;
        for (CivModulos civModulos : listaCivModulos) {
            Modulo modulo = new Modulo();
            modulo.setId(civModulos.getModId().intValue());
            modulo.setNombre(civModulos.getModNombre());
            modulo.setEstado(civModulos.getModEstado().intValue());
            modulo.setFechaFinal(civModulos.getModFechafin());
            modulo.setFechaInicial(civModulos.getModFechaini());
            modulo.setIcon(civModulos.getIcon());
            bean.getListamodulos().add(modulo);
            List<CivRecursos> listaCivRecursos = getRecursosDAO().getRecursosByModulo(civModulos.getModId().intValue());
            for (CivRecursos civRecurso : listaCivRecursos) {
                Recurso recurso = new Recurso();
                recurso.setCodigo(civRecurso.getRecId().intValue());
                recurso.setDescripcion(civRecurso.getRecDescripcion());
                recurso.setNombre(civRecurso.getRecNombre());
                recurso.setFechaInicial(civRecurso.getRecFechainicial());
                recurso.setFechaFinal(civRecurso.getRecFechafin());
                recurso.setEstado(civRecurso.getRecEstado().intValue());
                recurso.setCarpeta(civRecurso.getRecCarpeta());
                recurso.setModuloId(civRecurso.getCivModulos().getModId().intValue());
                recurso.setPerfilId(civRecurso.getCivPerfiles().getPerfId().intValue());
                bean.getListamodulos().get(registro).getListRecurso().add(recurso);
            }
            registro++;
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

}
