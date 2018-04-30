/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadomodulos;

/**
 *
 * @author jvergara
 */
public interface ITEstadoModulos {
    
     public long insert(CivEstadomodulos estadorEstadomodulos)throws Exception;
    
    public boolean update(CivEstadomodulos estadorEstadomodulos)throws Exception;
    
    public List<CivEstadomodulos> listAll()throws Exception;
    
}
