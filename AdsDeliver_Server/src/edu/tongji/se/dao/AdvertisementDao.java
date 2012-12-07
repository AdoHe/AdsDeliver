package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Advertisement;

public interface AdvertisementDao {
	
	public void save(Advertisement transientInstance);
	
	public void delete(Advertisement persistentInstance);
	
	public Advertisement findById(java.lang.Integer id);
	
	public List findByExample(Advertisement instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findByAvName(Object avName);
	
	public List findByAvAddress(Object avAddress);
	
	public List findByAvStatus(Object avStatus);
	
	public List findByAvClickTimes(Object avClickTimes);
	
	public List findByAvShowTimes(Object avShowTimes);
	
	public List findAll();
	
	public Advertisement merge(Advertisement detachedInstance);
	
	public void attachDirty(Advertisement instance);
	
	public void attachClean(Advertisement instance);

	public List<Advertisement> findAd(final String userName, final int offset, final int length);

	public List<Advertisement> findAd(final String userName, final int status, final int offset, final int length);
	
	public int getAllAdCount(final String userName);
	
	public int getPaAdCount(final String userName, final int status);
}
