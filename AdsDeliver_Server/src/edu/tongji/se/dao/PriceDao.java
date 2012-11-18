/**
 * 
 */
package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Price;

/**
 * @author hezibo
 *
 */
public interface PriceDao 
{
	//save a price
	public void save(Price transientInstance);
	
	//delete a price
	public void delete(Price persistentInstance);
	
	//find a price by id
	public Price findById(java.lang.Short id);
	
	//find a price by property
	public List findByProperty(String propertyName, Object value);
	
	//get all prices
	public List findAll();
}
