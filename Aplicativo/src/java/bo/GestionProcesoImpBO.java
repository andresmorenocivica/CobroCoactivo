/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionProceso;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import jdbc.dao.ITDetalleProcesosJuridicos;
import jdbc.dao.ITDeudas;
import jdbc.dao.ITEstadoDetalleProcesoJuridico;
import jdbc.dao.ITEstadoProcesoJuridico;
import jdbc.dao.ITLogin;
import jdbc.dao.ITProcesosJuridicos;
import jdbc.dao.ITUsuarios;
import model.DetalleProcesoJuridico;
import model.Estado;
import model.ProcesosJuridicos;
import persistencias.CivDetalleProcesojuridico;
import persistencias.CivDeudas;
import persistencias.CivEstadodetalleProceso;
import persistencias.CivEstadoprocesojuridicos;
import persistencias.CivProcesosjuridicos;
import persistencias.CivUsuarios;

/**
 *
 * @author pruebadesarrollo
 */
public class GestionProcesoImpBO implements GestionProcesoBO, Serializable {

    private ITLogin loginDAO;
    private ITProcesosJuridicos procesosJuridicosDAO;
    private ITEstadoProcesoJuridico estadoProcesoJuridicoDAO;
    private ITDeudas deudasDAO;
    private ITDetalleProcesosJuridicos detalleProcesosJuridicosDAO;
    private ITEstadoDetalleProcesoJuridico estadoDetalleProcesoJuridicoDAO;
    private ITUsuarios usuariosDAO;

    @Override
    public void cargarListaProceso(BeanGestionProceso bean) throws Exception {
        List<CivProcesosjuridicos> ListCivProcesosjuridicos = getProcesosJuridicosDAO().listAll();
        int registro = 0;
        for (CivProcesosjuridicos civProcesosjuridico : ListCivProcesosjuridicos) {
            ProcesosJuridicos procesoJuridico = new ProcesosJuridicos();
            procesoJuridico.setId(civProcesosjuridico.getProjuId().intValue());
            procesoJuridico.setNombre(civProcesosjuridico.getProjuNombre());
            procesoJuridico.setFechaInicial(civProcesosjuridico.getProjuFechainicial());
            procesoJuridico.setFechaInicial(civProcesosjuridico.getProjuFechafinal());
            procesoJuridico.setEstado(civProcesosjuridico.getCivEstadoprocesojuridicos().getEstproId().intValue());
            bean.getProcesoList().add(procesoJuridico);
            List<CivDetalleProcesojuridico> ListaDetalleProcesojuridicos = getDetalleProcesosJuridicosDAO().listarDetalleUsuarioBy((int) procesoJuridico.getId());
            if (ListaDetalleProcesojuridicos != null && ListaDetalleProcesojuridicos.size() > 0) {
                for (CivDetalleProcesojuridico civDetalleProcesojuridico : ListaDetalleProcesojuridicos) {
                    DetalleProcesoJuridico detalleProcesoJuridico = new DetalleProcesoJuridico();
                    detalleProcesoJuridico.setId(civDetalleProcesojuridico.getDetprojuId().longValue());
                    detalleProcesoJuridico.setNombre(civDetalleProcesojuridico.getDeprojuNombre());
                    detalleProcesoJuridico.setIdProcesoJuridico(civDetalleProcesojuridico.getCivProcesosjuridicos().getProjuId().longValue());
                    detalleProcesoJuridico.setEstado(civDetalleProcesojuridico.getCivEstadodetalleProceso().getEstdetproId().intValue());
                    detalleProcesoJuridico.setDiaInicial(civDetalleProcesojuridico.getDetprojuDiainicial().intValue());
                    detalleProcesoJuridico.setDiaFinal(civDetalleProcesojuridico.getDetprojuDiafinal().intValue());
                    detalleProcesoJuridico.setFechainicial(civDetalleProcesojuridico.getDetprojuFechainicial());
                    detalleProcesoJuridico.setFechaFinal(civDetalleProcesojuridico.getDetprojuFechafinal());
                    detalleProcesoJuridico.setDireccion(true);
                    detalleProcesoJuridico.setIdReporte(1);
                    detalleProcesoJuridico.setTipo(1);
                    bean.getProcesoList().get(registro).getDetalleProcesoJuridico().add(detalleProcesoJuridico);
                }
            }
            registro++;
        }
    }

