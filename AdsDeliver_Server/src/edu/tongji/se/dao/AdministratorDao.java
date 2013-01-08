/**
 * 
 */
package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Administrator;
import edu.tongji.se.model.Advertisement;

/**
 * @author hezibo
 *
 */
public interface AdministratorDao 
{
	//save an administrator
	public void save(Administrator transientInstance);
	
	//delete an administrator
	public void delete(Administrator persistentInstance);
	
	//find an administrator by id
	public Administrator findById(java.lang.Short id);
	
	//find administrators by one property
	public List findByProperty(String propertyName, Object value);
	
	//get all administrators
	public List findAll();
	
	//merge two administrators
	public Administrator merge(Administrator detachedInstance);
	
	//get all administrator for cancel
	public List findAll(short level, int offset, int length);
}
