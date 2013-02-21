package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.User;

public interface UserDao {
	public void save(User transientInstance);
	
	public void delete(User persistentInstance);
	
	public User findById(java.lang.Integer id);
	
	public List findByExample(User instance);
	
	public List findByProperty(String propertyName, Object value);
	
	public List findByUsName(Object usName);
	
	public List findByUsPassword(Object usPassword);
	
	public List findByUsRand(Object usRand);
	
	public List findAll();
	
	public User merge(User detachedInstance);
	
	public void attachDirty(User instance);
	
	public void attachClean(User instance);

	/**
	 * 通过id去获取session
	 * @param id
	 * @return
	 */
	public String getSession(int id);
	
	/**
	 * 更新数据库中的session
	 * @param id
	 */
	public void updateSession(String name, String session);
}
