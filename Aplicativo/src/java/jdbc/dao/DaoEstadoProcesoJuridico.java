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
import persistencias.CivEstadoprocesojuridicos;

/**
 *
 * @author pruebadesarrollo
 */
public class DaoEstadoProcesoJuridico extends HibernateDaoSupport implements ITEstadoProcesoJuridico {

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
    public List<CivEstadoprocesojuridicos> listAll() throws Exception {
        String hql = "from CivEstadoprocesojuridicos ";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivEstadoprocesojuridicos consultaById(int estproId) throws Exception {
        String hql = "from CivEstadoprocesojuridicos where estproId =:estproId";
        List list = getHibernateTemplate().findByNamedParam(hql, "estproId", BigDecimal.valueOf(estproId));
        if (list.size() > 0) {
            return (CivEstadoprocesojuridicos) list.get(0);
        }
        return null;
    }

}
