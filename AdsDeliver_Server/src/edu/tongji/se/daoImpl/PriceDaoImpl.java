package edu.tongji.se.daoImpl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.tongji.se.dao.PriceDao;
import edu.tongji.se.model.Price;

/**
 * A data access object (DAO) providing persistence and search support for Price
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see edu.tongji.se.model.Price
 * @author MyEclipse Persistence Tools
 */

public class PriceDaoImpl extends HibernateDaoSupport 
			implements PriceDao
{
	private static final Logger log = LoggerFactory.getLogger(PriceDaoImpl.class);
	// property constants
	public static final String PC_BANNER = "pcBanner";
	public static final String PC_CONTENT = "pcContent";

	protected void initDao() {
		// do nothing
	}

	public void save(Price transientInstance) {
		log.debug("saving Price instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Price persistentInstance) {
		log.debug("deleting Price instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Price findById(java.lang.Short id) {
		log.debug("getting Price instance with id: " + id);
		try {
			Price instance = (Price) getHibernateTemplate().get(
					"edu.tongji.se.model.Price", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Price instance) {
		log.debug("finding Price instance by example");
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
		log.debug("finding Price instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Price as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPcBanner(Object pcBanner) {
		return findByProperty(PC_BANNER, pcBanner);
	}

	public List findByPcContent(Object pcContent) {
		return findByProperty(PC_CONTENT, pcContent);
	}

	public List findAll() {
		log.debug("finding all Price instances");
		try {
			String queryString = "from Price";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Price merge(Price detachedInstance) {
		log.debug("merging Price instance");
		try {
			Price result = (Price) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Price instance) {
		log.debug("attaching dirty Price instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Price instance) {
		log.debug("attaching clean Price instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PriceDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (PriceDaoImpl) ctx.getBean("PriceDAO");
	}

	@Override
	public void updatePrice(float bannerPrice, float contentPrice) {
		// TODO Auto-generated method stub
		log.debug("update the banner and content price");
		
		Session s = this.getSession();
		s.beginTransaction();
		
		String hqlString = "update Price as p set p.pcBanner = :bannerPrice, p.pcContent = :contentPrice where p.id = 1";
		Query query = s.createQuery(hqlString);
		
		query.setParameter("bannerPrice", (Object)bannerPrice);
		query.setParameter("contentPrice", (Object)contentPrice);
		
		query.executeUpdate();
		
		s.getTransaction().commit();
		s.close();
	}
}