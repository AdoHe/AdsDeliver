/**
 * 
 */
package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;

/**
 * @author hezibo
 *
 */
public interface AccountDao 
{
	//save an account
	public void save(Account transientInstance);
	
	//delete an account
	public void delete(Account persistentInstance);
	
	//find account by id
	public Account findById(java.lang.Integer id);
	
	//find account by one property
	public List findByProperty(String propertyName, Object value);
	
	//get all account
	public List findAll();
	
	//merge two accounts
	public Account merge(Account detachedInstance);
	
	public List findByUser(User user);
}
