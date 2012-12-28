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
	 * �����˻�
	 * @param transientInstance
	 */
	public void save(Account transientInstance);
	
	/**
	 * ɾ��ĳ���˻�
	 * @param persistentInstance
	 */
	public void delete(Account persistentInstance);
	
	/**
	 * ͨ��id����˻�
	 * @param id
	 * @return
	 */
	public Account findById(java.lang.Integer id);
	
	/**
	 * ͨ��ĳ�����Ի���˻�
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByProperty(String propertyName, Object value);
	
	/**
	 * �õ����е��˻�
	 * @return
	 */
	public List findAll();
	
	/**
	 * �ϲ������˻�
	 * @param detachedInstance
	 * @return
	 */
	public Account merge(Account detachedInstance);
	
	/**
	 * ��ȡĳ���û����˻�
	 * @param user
	 * @return
	 */
	public List findByUser(User user);
}
