/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

/**
 *
 * @author pruebadesarrollo
 */
public interface GestionProcesoBO {

    public void cargarListaProceso(beans.BeanGestionProceso bean) throws Exception;

    public void guardarProcesoJuridico(beans.BeanGestionProceso bean) throws Exception;

    public void cargarEstadoProceso(beans.BeanGestionProceso bean) throws Exception;

    public void actualizarProceso(beans.BeanGestionProceso bean) throws Exception;

    public void eliminarRegistro(beans.BeanGestionProceso bean) throws Exception;

    public void guardarFases(beans.BeanGestionProceso bean) throws Exception;
    
    public void actulizarFases (beans.BeanGestionProceso bean) throws Exception;

}
