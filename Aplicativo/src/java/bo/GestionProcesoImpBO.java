/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionModulos;
import beans.BeanGestionProceso;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jdbc.dao.ITEstadoProcesoJuridico;
import jdbc.dao.ITLogin;
import jdbc.dao.ITProcesosJuridicos;
import model.Estado;
import model.ProcesosJuridicos;
import persistencias.CivEstadoprocesojuridicos;
import persistencias.CivProcesosjuridicos;

/**
 *
 * @author pruebadesarrollo
 */
public class GestionProcesoImpBO implements GestionProcesoBO, Serializable{
    private ITLogin loginDAO;
    private ITProcesosJuridicos procesosJuridicosDAO;
    private ITEstadoProcesoJuridico estadoProcesoJuridicoDAO;
    
    
    
    @Override
    public void cargarListaProceso(BeanGestionProceso bean) throws Exception {
        List<CivProcesosjuridicos> ListCivProcesosjuridicos = getProcesosJuridicosDAO().listAll();
        for (CivProcesosjuridicos civProcesosjuridico : ListCivProcesosjuridicos) {
            ProcesosJuridicos procesoJuridico = new ProcesosJuridicos();
            procesoJuridico.setId(civProcesosjuridico.getProjuId().intValue());
            procesoJuridico.setNombre(civProcesosjuridico.getProjuNombre());
            procesoJuridico.setFechaInicial(civProcesosjuridico.getProjuFechainicial());
            procesoJuridico.setFechaInicial(civProcesosjuridico.getProjuFechafinal());
            procesoJuridico.setEstado(civProcesosjuridico.getCivEstadoprocesojuridicos().getEstproId().intValue());
            bean.getProcesoList().add(procesoJuridico);
        }
    }
    
    @Override
    public void guardarProcesoJuridico(BeanGestionProceso bean) throws Exception {
        CivProcesosjuridicos civProcesosjuridicos = new CivProcesosjuridicos();
        civProcesosjuridicos.setProjuId(BigDecimal.valueOf(bean.getRegistroProcesoJuridico().getId()));
        civProcesosjuridicos.setProjuNombre(bean.getRegistroProcesoJuridico().getNombre());
        CivEstadoprocesojuridicos civEstadoprocesojuridicos = getEstadoProcesoJuridicoDAO().consultaById((int)bean.getRegistroProcesoJuridico().getEstado());
        civProcesosjuridicos.setCivEstadoprocesojuridicos(civEstadoprocesojuridicos);
        civProcesosjuridicos.setProjuFechainicial(bean.getRegistroProcesoJuridico().getFechaInicial());
        civProcesosjuridicos.setProjuFechafinal(bean.getRegistroProcesoJuridico().getFechaFinal());
        getProcesosJuridicosDAO().insert(civProcesosjuridicos);
    }
    
    @Override
    public void cargarEstadoProceso(BeanGestionProceso bean) throws Exception {
        List<CivEstadoprocesojuridicos> ListcivEstadoprocesojuridicoses  = getEstadoProcesoJuridicoDAO().listAll();
       for (CivEstadoprocesojuridicos civEstadoprocesojuridicos : ListcivEstadoprocesojuridicoses) {
           Estado estadoProcesoJuridico = new Estado();
           estadoProcesoJuridico.setId(civEstadoprocesojuridicos.getEstproId().intValue());
           estadoProcesoJuridico.setDescripcion(civEstadoprocesojuridicos.getEstproDescripcion());
           
           bean.getEstadoProceso().add(estadoProcesoJuridico);
       }
    }
    @Override
    public void actualizarProceso(BeanGestionProceso bean) throws Exception {
        CivProcesosjuridicos civProcesosjuridicos = getProcesosJuridicosDAO().getConcepto((int)bean.getRegistroProcesoJuridico().getId());
        civProcesosjuridicos.setProjuNombre(bean.getRegistroProcesoJuridico().getNombre());
        civProcesosjuridicos.setCivEstadoprocesojuridicos(getEstadoProcesoJuridicoDAO().consultaById((int)bean.getRegistroProcesoJuridico().getEstado()));
        civProcesosjuridicos.setProjuFechainicial(bean.getRegistroProcesoJuridico().getFechaInicial());
        civProcesosjuridicos.setProjuFechafinal(bean.getRegistroProcesoJuridico().getFechaFinal());
        
        getProcesosJuridicosDAO().update(civProcesosjuridicos);
    }
    @Override
    public void eliminarRegistro(BeanGestionProceso bean) throws Exception {
        
        CivEstadoprocesojuridicos civEstadoprocesojuridicos = new CivEstadoprocesojuridicos();
        civEstadoprocesojuridicos.setEstproId(BigDecimal.ZERO);
    }

    
    /**
     * @return the loginDAO
//     */
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
     * @return the procesosJuridicosDAO
     */
    public ITProcesosJuridicos getProcesosJuridicosDAO() {
        return procesosJuridicosDAO;
    }

    /**
     * @param procesosJuridicosDAO the procesosJuridicosDAO to set
     */
    public void setProcesosJuridicosDAO(ITProcesosJuridicos procesosJuridicosDAO) {
        this.procesosJuridicosDAO = procesosJuridicosDAO;
    }

    /**
     * @return the estadoProcesoJuridicoDAO
     */
    public ITEstadoProcesoJuridico getEstadoProcesoJuridicoDAO() {
        return estadoProcesoJuridicoDAO;
    }

    /**
     * @param estadoProcesoJuridicoDAO the estadoProcesoJuridicoDAO to set
     */
    public void setEstadoProcesoJuridicoDAO(ITEstadoProcesoJuridico estadoProcesoJuridicoDAO) {
        this.estadoProcesoJuridicoDAO = estadoProcesoJuridicoDAO;
    }

    

    

    

    

    
    
}
