/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivEstadomodulos;

/**
 *
 * @author jvergara
 */
public class DaoEstadoModulos extends HibernateDaoSupport implements ITEstadoModulos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivEstadomodulos estadorEstadomodulos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(estadorEstadomodulos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivEstadomodulos estadorEstadomodulos) throws Exception {
        getHibernateTemplate().merge(estadorEstadomodulos);
        return true;
    }

    @Override
    public List<CivEstadomodulos> listAll() throws Exception {
        String hql = "from CivEstadomodulos";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

}
