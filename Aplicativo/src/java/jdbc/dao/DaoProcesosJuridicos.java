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
import persistencias.CivDetalleProcesojuridico;
import persistencias.CivProcesosjuridicos;

/**
 *
 * @author Admin
 */
public class DaoProcesosJuridicos extends HibernateDaoSupport implements ITProcesosJuridicos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivProcesosjuridicos civProcesosjuridicos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civProcesosjuridicos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivProcesosjuridicos civProcesosjuridicos) throws Exception {
        getHibernateTemplate().update(civProcesosjuridicos);
        return true;
    }

    @Override
    public CivProcesosjuridicos getConcepto(int projuId) throws Exception {
        String hql = "from CivProcesosjuridicos where projuId=:projuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "projuId", new BigDecimal(projuId));
        if (list.size() > 0) {
            return (CivProcesosjuridicos) list.get(0);
        }
        return null;
    }

 
    
     @Override
    public List<CivProcesosjuridicos> listAll() throws Exception {
        String hql = "from CivProcesosjuridicos where projuFechafinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;

}
    

}
