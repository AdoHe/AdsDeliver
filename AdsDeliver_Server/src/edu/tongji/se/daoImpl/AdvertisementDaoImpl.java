package edu.tongji.se.daoImpl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.tongji.se.dao.AdvertisementDao;
import edu.tongji.se.model.Advertisement;

/**
 * A data access object (DAO) providing persistence and search support for
 * Advertisement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see edu.tongji.se.model.Advertisement
 * @author MyEclipse Persistence Tools
 */

public class AdvertisementDaoImpl extends HibernateDaoSupport implements AdvertisementDao{
	private static final Logger log = LoggerFactory
			.getLogger(AdvertisementDaoImpl.class);
	// property constants
	public static final String AV_NAME = "avName";
	public static final String AV_ADDRESS = "avAddress";
	public static final String AV_STATUS = "avStatus";
	public static final String AV_CLICK_TIMES = "avClickTimes";
	public static final String AV_SHOW_TIMES = "avShowTimes";
	public static final String AV_DESC = "avDesc";
	protected void initDao() {
		// do nothing
	}

	public void save(Advertisement transientInstance) {
		log.debug("saving Advertisement instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Advertisement persistentInstance) {
		log.debug("deleting Advertisement instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Advertisement findById(java.lang.Integer id) {
		log.debug("getting Advertisement instance with id: " + id);
		try {
			Advertisement instance = (Advertisement) getHibernateTemplate()
					.get("edu.tongji.se.model.Advertisement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Advertisement instance) {
		log.debug("finding Advertisement instance by example");
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
		log.debug("finding Advertisement instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Advertisement as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAvName(Object avName) {
		return findByProperty(AV_NAME, avName);
	}

	public List findByAvAddress(Object avAddress) {
		return findByProperty(AV_ADDRESS, avAddress);
	}

	public List findByAvStatus(Object avStatus) {
		return findByProperty(AV_STATUS, avStatus);
	}

	public List findByAvClickTimes(Object avClickTimes) {
		return findByProperty(AV_CLICK_TIMES, avClickTimes);
	}

	public List findByAvShowTimes(Object avShowTimes) {
		return findByProperty(AV_SHOW_TIMES, avShowTimes);
	}
	
	public List findByAvDesc(Object avDesc) {
		return findByProperty(AV_DESC, avDesc);
	}
	
	public List findAll() {
		log.debug("finding all Advertisement instances");
		try {
			String queryString = "from Advertisement";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Advertisement merge(Advertisement detachedInstance) {
		log.debug("merging Advertisement instance");
		try {
			Advertisement result = (Advertisement) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Advertisement instance) {
		log.debug("attaching dirty Advertisement instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Advertisement instance) {
		log.debug("attaching clean Advertisement instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdvertisementDaoImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdvertisementDaoImpl) ctx.getBean("AdvertisementDAO");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> findAd(final String userName, final int offset, final int length) {
		
		log.debug("find paged advertisement for special account");
		final String HQL = "from Advertisement as ad "
                + "where ad.user.usName=?"
                + "order by ad.id desc";
        
        List<Advertisement> list = getHibernateTemplate().executeFind(new HibernateCallback() {  
              
            public Object doInHibernate(Session session) throws HibernateException,  
                    SQLException {  
                List<Advertisement> result = session.createQuery(HQL).setFirstResult(offset)  
                                .setParameter(0, userName)
                                .setMaxResults(length)  
                                .list();  
                return result;  
            }  
        });  
        return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> findAd(final String userName, final int status, final int offset,
			final int length) {
		// TODO Auto-generated method stub
		log.debug("find paged advertisement for special account");
		final String HQL = "from Advertisement as ad "
                + "where ad.user.usName=? and ad.avStatus=? "
                + "order by ad.id desc";
        
        List<Advertisement> list = getHibernateTemplate().executeFind(new HibernateCallback() {  
              
            public Object doInHibernate(Session session) throws HibernateException,  
                    SQLException {  
                List<Advertisement> result = session.createQuery(HQL).setFirstResult(offset)  
                                .setParameter(0, userName)
                                .setParameter(1, (short)status)
                                .setMaxResults(length)  
                                .list();  
                return result;  
            }  
        });  
        return list;
	}

	@Override
	public int getAllAdCount(String userName) 
	{
		// TODO Auto-generated method stub
		log.debug("find all advertisement count");
		List list = getHibernateTemplate().find("select count(*) from Advertisement as a where "
				+ "a.user.usName=?", (Object)userName);
        return ((Long)list.iterator().next()).intValue();
	}

	@Override
	public int getPaAdCount(String userName, int status) 
	{
		// TODO Auto-generated method stub
		log.debug("fina all passed advertisement count");
		List list = getHibernateTemplate().find("select count(*) from Advertisement as a where "
				+ "a.user.usName=? and a.avStatus=?", (Object)userName,(short)status);
		return ((Long)list.iterator().next()).intValue();
	}

	/**
	 * 通过经纬度查找周围一定距离的广告
	 */
	@Override
	public List findAdsNearBy(final float distance, final float lon, final float lat, final int length) {
		final String HQL = "from Advertisement as ad " +
				"where get_distance(ad.location.lcLongitude, " +
				"ad.location.lcLatitude, " +
				"?, ?) < ? order by ad.id desc";
		
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(HQL).setFirstResult(0)  
                        .setParameter(0, lon)
                        .setParameter(1, lat)
                        .setParameter(2, distance)
                        .setMaxResults(length)  
                        .list(); 
				
				return result;
			}
			
		});
		
		return list;
	}

	@Override
	public List findAdsRandom() {
		
		final String HQL = "from Advertisement order by rand() limit 1";
		
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(HQL)
                        .setMaxResults(1)  
                        .list(); 
				
				return result;
			}
			
		});
		
		return list;
	}
}