/**
 * 
 */
package edu.tongji.se.service;

import java.util.List;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.Record;
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
	
	/**
	 * 查看交易记录
	 * @param
	 */
	public List<Record> getAccountRecords(String userName, int offset, int length);

	/**
	 * 得到用户的账户交易记录
	 * @param userName
	 * @return
	 */
	public int getRecordsCount(String userName);
	
	/**
	 * 更新用户的账户，用于广告费的扣除
	 * @param id
	 * @param fee
	 */
	public void updateAccount(Account account, float fee);
}
