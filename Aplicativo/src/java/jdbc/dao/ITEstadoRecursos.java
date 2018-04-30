/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import persistencias.CivEstadorecursos;

/**
 *
 * @author jvergara
 */
public interface ITEstadoRecursos {
    
     public long insert(CivEstadorecursos estadorecursos)throws Exception;
    
    public boolean update(CivEstadorecursos estadorecursos)throws Exception;
    
    public List<CivEstadorecursos> listAll()throws Exception;
    
}
