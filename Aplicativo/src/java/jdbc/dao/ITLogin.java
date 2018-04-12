package jdbc.dao;

import persistencias.CivRecursos;
import persistencias.CivUsuarios;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITLogin {

    /**
     *
     * @param obj
     * @return
     * @throws java.lang.Exception
     */
    CivUsuarios validarLogin(CivUsuarios obj) throws Exception;

    /**
     *
     * @param usu_id
     * @return
     * @throws java.lang.Exception
     */
    List<CivRecursos> listarRecursos(int usu_id) throws Exception;

    /**
     *
     * @param nombre_usu
     * @return
     * @throws Exception
     */
    public CivUsuarios getUsuario(String nombre_usu) throws Exception;

}
