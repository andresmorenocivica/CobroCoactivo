/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivDeudas;

/**
 *
 * @author Admin
 */
public interface ITDeudas {
    public long insert(CivDeudas civDeudas) throws Exception;
    
    public boolean update(CivDeudas civDeudas)throws Exception;
    
    public CivDeudas getDeuda(int deu_id)throws Exception;

    public List<CivDeudas>  buscarHistorialDeudasPersonas(int idPersonas) throws Exception;
    
    public List<CivDeudas> getListDeudasbyProcesos(int idProceso) throws Exception;
    
    public List<CivDeudas> listarDeudasByReferencia (String deuReferencia) throws Exception;
}
