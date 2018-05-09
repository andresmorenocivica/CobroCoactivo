/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import beans.BeanGestionPersonas;

/**
 *
 * @author jvergara
 */
public interface GestionPersonasBO {
    
    void llenarDatos(BeanGestionPersonas bean)throws Exception;
    
    void eliminarRegistro (BeanGestionPersonas bean)  throws Exception;
    
    void update(BeanGestionPersonas bean) throws Exception;
    
    void save(BeanGestionPersonas bean) throws Exception;
    
    void consultarPorNumero(BeanGestionPersonas bean) throws Exception;
    
    void buscarDatosPersonas(BeanGestionPersonas bean) throws Exception;
    
    void  buscarHistorialDeudasPersonas(BeanGestionPersonas bean) throws Exception;
    
    void  buscarMovimientoDeudaPersona (BeanGestionPersonas bean) throws Exception;
}
