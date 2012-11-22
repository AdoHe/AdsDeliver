package edu.tongji.se.daoImpl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.tongji.se.dao.AdverinfoDao;
import edu.tongji.se.model.Adverinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Adverinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see edu.tongji.se.model.Adverinfo
 * @author MyEclipse Persistence Tools
 */

public class AdverinfoDaoImpl extends HibernateDaoSupport implements AdverinfoDao{
	private static final Logger log = LoggerFactory
			.getLogger(AdverinfoDaoImpl.class);
	// property constants
	public static final String AF_BANNER_PIC = "afBannerPic";
	public static final String AF_BANNER_WORD_ONE = "afBannerWordOne";
	public static final String AF_BANNER_WORD_TWO = "afBannerWordTwo";
	public static final String AF_CONTENT_PIC = "afContentPic";
	public static final String AF_CONTENTS = "afContents";

	protected void initDao() {
		// do nothing
	}

	public void save(Adverinfo transientInstance) {
		log.debug("saving Adverinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Adverinfo persistentInstance) {
		log.debug("deleting Adverinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adverinfo findById(java.lang.Integer id) {
		log.debug("getting Adverinfo instance with id: " + id);
		try {
			Adverinfo instance = (Adverinfo) getHibernateTemplate().get(
					"edu.tongji.se.model.Adverinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Adverinfo instance) {
		log.debug("finding Adverinfo instance by example");
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
		log.debug("finding Adverinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Adverinfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAfBannerPic(Object afBannerPic) {
		return findByProperty(AF_BANNER_PIC, afBannerPic);
	}

	public List findByAfBannerWordOne(Object afBannerWordOne) {
		return findByProperty(AF_BANNER_WORD_ONE, afBannerWordOne);
	}

	public List findByAfBannerWordTwo(Object afBannerWordTwo) {
		return findByProperty(AF_BANNER_WORD_TWO, afBannerWordTwo);
	}

	public List findByAfContentPic(Object afContentPic) {
		return findByProperty(AF_CONTENT_PIC, afContentPic);
	}

	public List findByAfContents(Object afContents) {
		return findByProperty(AF_CONTENTS, afContents);
	}

	public List findAll() {
		log.debug("finding all Adverinfo instances");
		try {
			String queryString = "from Adverinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Adverinfo merge(Adverinfo detachedInstance) {
		log.debug("merging Adverinfo instance");
		try {
			Adverinfo result = (Adverinfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Adverinfo instance) {
		log.debug("attaching dirty Adverinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adverinfo instance) {
		log.debug("attaching clean Adverinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdverinfoDaoImpl getFromApplicationContext(ApplicationContext ctx) {
		return (AdverinfoDaoImpl) ctx.getBean("AdverinfoDAO");
	}
}