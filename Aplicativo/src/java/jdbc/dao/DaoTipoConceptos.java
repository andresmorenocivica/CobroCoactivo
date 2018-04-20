/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.dao;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import persistencias.CivTipoconcepto;

/**
 *
 * @author CIVITRANS_FOTOMULTAS
 */
public class DaoTipoConceptos extends HibernateDaoSupport implements ITTipoConceptos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivTipoconcepto civTipoconcepto) throws Exception {
       return Long.parseLong(getHibernateTemplate().save(civTipoconcepto).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivTipoconcepto civTipoconcepto) throws Exception {
        getHibernateTemplate().update(civTipoconcepto);
        return true;
    }

    @Override
    public List<CivTipoconcepto> listAll() throws Exception {
         String hql = "from CivTipoconcepto where tipconFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }
    
}
