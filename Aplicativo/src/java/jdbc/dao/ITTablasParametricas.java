/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivTablasparametricas;

/**
 *
 * @author Admin
 */
public interface ITTablasParametricas {
    
    public long insert(CivTablasparametricas tablasparametricas)throws Exception;
    
    public boolean update(CivTablasparametricas tablasparametricas)throws Exception;
    
    public List<CivTablasparametricas> listAll()throws Exception;
}
