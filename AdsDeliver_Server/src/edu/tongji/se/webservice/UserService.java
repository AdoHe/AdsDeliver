/**
 * 
 */
package edu.tongji.se.webservice;

import javax.jws.WebMethod;
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
	public int validateUser(String name, String pwd);
}
