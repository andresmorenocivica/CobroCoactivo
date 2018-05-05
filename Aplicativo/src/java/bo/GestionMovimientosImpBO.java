/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionMovimientos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jdbc.dao.ITDetalleProcesosJuridicos;
import jdbc.dao.ITDeudas;
import jdbc.dao.ITLogin;
import jdbc.dao.ITMovimiento;
import jdbc.dao.ITProcesosJuridicos;
import model.DetalleProcesoJuridico;
import model.Deudas;
import model.ProcesosJuridicos;
import persistencias.CivDetalleProcesojuridico;
import persistencias.CivDeudas;
import persistencias.CivMovimientos;
import persistencias.CivProcesosjuridicos;

/**
 *
 * @author jvergara
 */
public class GestionMovimientosImpBO implements GestionMovimientosBO, Serializable {

    private ITLogin loginDAO;
    private ITProcesosJuridicos procesosJuridicosDAO;
    private ITDetalleProcesosJuridicos detalleProcesosJuridicosDAO;
    private ITDeudas deudasDAO;
    private ITMovimiento movimientoDAO;

    @Override
    public void cargarListaProceso(BeanGestionMovimientos bean) throws Exception {
        List<CivProcesosjuridicos> listaCivProcesosJuridicos = getProcesosJuridicosDAO().listAll();
        for (CivProcesosjuridicos listaCivProcesosJuridico : listaCivProcesosJuridicos) {
            ProcesosJuridicos procesosJuridicos = new ProcesosJuridicos();
            procesosJuridicos.setId(listaCivProcesosJuridico.getProjuId().longValue());
            procesosJuridicos.setNombre(listaCivProcesosJuridico.getProjuNombre());
            procesosJuridicos.setDetalleProcesoJuridico(llenarDetalleProceso(listaCivProcesosJuridico.getProjuId().longValue()));
            bean.getListaProcesoJuridisco().add(procesosJuridicos);
        }

    }

    @Override
    public List<DetalleProcesoJuridico> llenarDetalleProceso(long id) throws Exception {
        List<Deudas> lisDeudasModel = listaDeDeudas(id);
        DetalleProcesoJuridico detalleProcesoJuridico = new DetalleProcesoJuridico();
        List<CivDetalleProcesojuridico> listaDetalleProcesoJuridico = getDetalleProcesosJuridicosDAO().listarDetalleUsuarioBy(id);
        List<DetalleProcesoJuridico> detalleProcesoJuridicos = new ArrayList<>();
        int registro = 0;
        for (CivDetalleProcesojuridico civDetalleProcesojuridico : listaDetalleProcesoJuridico) {
            detalleProcesoJuridico.setId(civDetalleProcesojuridico.getDetprojuId().longValue());
            detalleProcesoJuridico.setNombre(civDetalleProcesojuridico.getDeprojuNombre());
            detalleProcesoJuridicos.add(detalleProcesoJuridico);
            for (Deudas deudas : lisDeudasModel) {
                CivMovimientos civMovimientos = new CivMovimientos();
                if (registro == 0) {
                    civMovimientos = getMovimientoDAO().getMovimientoByIdDeuda((int) deudas.getId());
                    if (civMovimientos == null) {
                        detalleProcesoJuridicos.get(registro).getListaDeudas().add(deudas);
                    }
                } else {
                    if (detalleProcesoJuridicos.get(registro).getListaDeudas().set(registro, deudas) == null) {
                        detalleProcesoJuridicos.get(registro).getListaDeudas().add(deudas);
                    }
                }

            }
            registro++;
        }

        return detalleProcesoJuridicos;
    }

    @Override
    public List<Deudas> listaDeDeudas(long idProceso) throws Exception {
        List<CivDeudas> listaDeDeudasPersistencia = getDeudasDAO().getListDeudasbyProcesos((int) idProceso);
        List<Deudas> listaDeDeudasModel = new ArrayList<>();
        for (CivDeudas civDeudas : listaDeDeudasPersistencia) {
            Deudas deudas = new Deudas();
            deudas.setId(civDeudas.getDeuId().longValue());
            deudas.setFecha(civDeudas.getDeuFecha());
            deudas.setEstado(civDeudas.getCivEstadodeudas().getEstdeuId().intValue());
            deudas.setTipo(civDeudas.getCivTipodeuda().getTipdeuId().intValue());
            deudas.setReferencia(civDeudas.getDeuReferencia());
            deudas.setValor(civDeudas.getDeuValor().intValue());
            deudas.setSaldo(civDeudas.getDeuSaldo().intValue());
            deudas.setIdPersona(civDeudas.getCivPersonas().getPerId().intValue());
            deudas.setIdUsuario(civDeudas.getCivUsuarios().getUsuId().intValue());
            deudas.setIdProcesoJuridico(civDeudas.getCivProcesosjuridicos().getProjuId().longValue());
            deudas.setFechaDeuda(civDeudas.getDeuFechadeuda());
            listaDeDeudasModel.add(deudas);
        }

        return listaDeDeudasModel;
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
     * @return the movimientoDAO
     */
    public ITMovimiento getMovimientoDAO() {
        return movimientoDAO;
    }

    /**
     * @param movimientoDAO the movimientoDAO to set
     */
    public void setMovimientoDAO(ITMovimiento movimientoDAO) {
        this.movimientoDAO = movimientoDAO;
    }

}
