/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionParametros;
import model.Parametros;

/**
 *
 * @author Admin
 */
public interface GestionParametrosBO {
    
    void llenarDatos(BeanGestionParametros bean)throws Exception;
    
    void eliminarRegistro (BeanGestionParametros bean)  throws Exception;
    
    void update(BeanGestionParametros bean) throws Exception;
    
    void save(BeanGestionParametros bean) throws Exception;
}
