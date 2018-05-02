/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package jdbc.dao;

import java.math.BigDecimal;
import persistencias.CivRecursos;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JefreySistemas
 */
public class DaoRecursos extends HibernateDaoSupport implements ITRecursos {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivRecursos recursos) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(recursos).toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(CivRecursos recursos) throws Exception {
        getHibernateTemplate().update(recursos);
        return true;
    }

    @Override

    public List<CivRecursos> getRecursosByModulo(int modulo) throws Exception {

        String hql = "from CivRecursos where civModulos.modId =:modulo and recFechafin is null";
        List list = getHibernateTemplate().findByNamedParam(hql, "modulo", new BigDecimal(modulo));
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override

    public List<CivRecursos> getRecursosByIdPerfil(int id_perfil) throws Exception {
         String hql = "from CivRecursos where civPerfiles.perfId =:idPerfil and recFechafin is null";
        List list = getHibernateTemplate().findByNamedParam(hql, "idPerfil", new  BigDecimal(id_perfil));
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override

    public CivRecursos getRecursosbyId(int id_recurso) throws Exception {

        String hql = "from CivRecursos where rec_id=:id_recurso";
        List list = getHibernateTemplate().findByNamedParam(hql, "id_recurso", id_recurso);
        if (list.size() > 0) {
            return (CivRecursos) list.get(0);
        }
        return null;
    }

    @Override

    public List<CivRecursos> getRecursosAll() throws Exception {
        String hql = "from CivRecursos where rec_fechafin is null order by mod_id asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override

    public List<CivRecursos> listarRecursos(String recurso) throws Exception {

        String hql = "from CivRecursos where Rec_Nombre like :recurso ORDER BY 1 asc";
        List list = getHibernateTemplate().findByNamedParam(hql, "recurso", "%" + recurso + "%");
        return list;
    }
}
