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
	 * 验证用户
	 * @return
	 */
	@WebMethod(action = "validateUser")
	public int validateUser(@WebParam(name="name") String name, 
			@WebParam(name="password") String pwd);
}
