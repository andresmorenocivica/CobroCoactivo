/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionParametros;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jdbc.dao.ITLogin;
import jdbc.dao.ITTablasParametricas;
import model.tablasParametricas;
import persistencias.CivTablasparametricas;

/**
 *
 * @author Admin
 */
public class GestionParametrosImpBO implements GestionParametrosBO, Serializable{

    private ITLogin loginDAO;
    private ITTablasParametricas tablasParametricasDAO;
    
    @Override
    public void llenarDatos(BeanGestionParametros bean) throws Exception {
        
        
        bean.setListaTablasParametricas(new ArrayList<>());
        tablasParametricas tablaParameticasModel = new tablasParametricas();
        getLoginDAO();
        
        List<CivTablasparametricas> list = getTablasParametricasDAO().listAll();
        for(CivTablasparametricas civTablasParametricas: list){
            tablaParameticasModel.setId(civTablasParametricas.getTabparId().intValue());
            tablaParameticasModel.setNombre(civTablasParametricas.getTabparNombre());
            tablaParameticasModel.setNombreTabla(civTablasParametricas.getTabparNombretabla());
            tablaParameticasModel.setEstado(civTablasParametricas.getTabparEstado().intValue());
            tablaParameticasModel.setFechaInicial(civTablasParametricas.getTabparFechainicial());
            tablaParameticasModel.setFechaFinal(civTablasParametricas.getTabparFechafinal());
            bean.getListaTablasParametricas().add(tablaParameticasModel);
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
     * @return the tablasParametricasDAO
     */
    public ITTablasParametricas getTablasParametricasDAO() {
        return tablasParametricasDAO;
    }

    /**
     * @param tablasParametricasDAO the tablasParametricasDAO to set
     */
    public void setTablasParametricasDAO(ITTablasParametricas tablasParametricasDAO) {
        this.tablasParametricasDAO = tablasParametricasDAO;
    }
    
}
