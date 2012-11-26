/**
 * 
 */
package edu.tongji.se.service;

import edu.tongji.se.model.User;

/**
 * @author hezibo
 *
 */
public interface AccountService 
{ 
	/**
	 * �鿴�˻����
	 * @param id
	 * @return
	 */
	public int getAccountBalance(int id);
	
	/**
	 * �鿴�˻����
	 * @param user
	 * @return
	 */
	public int getAccountBalance(User user);
	
	/**
	 * �˻���ֵ
	 * @param user
	 * @param number
	 */
	public void accountRecharge(User user, int number);
}
