/**
 * 
 */
package edu.tongji.se.service;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;

/**
 * @author hezibo
 *
 */
public interface AccountService 
{ 
	/**
	 * 查看账户余额
	 * @param id
	 * @return
	 */
	public int getAccountBalance(int id);
	
	/**
	 * 查看账户余额
	 * @param user
	 * @return
	 */
	public int getAccountBalance(User user);
	
	/**
	 * 账户充值
	 * @param user
	 * @param number
	 */
	public void saveAccountRecharge(Account account, int number);
}
