/**
 * 
 */
package edu.tongji.se.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author hezibo
 *
 */
@WebService
public interface UserService 
{
	/*
	 * ��֤�û�
	 * @return
	 */
	@WebMethod(action = "validateUser")
	public int validateUser(@WebParam(name="name") String name, 
			@WebParam(name="password") String pwd);
	
	/*
	 * �����û�����
	 * @return
	 */
	@WebMethod(action = "updateUserPwd")
	public void updateUserPwd(@WebParam(name="id") int id,
			@WebParam(name="newPwd") String pwd);
}