    @Override
    public void guardarProcesoJuridico(BeanGestionProceso bean) throws Exception {
        CivProcesosjuridicos civProcesosjuridicos = new CivProcesosjuridicos();
        civProcesosjuridicos.setProjuId(BigDecimal.valueOf(bean.getRegistroProcesoJuridico().getId()));
        civProcesosjuridicos.setProjuNombre(bean.getRegistroProcesoJuridico().getNombre());
        CivEstadoprocesojuridicos civEstadoprocesojuridicos = getEstadoProcesoJuridicoDAO().consultaById((int) bean.getRegistroProcesoJuridico().getEstado());
        civProcesosjuridicos.setCivEstadoprocesojuridicos(civEstadoprocesojuridicos);
        civProcesosjuridicos.setProjuFechainicial(bean.getRegistroProcesoJuridico().getFechaInicial());
        civProcesosjuridicos.setProjuFechafinal(bean.getRegistroProcesoJuridico().getFechaFinal());
        getProcesosJuridicosDAO().insert(civProcesosjuridicos);
    }

    @Override
    public void cargarEstadoProceso(BeanGestionProceso bean) throws Exception {
        List<CivEstadoprocesojuridicos> ListcivEstadoprocesojuridicoses = getEstadoProcesoJuridicoDAO().listAll();
        for (CivEstadoprocesojuridicos civEstadoprocesojuridicos : ListcivEstadoprocesojuridicoses) {
            Estado estadoProcesoJuridico = new Estado();
            estadoProcesoJuridico.setId(civEstadoprocesojuridicos.getEstproId().intValue());
            estadoProcesoJuridico.setDescripcion(civEstadoprocesojuridicos.getEstproDescripcion());

            bean.getEstadoProceso().add(estadoProcesoJuridico);
        }
    }

    @Override
    public void actualizarProceso(BeanGestionProceso bean) throws Exception {
        if (bean.getRegistroProcesoJuridico().getFechaFinal() != null) {
            List<CivDeudas> listDeudas = getDeudasDAO().getListDeudasbyProcesos((int) bean.getRegistroProcesoJuridico().getId());
            if (listDeudas.size() != 0) {
                //mensaje
                return;
            }
        }
        CivProcesosjuridicos civProcesosjuridicos = getProcesosJuridicosDAO().getConcepto((int) bean.getRegistroProcesoJuridico().getId());
        civProcesosjuridicos.setProjuNombre(bean.getRegistroProcesoJuridico().getNombre());
        civProcesosjuridicos.setCivEstadoprocesojuridicos(getEstadoProcesoJuridicoDAO().consultaById((int) bean.getRegistroProcesoJuridico().getEstado()));
        civProcesosjuridicos.setProjuFechainicial(bean.getRegistroProcesoJuridico().getFechaInicial());
        civProcesosjuridicos.setProjuFechafinal(bean.getRegistroProcesoJuridico().getFechaFinal());
        getProcesosJuridicosDAO().update(civProcesosjuridicos);
    }

    @Override
    public void eliminarRegistro(BeanGestionProceso bean) throws Exception {
        List<CivDeudas> listDeudas = getDeudasDAO().getListDeudasbyProcesos((int) bean.getRegistroProcesoJuridico().getId());
        if (listDeudas.size() == 0) {

            CivProcesosjuridicos civProcesosjuridicos = getProcesosJuridicosDAO().getConcepto((int) bean.getRegistroProcesoJuridico().getId());
            CivEstadoprocesojuridicos civEstadoprocesojuridicos = getEstadoProcesoJuridicoDAO().consultaById(2);
            civProcesosjuridicos.setCivEstadoprocesojuridicos(civEstadoprocesojuridicos);
            getProcesosJuridicosDAO().update(civProcesosjuridicos);
        } else {
            //Debe ir el mesaje de la validacion
        }
    }

