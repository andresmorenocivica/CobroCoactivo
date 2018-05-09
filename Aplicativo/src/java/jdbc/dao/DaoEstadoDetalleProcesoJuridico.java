/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivEstadodetalleProceso;

/**
 *
 * @author pruebadesarrollo
 */
public class DaoEstadoDetalleProcesoJuridico extends HibernateDaoSupport implements ITEstadoDetalleProcesoJuridico{
    
    
     @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadodetalleProceso estadodetalleProceso) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(estadodetalleProceso).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadodetalleProceso estadodetalleProceso) throws Exception {
        getHibernateTemplate().merge(estadodetalleProceso);
        return true;
    }

  
    @Override
    public List<CivEstadodetalleProceso> listAll() throws Exception {
        String hql = "from CivEstadodetalleProceso where estdetproFechafinal is null";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivEstadodetalleProceso consultarById(int estdetproId) throws Exception {
        String hql = "from CivEstadodetalleProceso where estdetproId =:estdetproId and estdetproFechafinal is null";
        List list = getHibernateTemplate().findByNamedParam(hql, "estdetproId", BigDecimal.valueOf(estdetproId));
        if (list.size() > 0) {
            return (CivEstadodetalleProceso) list.get(0);
        }
        return null;
    }
}
