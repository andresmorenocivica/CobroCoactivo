/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionRecursos;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public interface GestionRecursosBO {
    void listarRecursos(BeanGestionRecursos bean)throws Exception;
    
    void listarModulos(BeanGestionRecursos bean)throws Exception;
   
    void listarPerfiles(BeanGestionRecursos bean)throws Exception;
    
    void eliminarRegistro (BeanGestionRecursos bean)  throws Exception;
    
    void update(BeanGestionRecursos bean) throws Exception;
    
    void save(BeanGestionRecursos bean) throws Exception;
    
    void listarTipoRecursos(BeanGestionRecursos bean) throws Exception;
}
