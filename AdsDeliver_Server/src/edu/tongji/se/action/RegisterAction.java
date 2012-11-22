/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.serviceImpl.UserServiceImpl;

/**
 * @author hezibo
 *
 */
public class RegisterAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String password;
	private String passwordAck;
	
	private UserServiceImpl mUserService;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getPasswordAck() 
	{
		return passwordAck;
	}
	public void setPasswordAck(String passwordAck) 
	{
		this.passwordAck = passwordAck;
	}
	
	
	public RegisterAction() 
	{
	}
	
	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		return "SUCCESS";
	}
	public UserServiceImpl getmUserService() 
	{
		return mUserService;
	}
	public void setmUserService(UserServiceImpl mUserService) 
	{
		this.mUserService = mUserService;
	}
	
	
}
