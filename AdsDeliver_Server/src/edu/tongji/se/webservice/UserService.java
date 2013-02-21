/**
 * 
 */
package edu.tongji.se.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.tongji.se.model.Account;

/**
 * @author hezibo
 *
 */
@WebService
public interface UserService 
{
	/**
	 * ��֤�û�
	 * @param name
	 * @param pwd
	 * @return
	 */
	@WebMethod(action = "validateUser")
	public int validateUser(@WebParam(name="name") String name, 
			@WebParam(name="password") String pwd);
	
	/**
	 * �����û�����
	 * @param id
	 * @param pwd
	 */
	@WebMethod(action = "updateUserPwd")
	public void updateUserPwd(@WebParam(name="id") int id,
			@WebParam(name="newPwd") String pwd);
	
	/**
	 * ͨ��id��ȡsession
	 * @param id
	 * @return
	 */
	@WebMethod(action = "getSessionByName")
	public String getSessionByName(@WebParam(name="name") String name);
	
	/**
	 * �����û��˻�
	 * @param id
	 * @param account
	 */
	public void updateUserAccount(int id, Account account);
}
