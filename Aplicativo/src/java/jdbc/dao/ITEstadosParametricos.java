/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadosparametricos;

/**
 *
 * @author amoreno
 */
public interface ITEstadosParametricos {
    public long insert(CivEstadosparametricos estadosparametricos)throws Exception;
    
    public boolean update(CivEstadosparametricos estadosparametricos)throws Exception;
    
    public List<CivEstadosparametricos> listAll()throws Exception;
}
