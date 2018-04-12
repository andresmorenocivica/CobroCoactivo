/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package jdbc.dao;

import persistencias.CivTipodocumentos;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Roymer Camacho
 */
public interface ITTipoDocumento {
    
    /**
    
     *
     * @param civTipodocumentos El Objeto a insertar.
     * @return ID único del elemento insertado.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public long insert(CivTipodocumentos civTipodocumentos) throws Exception;

    /**
     
     *
     * @param civTipodocumentos El Objeto a actualizar.
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public boolean update(CivTipodocumentos civTipodocumentos) throws Exception;
    
    /**
     
     *
     * @return Retorna verdadero si la actualización fue correcta.
     * @throws Exception La Excepción lanzada en caso de error.
     */
    public List<CivTipodocumentos> listAll() throws Exception;
    
     public CivTipodocumentos getTipoDocumento(BigDecimal tipoDocumento) throws Exception;
   
}
