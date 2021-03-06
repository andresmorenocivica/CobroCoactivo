package bo;

import beans.BeanGestionPersonas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import jdbc.dao.ITDatosPersonas;
import jdbc.dao.ITDetalleProcesosJuridicos;
import jdbc.dao.ITDeudas;
import jdbc.dao.ITEstadosPersona;
import jdbc.dao.ITLogin;
import jdbc.dao.ITMovimiento;
import jdbc.dao.ITPersonas;
import jdbc.dao.ITTipoDocumento;
import jdbc.dao.ITUsuarios;
import model.DatosPersona;
import model.Deudas;
import model.EstadoPersona;
import model.Movimientos;
import model.Personas;
import model.TipoDato;
import model.TipoDocumentos;
import persistencias.CivDatospersona;
import persistencias.CivDetalleProcesojuridico;
import persistencias.CivDeudas;
import persistencias.CivEstadopersona;
import persistencias.CivMovimientos;
import persistencias.CivPersonas;
import persistencias.CivTipodatopersona;
import persistencias.CivTipodocumentos;
import persistencias.CivUsuarios;

/**
 *
 * @author jvergara
 */
public class GestionPersonasImpBO implements GestionPersonasBO, Serializable {

    private ITLogin loginDAO;
    private ITTipoDocumento tiposDocumentosDAO;
    private ITPersonas personasDAO;
    private ITDatosPersonas datosPersonasDAO;
    private ITDeudas deudasDAO;
    private ITEstadosPersona estadosPersonaDAO;
    private ITMovimiento movimientoDAO;
    private ITDetalleProcesosJuridicos detalleProcesosJuridicosDAO;
    private ITUsuarios usuariosDAO;

    @Override
    public void llenarDatos(BeanGestionPersonas bean) throws Exception {
        List<CivTipodocumentos> listCivTipoDocumentos = getTiposDocumentosDAO().listAll();
        for (CivTipodocumentos listCivTipoDocumento : listCivTipoDocumentos) {
            TipoDocumentos tipoDocumentos = new TipoDocumentos();
            tipoDocumentos.setId(listCivTipoDocumento.getTipdocId().longValue());
            tipoDocumentos.setNombre(listCivTipoDocumento.getTipdocNombre());
            bean.getListTipoDocumento().add(tipoDocumentos);
        }
    }

    @Override
    public void buscarDatosPersonas(BeanGestionPersonas bean) throws Exception {
        List<CivDatospersona> ListCivDatosPersona = getDatosPersonasDAO().listDatosPersonas((int) bean.getDetallePersona().getId());
        for (CivDatospersona civDatospersona : ListCivDatosPersona) {
            DatosPersona datoPersona = new DatosPersona();
            CivTipodatopersona civTipodatopersona = civDatospersona.getCivTipodatopersona();
            TipoDato tipoDato = new TipoDato();
            tipoDato.setCodigo(civTipodatopersona.getTipdatperId().longValue());
            tipoDato.setDescripcion(civTipodatopersona.getTipdatperDescripcion());
            EstadoPersona estadoPersona = new EstadoPersona();
            estadoPersona.setId(civTipodatopersona.getCivEstadotipodatopersona().getEsttipdatId().longValue());
            estadoPersona.setDescripcion(civTipodatopersona.getCivEstadotipodatopersona().getEsttipdatDescripcion());
            estadoPersona.setFechaInicial(civTipodatopersona.getCivEstadotipodatopersona().getEsttipdatFechainicial());
            estadoPersona.setFechaFinal(civTipodatopersona.getCivEstadotipodatopersona().getEsttipdatFechafinal());
            tipoDato.setEstadoPersona(estadoPersona);
            tipoDato.setFechaInicial(civTipodatopersona.getTipdatperFechainical());
            tipoDato.setFechaFinal(civTipodatopersona.getTipdatperFechafinal());
            tipoDato.setNombreCorto(civTipodatopersona.getTipdatperNombrecorto());
            tipoDato.setCodigo(civTipodatopersona.getTipdatperCodigo().longValue());
            datoPersona.setId(civDatospersona.getDatperId().longValue());
            datoPersona.setTipoDatoPersona(tipoDato);
            datoPersona.setDescricion(civDatospersona.getDatperDescripcion());
            datoPersona.setEstadoPersona(estadoPersona);
            datoPersona.setFechaInicial(civDatospersona.getDatperFechainicial());
            datoPersona.setFechaFinal(civDatospersona.getDatperFechafinal());
            bean.getDetallePersona().getListaDatosPersona().add(datoPersona);

        }

    }

