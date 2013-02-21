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
	 * 验证用户
	 * @param name
	 * @param pwd
	 * @return
	 */
	@WebMethod(action = "validateUser")
	public int validateUser(@WebParam(name="name") String name, 
			@WebParam(name="password") String pwd);
	
	/**
	 * 更新用户密码
	 * @param id
	 * @param pwd
	 */
	@WebMethod(action = "updateUserPwd")
	public void updateUserPwd(@WebParam(name="id") int id,
			@WebParam(name="newPwd") String pwd);
	
	/**
	 * 通过id获取session
	 * @param id
	 * @return
	 */
	@WebMethod(action = "getSessionById")
	public String getSessionById(@WebParam(name="id") int id);
	
	/**
	 * 更新用户账户
	 * @param id
	 * @param account
	 */
	public void updateUserAccount(int id, Account account);
}
