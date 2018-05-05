/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionModulos;

/**
 *
 * @author Admin
 */
public interface GestionModulosBO {

    void llenarDatos(BeanGestionModulos bean) throws Exception;
    
    void eliminarRecurso(BeanGestionModulos bean) throws Exception;
    
    void guardar (BeanGestionModulos bean) throws Exception;
    
    void listarperfiles (BeanGestionModulos bean) throws Exception;
    
    void guardarRecurso(BeanGestionModulos bean) throws Exception;
    
    void actualizarRecurso (BeanGestionModulos bean) throws Exception;
    
        
}
