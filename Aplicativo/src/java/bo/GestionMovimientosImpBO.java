/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionMovimientos;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import jdbc.dao.ITDetalleProcesosJuridicos;
import jdbc.dao.ITDeudas;
import jdbc.dao.ITLogin;
import jdbc.dao.ITMovimiento;
import jdbc.dao.ITPersonas;
import jdbc.dao.ITProcesosJuridicos;
import jdbc.dao.ITUsuarios;
import model.DetalleProcesoJuridico;
import model.Deudas;
import model.Movimientos;
import model.ProcesosJuridicos;
import persistencias.CivDetalleProcesojuridico;
import persistencias.CivDeudas;
import persistencias.CivEstadomovimiento;
import persistencias.CivMovimientos;
import persistencias.CivPersonas;
import persistencias.CivProcesosjuridicos;
import persistencias.CivUsuarios;
import utility.DateUtility;

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
    private ITPersonas personasDAO;
    private ITUsuarios usuariosDAO;
    

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
        List<CivDetalleProcesojuridico> listaDetalleProcesoJuridico = getDetalleProcesosJuridicosDAO().listarDetalleUsuarioBy(id);
        List<DetalleProcesoJuridico> detalleProcesoJuridicos = new ArrayList<>();
        for (CivDetalleProcesojuridico civDetalleProcesojuridico : listaDetalleProcesoJuridico) {
            DetalleProcesoJuridico detalleProcesoJuridico = new DetalleProcesoJuridico();
            detalleProcesoJuridico.setId(civDetalleProcesojuridico.getDetprojuId().longValue());
            detalleProcesoJuridico.setNombre(civDetalleProcesojuridico.getDeprojuNombre());
            detalleProcesoJuridicos.add(detalleProcesoJuridico);
        }

        for (Deudas deudas : lisDeudasModel) {
            List<CivMovimientos> civMovimientos = getMovimientoDAO().getlistMovimientosById((int) deudas.getId());
            
            CivPersonas personaDeudor =  getPersonasDAO().consultarPersonasById((int)deudas.getIdPersona());
            int dias = DateUtility.fechasDiferenciaEnDias(deudas.getFechaDeuda(), new Date());
            System.out.println("diferencias en dias "+ dias);
           
            
            if (civMovimientos.size() == 0) {
                detalleProcesoJuridicos.get(0).getListaDeudas().add(deudas);
            } else {
                int i = 0;
                for (CivMovimientos civMovimiento : civMovimientos) {
                    CivDetalleProcesojuridico civDetalleProcesojuridico = getDetalleProcesosJuridicosDAO().getDetalleProcesoJuridicoByid(civMovimientos.get(i).getDetpropId().intValue());
                    int index = IntStream.range(0, detalleProcesoJuridicos.size())
                            .filter(userInd -> detalleProcesoJuridicos.get(userInd).getNombre().equals(civDetalleProcesojuridico.getDeprojuNombre()))
                            .findFirst().orElse(-1);
                    if (index == detalleProcesoJuridicos.size() - 1) {

                    } else {
                        detalleProcesoJuridicos.get(index + 1).getListaDeudas().add(deudas);
                    }
                    i++;
                }
            }
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

    @Override
    public void movimientoDeudaCambiarFase(BeanGestionMovimientos bean) throws Exception {
        for (Deudas deuda : bean.getProcesosJuridicos().getDetalleProcesoJuridico().get(bean.getIndex()).getListaDeudas()) {
            if (deuda.isSelecionado()) {
                CivMovimientos civMovimientos = new CivMovimientos();
                civMovimientos.setDeuId(new BigDecimal(deuda.getId()));
                CivEstadomovimiento civEstadomovimiento = new CivEstadomovimiento();
                civEstadomovimiento.setEstmoviId(new BigDecimal(1));
                civMovimientos.setDetpropId(new BigDecimal(bean.getProcesosJuridicos().getDetalleProcesoJuridico().get(bean.getIndex()).getId()));
                civMovimientos.setUsuId(new BigDecimal(bean.getLoginBO().getID_Usuario()));
                civMovimientos.setCivEstadomovimiento(civEstadomovimiento);
                movimientoDAO.insert(civMovimientos);
            }
        }
    }
    
    @Override
    public void consultaMovimiento(BeanGestionMovimientos bean) throws Exception {
         bean.getDeudas().setListaMovimiento(new ArrayList<>());
        List<CivMovimientos> listMovimiento = getMovimientoDAO().buscarMovimientoDeudasPersonas((int) bean.getDeudas().getId());
        if (listMovimiento != null) {
            for (CivMovimientos civMovimientos : listMovimiento) {
                Movimientos movimiento = new Movimientos();
                movimiento.setDeuId(civMovimientos.getDeuId());
                movimiento.setMovId(civMovimientos.getMovId());
                movimiento.setDetpropId(civMovimientos.getDetpropId());
                CivDetalleProcesojuridico civDetalleProcesojuridico = getDetalleProcesosJuridicosDAO().getDetalleProcesoJuridicoByid(civMovimientos.getDetpropId().intValue());
                movimiento.setNombreDetalleProceso(civDetalleProcesojuridico.getDeprojuNombre());
                movimiento.setFechaInicial(civMovimientos.getFechaInicial());
                movimiento.setUsuId(civMovimientos.getUsuId());
                CivUsuarios civUsuarios = getUsuariosDAO().consultarUsuarioBy(civMovimientos.getUsuId().intValue());
                movimiento.setNombreUsuario(civUsuarios.getUsuNombre());
                bean.getDeudas().getListaMovimiento().add(movimiento);
            }
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
