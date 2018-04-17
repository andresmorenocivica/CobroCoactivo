/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivTablasparametricas;

/**
 *
 * @author Admin
 */
public class DaoTablasParametricas extends HibernateDaoSupport implements ITTablasParametricas {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTablasparametricas tablasparametricas) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(tablasparametricas).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTablasparametricas tablasparametricas) throws Exception {
        getHibernateTemplate().merge(tablasparametricas);
        return true;
    }

    @Override
    public List<CivTablasparametricas> listAll() throws Exception {
        String hql = "from CivTablasparametricas";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

}
