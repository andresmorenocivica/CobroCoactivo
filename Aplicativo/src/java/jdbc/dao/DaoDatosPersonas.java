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
import persistencias.CivDatospersona;

/**
 *
 * @author jvergara
 */
public class DaoDatosPersonas extends HibernateDaoSupport implements ITDatosPersonas {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivDatospersona civDatospersona) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civDatospersona).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivDatospersona civDatospersona) throws Exception {
        getHibernateTemplate().merge(civDatospersona);
        return true;
    }



    @Override
    public List<CivDatospersona> listDatosPersonas(int idPersonas) throws Exception {
        String hql = "from CivDatospersona where civPersonas.perId=:id";
        List list = getHibernateTemplate().findByNamedParam(hql, "id", new BigDecimal(idPersonas));
       return list;
    }
    
    
      
    public CivDatospersona getDatosPersona(int datperId) throws Exception {
        String hql = "from CivDatospersona where datperId=:conId";
        List list = getHibernateTemplate().findByNamedParam(hql, "conId", new BigDecimal(datperId));
        if (list.size() > 0) {
            return (CivDatospersona) list.get(0);
        }
        return null;
    }

}
