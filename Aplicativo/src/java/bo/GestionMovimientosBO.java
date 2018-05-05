/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionMovimientos;
import java.util.List;
import model.DetalleProcesoJuridico;
import model.Deudas;

/**
 *
 * @author jvergara
 */
public interface GestionMovimientosBO {
    
    
    public void cargarListaProceso(BeanGestionMovimientos bean) throws Exception;
    
    
    public List<DetalleProcesoJuridico> llenarDetalleProceso(long id) throws Exception;
    
    
    public List<Deudas> listaDeDeudas(long idProceso) throws Exception;
    
  
    
}