    @Override
    public void guardarFases(BeanGestionProceso bean) throws Exception {
        CivDetalleProcesojuridico civDetalleProcesojuridico = new CivDetalleProcesojuridico();
        civDetalleProcesojuridico.setDetprojuId(BigDecimal.valueOf(bean.getDetalleProcesoJuridico().getId()));
        civDetalleProcesojuridico.setDeprojuNombre(bean.getDetalleProcesoJuridico().getNombre());
        CivEstadodetalleProceso civEstadodetalleProceso = getEstadoDetalleProcesoJuridicoDAO().consultarById(bean.getDetalleProcesoJuridico().getEstado());
        civDetalleProcesojuridico.setCivEstadodetalleProceso(civEstadodetalleProceso);
        civDetalleProcesojuridico.setDetprojuDiainicial(BigDecimal.valueOf(bean.getDetalleProcesoJuridico().getDiaInicial()));
        civDetalleProcesojuridico.setDetprojuDiafinal(BigDecimal.valueOf(bean.getDetalleProcesoJuridico().getDiaFinal()));
        civDetalleProcesojuridico.setDetprojuDireccion(false);
        civDetalleProcesojuridico.setDetprojuFechainicial(bean.getDetalleProcesoJuridico().getFechainicial());
        CivProcesosjuridicos civProcesosjuridicos = getProcesosJuridicosDAO().getConcepto((int)bean.getDetalleProcesoJuridico().getIdProcesoJuridico());
        civDetalleProcesojuridico.setCivProcesosjuridicos(civProcesosjuridicos);
        CivUsuarios civUsuarios = getUsuariosDAO().consultarUsuarioBy(Integer.parseInt(bean.getLoginBO().getID_Usuario()));
        civDetalleProcesojuridico.setCivUsuarios(civUsuarios);
        getDetalleProcesosJuridicosDAO().insert(civDetalleProcesojuridico);
    }
    
    @Override
    public void actulizarFases(BeanGestionProceso bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the loginDAO //
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

    /**
     * @return the deudasDAO
     */
    public ITDeudas getDeudasDAO() {
        return deudasDAO;
    }

    /**
     * @param deudasDAO the deudasDAO to set
     */
    public void setDeudasDAO(ITDeudas deudasDAO) {
        this.deudasDAO = deudasDAO;
    }

    /**
     * @return the detalleProcesosJuridicosDAO
     */
    public ITDetalleProcesosJuridicos getDetalleProcesosJuridicosDAO() {
        return detalleProcesosJuridicosDAO;
    }

    /**
     * @param detalleProcesosJuridicosDAO the detalleProcesosJuridicosDAO to set
     */
    public void setDetalleProcesosJuridicosDAO(ITDetalleProcesosJuridicos detalleProcesosJuridicosDAO) {
        this.detalleProcesosJuridicosDAO = detalleProcesosJuridicosDAO;
    }

    /**
     * @return the estadoDetalleProcesoJuridicoDAO
     */
    public ITEstadoDetalleProcesoJuridico getEstadoDetalleProcesoJuridicoDAO() {
        return estadoDetalleProcesoJuridicoDAO;
    }

    /**
     * @param estadoDetalleProcesoJuridicoDAO the estadoDetalleProcesoJuridicoDAO to set
     */
    public void setEstadoDetalleProcesoJuridicoDAO(ITEstadoDetalleProcesoJuridico estadoDetalleProcesoJuridicoDAO) {
        this.estadoDetalleProcesoJuridicoDAO = estadoDetalleProcesoJuridicoDAO;
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

    

}
