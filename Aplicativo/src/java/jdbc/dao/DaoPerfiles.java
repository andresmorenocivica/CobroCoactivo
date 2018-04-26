/*
 * Civitrans
 * La Cívica Impresores S.A.S
 * Copyright 2016.
 */
package jdbc.dao;

import persistencias.CivPerfiles;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JefreySistemas
 */
public class DaoPerfiles extends HibernateDaoSupport implements ITPerfiles {

    @Override

    public List<CivPerfiles> getAllPerfiles() throws Exception {
        String hql = "from CivPerfiles order by 1 asc";
        List list = getHibernateTemplate().find(hql);
        return list;
    }

    @Override

    public CivPerfiles consultarPerfilById(int id_perfil) throws Exception {

        String hql = "from CivPerfiles where perf_id=:id_perfil";
        List list = getHibernateTemplate().findByNamedParam(hql, "id_perfil", id_perfil);
        if (list.size() > 0) {
            return (CivPerfiles) list.get(0);
        }
        return null;
    }
    
    @Override

    public CivPerfiles consultarPerfilByName(String name) throws Exception {

        String hql = "from CivPerfiles where perf_nombre=:name";
        List list = getHibernateTemplate().findByNamedParam(hql, "name", name);
        if (list.size() > 0) {
            return (CivPerfiles) list.get(0);
        }
        return null;
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public long insert(CivPerfiles perfiles) throws Exception {
        return Long.parseLong(getHibernateTemplate().save(perfiles).toString());
    }
    
      @Override
    public List<CivPerfiles> listarPerfilesUsuario(int idUsuario) throws Exception {
        Session session = getHibernateTemplate().getSessionFactory().openSession();

//        String sql = "Select r.* from CIV_RECURSOS r\n"
//                + "inner join CIV_PERFILRECURSO pr\n"
//                + "on pr.rec_id = r.rec_id\n"
//                + "inner join CIV_USUPERFIL up\n"
//                + "on up.PERF_ID = pr.PERF_ID and up.USU_ID =:usu_id";
        String sql = "SELECT DISTINCT P.* from CIV_PERFILRECURSO PR\n"
                + "INNER JOIN CIV_RECURSOS R ON R.REC_ID = PR.REC_ID AND R.REC_FECHAFIN IS NULL AND R.REC_ESTADO = 1\n"
                + "INNER JOIN CIV_PERFILES P ON P.PERF_ID = R.PERF_ID \n"
                + "WHERE PR.USU_ID =:usu_id";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(CivPerfiles.class);
        query.setInteger("usu_id", idUsuario);

        if (query.list().size() > 0) {
            return query.list();
        }
        return null;
    }
}
