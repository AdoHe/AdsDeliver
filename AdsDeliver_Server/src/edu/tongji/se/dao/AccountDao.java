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
	/**
	 * 保存账户
	 * @param transientInstance
	 */
	public void save(Account transientInstance);
	
	/**
	 * 删除某个账户
	 * @param persistentInstance
	 */
	public void delete(Account persistentInstance);
	
	/**
	 * 通过id获得账户
	 * @param id
	 * @return
	 */
	public Account findById(java.lang.Integer id);
	
	/**
	 * 通过某个属性获得账户
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByProperty(String propertyName, Object value);
	
	/**
	 * 得到所有的账户
	 * @return
	 */
	public List findAll();
	
	/**
	 * 合并两个账户
	 * @param detachedInstance
	 * @return
	 */
	public Account merge(Account detachedInstance);
	
	/**
	 * 获取某个用户的账户
	 * @param user
	 * @return
	 */
	public List findByUser(User user);
}