    @Override
    public void buscarMovimientoDeudaPersona(BeanGestionPersonas bean) throws Exception {
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

    @Override
    public void buscarHistorialDeudasPersonas(BeanGestionPersonas bean) throws Exception {
        List<CivDeudas> listDeudas = getDeudasDAO().buscarHistorialDeudasPersonas((int) bean.getDetallePersona().getId());
        for (CivDeudas listDeuda : listDeudas) {
            Deudas deuda = new Deudas();
            deuda.setId(listDeuda.getDeuId().longValue());
            deuda.setFecha(listDeuda.getDeuFecha());
            deuda.setEstado(listDeuda.getCivEstadodeudas().getEstdeuId().intValue());
            deuda.setIdPersona(listDeuda.getCivTipodeuda().getTipdeuId().longValue());
            deuda.setReferencia(listDeuda.getDeuReferencia());
            deuda.setValor(listDeuda.getDeuValor().intValue());
            deuda.setSaldo(listDeuda.getDeuSaldo().intValue());
            deuda.setIdPersona(listDeuda.getCivPersonas().getPerId().intValue());
            deuda.setIdUsuario(listDeuda.getCivUsuarios().getUsuId().intValue());
            deuda.setIdProcesoJuridico(listDeuda.getCivProcesosjuridicos().getProjuId().intValue());
            deuda.setFechaDeuda(listDeuda.getDeuFecha());
            bean.getDetallePersona().getListaDeudas().add(deuda);

        }

    }

    @Override
    public void consultarPorNumero(BeanGestionPersonas bean) throws Exception {
        CivPersonas civPersonas = new CivPersonas();
        Personas personas = new Personas();
        civPersonas = getPersonasDAO().consultarPersonasByDocumento(bean.getIdDocumentoSelecionado(), bean.getNumero());
        if (civPersonas == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "no se encontro la persona en el sistema", null));

        }
        bean.setListPersonas(new ArrayList<>());
        personas.setId(civPersonas.getPerId().longValue());
        TipoDocumentos tipoDocumentosPersonas = new TipoDocumentos();
        CivTipodocumentos civTipodocumentosPersona = getTiposDocumentosDAO().getTipoDocumento(civPersonas.getCivTipodocumentos().getTipdocCodigo());
        tipoDocumentosPersonas.setCodigo(civTipodocumentosPersona.getTipdocCodigo().intValue());
        tipoDocumentosPersonas.setEstado(civTipodocumentosPersona.getCivEstadotipodocumentos().getEsttipdocId().intValue());
        tipoDocumentosPersonas.setFechaFinal(civTipodocumentosPersona.getTipdocFechafinal());
        tipoDocumentosPersonas.setNombre(civTipodocumentosPersona.getTipdocNombre());
        tipoDocumentosPersonas.setNombreCorto(civTipodocumentosPersona.getTipdocNombrecorto());
        personas.setTipoDocumento(civTipodocumentosPersona.getTipdocId().intValue());
        personas.setTipoDocumentoPersona(tipoDocumentosPersonas);
        personas.setDocumento(civPersonas.getPerDocumento());
        personas.setFechaNacimiento(civPersonas.getPerFechanac());
        personas.setSexo(civPersonas.getPerSexo());
        personas.setNombre1(civPersonas.getPerNombre1());
        personas.setNombre2(civPersonas.getPerNombre2());
        personas.setApellido1(civPersonas.getPerApellido1());
        personas.setApellido2(civPersonas.getPerApellido2());
        personas.setLugarNacimiento(civPersonas.getPerLugarnacimiento().intValue());
        personas.setFechaExpedicion(civPersonas.getPerFechaexp());
        CivEstadopersona civEstadopersona = getEstadosPersonaDAO().consultarById(civPersonas.getCivEstadopersona().getEstperId().intValue());
        personas.setEstado(civEstadopersona.getEstperId().intValue());
        personas.setNombreEstado(civEstadopersona.getEstperDescripcion());
        personas.setFechaIniical(civPersonas.getPerFechainicial());
        personas.setFechaFinal(civPersonas.getPerFechafinal());
        personas.setFechaProceso(civPersonas.getPerFechaproceso());
        personas.setLugarExpedicion(civPersonas.getPerId().intValue());
        bean.getListPersonas().add(personas);

    }

    @Override
    public void eliminarRegistro(BeanGestionPersonas bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BeanGestionPersonas bean) throws Exception {
        CivPersonas civPersonas = new CivPersonas();
        civPersonas.setPerId(new BigDecimal(bean.getDetallePersona().getId()));
        civPersonas.setCivTipodocumentos(getTiposDocumentosDAO().getTipoDocumento(new BigDecimal(bean.getDetallePersona().getTipoDocumento())));
        civPersonas.setPerDocumento(bean.getDetallePersona().getDocumento());
        civPersonas.setPerFechanac(bean.getDetallePersona().getFechaNacimiento());
        civPersonas.setPerLugarnacimiento(new BigDecimal(bean.getDetallePersona().getLugarNacimiento()));
        civPersonas.setPerSexo(bean.getDetallePersona().getSexo());
        civPersonas.setPerNombre1(bean.getDetallePersona().getNombre1());
        civPersonas.setPerNombre2(bean.getDetallePersona().getNombre2());
        civPersonas.setPerApellido1(bean.getDetallePersona().getApellido1());
        civPersonas.setPerApellido2(bean.getDetallePersona().getApellido2());
        civPersonas.setPerFechaexp(bean.getDetallePersona().getFechaExpedicion());
        civPersonas.setCivEstadopersona(getEstadosPersonaDAO().consultarById(bean.getDetallePersona().getEstado()));
        getPersonasDAO().update(civPersonas);

    }

    @Override
    public void save(BeanGestionPersonas bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ITLogin getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(ITLogin loginDAO) {
        this.loginDAO = loginDAO;
    }

    public ITTipoDocumento getTiposDocumentosDAO() {
        return tiposDocumentosDAO;
    }

    public void setTiposDocumentosDAO(ITTipoDocumento tiposDocumentosDAO) {
        this.tiposDocumentosDAO = tiposDocumentosDAO;
    }

    public ITPersonas getPersonasDAO() {
        return personasDAO;
    }

    public void setPersonasDAO(ITPersonas personasDAO) {
        this.personasDAO = personasDAO;
    }

    /**
     * @return the datosPersonasDAO
     */
    public ITDatosPersonas getDatosPersonasDAO() {
        return datosPersonasDAO;
    }

    /**
     * @param datosPersonasDAO the datosPersonasDAO to set
     */
    public void setDatosPersonasDAO(ITDatosPersonas datosPersonasDAO) {
        this.datosPersonasDAO = datosPersonasDAO;
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
     * @return the estadosPersonaDAO
     */
    public ITEstadosPersona getEstadosPersonaDAO() {
        return estadosPersonaDAO;
    }

    /**
     * @param estadosPersonaDAO the estadosPersonaDAO to set
     */
    public void setEstadosPersonaDAO(ITEstadosPersona estadosPersonaDAO) {
        this.estadosPersonaDAO = estadosPersonaDAO;
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
