package edu.tongji.se.daoImpl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.tongji.se.dao.RecordDao;
import edu.tongji.se.model.Record;

/**
 	* A data access object (DAO) providing persistence and search support for Record entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see edu.tongji.se.model.Record
  * @author MyEclipse Persistence Tools 
 */

public class RecordDaoImpl extends HibernateDaoSupport implements RecordDao  
{
	     private static final Logger log = LoggerFactory.getLogger(RecordDaoImpl.class);
		//property constants
	public static final String RE_INCOME = "reIncome";
	public static final String RE_OUTCOME = "reOutcome";
	public static final String RE_BALANCE = "reBalance";
	public static final String RE_CATEGORY = "reCategory";



    
    public void save(Record transientInstance) {
        log.debug("saving Record instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Record persistentInstance) {
        log.debug("deleting Record instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Record findById( java.lang.Integer id) {
        log.debug("getting Record instance with id: " + id);
        try {
            Record instance = (Record) getSession()
                    .get("edu.tongji.se.model.Record", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Record instance) {
        log.debug("finding Record instance by example");
        try {
            List results = getSession()
                    .createCriteria("edu.tongji.se.model.Record")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Record instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Record as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByReIncome(Object reIncome
	) {
		return findByProperty(RE_INCOME, reIncome
		);
	}
	
	public List findByReOutcome(Object reOutcome
	) {
		return findByProperty(RE_OUTCOME, reOutcome
		);
	}
	
	public List findByReBalance(Object reBalance
	) {
		return findByProperty(RE_BALANCE, reBalance
		);
	}
	
	public List findByReCategory(Object reCategory
	) {
		return findByProperty(RE_CATEGORY, reCategory
		);
	}
	

	public List findAll() {
		log.debug("finding all Record instances");
		try {
			String queryString = "from Record";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Record merge(Record detachedInstance) {
        log.debug("merging Record instance");
        try {
            Record result = (Record) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Record instance) {
        log.debug("attaching dirty Record instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Record instance) {
        log.debug("attaching clean Record instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}