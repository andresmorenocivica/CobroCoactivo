/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadodetalleProceso;

/**
 *
 * @author pruebadesarrollo
 */
public interface ITEstadoDetalleProcesoJuridico {
    
    public long insert(CivEstadodetalleProceso estadodetalleProceso)throws Exception;
    
    public boolean update(CivEstadodetalleProceso estadodetalleProceso)throws Exception;
    
    public List<CivEstadodetalleProceso> listAll()throws Exception;
    
    public CivEstadodetalleProceso consultarById(int estdetproId) throws Exception;
}
