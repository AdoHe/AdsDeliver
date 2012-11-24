/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.serviceImpl.AdminServiceImpl;

/**
 * @author hezibo
 *
 */
public class LoginInAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session; //implements SessionAware interface to get the access to session
	
	private AdminServiceImpl mAdminService;
	
	private String name = null;
	private String password;
	/**
	 * 
	 */
	public LoginInAction() 
	{
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		if(name == null)
			return "LOGIN";
		
		if(mAdminService.validateAdmin(name, password) == 1)
		{
			session.put("AD_NAME", name);
			
			return "SUCCESS";
		}else
		{
			return "FAIL";
		}
	}

	public AdminServiceImpl getmAdminService() {
		return mAdminService;
	}

	public void setmAdminService(AdminServiceImpl mAdminService) {
		this.mAdminService = mAdminService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
