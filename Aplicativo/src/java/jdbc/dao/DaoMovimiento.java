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
import persistencias.CivMovimientos;

/**
 *
 * @author jvergara
 */
public class DaoMovimiento extends HibernateDaoSupport implements ITMovimiento {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivMovimientos civMovimientos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(civMovimientos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivMovimientos civMovimientos) throws Exception {
        getHibernateTemplate().update(civMovimientos);
        return true;
    }

    @Override
    public CivMovimientos getMovimientoByIdDeuda(int deuId) throws Exception {
        String hql = "from CivMovimientos where deuId=:deuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "deuId", new BigDecimal(deuId));
        if (list.size() > 0) {
            return (CivMovimientos) list.get(0);
        }
        return null;
    }

    @Override
    public List<CivMovimientos> listAll() throws Exception {
        String hql = "from CivMovimientos where fechaFinal is null order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override
    public List<CivMovimientos> getlistMovimientosById(int deuId) throws Exception {
        String hql = "from CivMovimientos where deuId=:deuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "deuId", new BigDecimal(deuId));
        return list;
    }

    @Override
    public List<CivMovimientos> buscarMovimientoDeudasPersonas(int deuId) throws Exception {
        String hql = "from CivMovimientos where deuId=:deuId";
        List list = getHibernateTemplate().findByNamedParam(hql, "deuId", new BigDecimal(deuId));
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public CivMovimientos getMovimientoByDeudaByfDetalleProceso(BigDecimal deuId, BigDecimal detpropId) throws Exception {
        String hql = "from CivMovimientos Where deuId=:deuId and detpropId=:detpropId";
        List list = getHibernateTemplate().findByNamedParam(hql, new String[]{"deuId","detpropId"}, new Object[]{deuId, detpropId});
        if (list.size() > 0) {
            return (CivMovimientos) list.get(0);
        }
        return null;
    }

    @Override
    public CivMovimientos consultarPersonasDocumento(String Documento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
