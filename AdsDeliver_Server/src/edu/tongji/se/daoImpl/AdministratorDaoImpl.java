package edu.tongji.se.daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.tongji.se.dao.AdministratorDao;
import edu.tongji.se.model.Administrator;


/**
 * A data access object (DAO) providing persistence and search support for
 * Administrator entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.tongji.se.model.Administrator
 * @author MyEclipse Persistence Tools
 */

public class AdministratorDaoImpl extends HibernateDaoSupport 
			implements AdministratorDao
{
	private static final Logger log = LoggerFactory
			.getLogger(AdministratorDaoImpl.class);
	// property constants
	public static final String AD_NAME = "adName";
	public static final String AD_PASSWORD = "adPassword";
	public static final String AD_LEVEL = "adLevel";
	public static final String AD_RAND = "adRand";

	protected void initDao() {
		// do nothing
	}

	public void save(Administrator transientInstance) {
		log.debug("saving Administrator instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Administrator persistentInstance) {
		log.debug("deleting Administrator instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Administrator findById(java.lang.Short id) {
		log.debug("getting Administrator instance with id: " + id);
		try {
			Administrator instance = (Administrator) getHibernateTemplate()
					.get("edu.tongji.se.model.Administrator", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Administrator instance) {
		log.debug("finding Administrator instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Administrator instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Administrator as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAdName(Object adName) {
		return findByProperty(AD_NAME, adName);
	}

	public List findByAdPassword(Object adPassword) {
		return findByProperty(AD_PASSWORD, adPassword);
	}

	public List findByAdLevel(Object adLevel) {
		return findByProperty(AD_LEVEL, adLevel);
	}

	public List findByAdRand(Object adRand) {
		return findByProperty(AD_RAND, adRand);
	}

	public List findAll() {
		log.debug("finding all Administrator instances");
		try {
			String queryString = "from Administrator as model where model.id = 2";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Administrator merge(Administrator detachedInstance) {
		log.debug("merging Administrator instance");
		try {
			Administrator result = (Administrator) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Administrator instance) {
		log.debug("attaching dirty Administrator instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Administrator instance) {
		log.debug("attaching clean Administrator instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdministratorDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdministratorDaoImpl) ctx.getBean("AdministratorDAO");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findAll(final short level, final int offset, final int length) {
		// TODO Auto-generated method stub
		log.debug("find paged advertisement for special account");
		final String HQL = "from Administrator as a "
                + "where a.adLevel=?"
                + "order by a.id desc";
        
        List<Administrator> list = getHibernateTemplate().executeFind(new HibernateCallback() {  
              
            public Object doInHibernate(Session session) throws HibernateException,  
                    SQLException {  
                List<Administrator> result = session.createQuery(HQL).setFirstResult(offset)  
                                .setParameter(0, level)
                                .setMaxResults(length)  
                                .list();  
                return result;  
            }  
        });  
        return list;
	}

	@Override
	public void delete(short id) {
		// TODO Auto-generated method stub
		Object a = getHibernateTemplate().load(Administrator.class, id);
		getHibernateTemplate().delete(a);
	}

}