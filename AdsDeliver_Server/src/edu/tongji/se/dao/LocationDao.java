/**
 * 
 */
package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Location;

/**
 * @author hezibo
 *
 */
public interface LocationDao 
{
	//save a location
	public void save(Location transientInstance);
	
	//delete a location
	public void delete(Location persistentInstance);
	
	//find a location by id
	public Location findById(java.lang.Long id);
	
	//find location by property
	public List findByProperty(String propertyName, Object value);
	
	//get all locations
	public List findAll();
	
}
