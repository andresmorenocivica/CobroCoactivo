/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivMovimientos;

/**
 *
 * @author jvergara
 */
public interface ITMovimiento {

    public long insert(CivMovimientos civMovimientos) throws Exception;

    public boolean update(CivMovimientos civMovimientos) throws Exception;

    public CivMovimientos getMovimientoByIdDeuda(int id) throws Exception;

    public List<CivMovimientos> listAll() throws Exception;
    
    public List<CivMovimientos> getlistMovimientosById(int deuId) throws Exception;

}
