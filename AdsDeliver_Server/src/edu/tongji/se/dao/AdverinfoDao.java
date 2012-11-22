package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Adverinfo;

public interface AdverinfoDao {

	public void save(Adverinfo transientInstance);
	
	public void delete(Adverinfo persistentInstance);
	
	public Adverinfo findById(java.lang.Integer id);
	
	public List findByExample(Adverinfo instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findByAfBannerPic(Object afBannerPic);
	
	public List findByAfBannerWordOne(Object afBannerWordOne);
	
	public List findByAfBannerWordTwo(Object afBannerWordTwo);
	
	public List findByAfContentPic(Object afContentPic);
	
	public List findByAfContents(Object afContents);
	
	public List findAll();
	
	public Adverinfo merge(Adverinfo detachedInstance);
	
	public void attachDirty(Adverinfo instance);
	
	public void attachClean(Adverinfo instance);
}
