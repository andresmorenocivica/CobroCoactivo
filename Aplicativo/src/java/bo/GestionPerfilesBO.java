/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionPerfiles;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public interface GestionPerfilesBO {
    
     void llenarDatos(BeanGestionPerfiles bean)throws Exception;
    
    void eliminarRegistro (BeanGestionPerfiles bean)  throws Exception;
    
    void update(BeanGestionPerfiles bean) throws Exception;
    
    void save(BeanGestionPerfiles bean) throws Exception;
    
    void saveRecurso(BeanGestionPerfiles bea) throws Exception;
    
}
