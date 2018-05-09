/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivDetalleProcesojuridico;

/**
 *
 * @author Admin
 */
public interface ITDetalleProcesosJuridicos {
    public long insert(CivDetalleProcesojuridico civDetalleProcesojuridico) throws Exception;

    public boolean update(CivDetalleProcesojuridico civDetalleProcesojuridico) throws Exception;
    
    public CivDetalleProcesojuridico getDetalleProcesoJuridicoByid(int detprojuId) throws Exception;
    
    public List<CivDetalleProcesojuridico> listAll() throws Exception;
    
    public List<CivDetalleProcesojuridico> listarDetalleUsuarioBy(long projuId) throws Exception;
    
}
