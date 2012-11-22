package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Userinfo;

public interface UserinfoDao {
	public void save(Userinfo transientInstance);
	
	public void delete(Userinfo persistentInstance);
	
	public Userinfo findById(java.lang.Integer id);
	
	public List findByExample(Userinfo instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findByUfName(Object ufName);
	
	public List findByUfCorperation(Object ufCorperation);
	
	public List findByUfMobilePhone(Object ufMobilePhone);
	
	public List findByUfTelephone(Object ufTelephone);
	
	public List findByUfAddress(Object ufAddress);
	
	public List findByUfStatus(Object ufStatus);
	
	public List findAll();
	
	public Userinfo merge(Userinfo detachedInstance);
	
	public void attachDirty(Userinfo instance);
	
	public void attachClean(Userinfo instance);

	
}
	
