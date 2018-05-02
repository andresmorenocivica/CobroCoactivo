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
import persistencias.CivEstadousuarios;

/**
 *
 * @author amoreno
 */
public class DaoEstadoUsuarios extends HibernateDaoSupport implements ITEstadoUsuarios{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadousuarios estadousuarios) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(estadousuarios).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadousuarios estadousuarios) throws Exception {
        getHibernateTemplate().merge(estadousuarios);
        return true;
    }

    @Override
    public List<CivEstadousuarios> listAll() throws Exception {
        String hql = "from CivEstadousuarios";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public CivEstadousuarios consultarModuloById(int id) throws Exception {
        String hql = "from CivEstadousuarios where estusuId =:estusuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "estusuId", BigDecimal.valueOf(id));
        if (list.size() > 0) {
            return (CivEstadousuarios) list.get(0);
        }
        return null;
    }
    
}
