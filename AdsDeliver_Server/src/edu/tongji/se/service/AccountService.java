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
	public void saveAccountRecharge(Account account, int number);
	
	/**
	 * �鿴���׼�¼
	 * @param
	 */
	public List<Record> getAccountRecords(String userName, int offset, int length);
}
