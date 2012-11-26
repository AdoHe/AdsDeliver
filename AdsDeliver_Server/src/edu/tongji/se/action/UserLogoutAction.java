/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hezibo
 *
 */
public class UserLogoutAction extends ActionSupport implements SessionAware 
{
	private Map<String, Object> session;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		this.session.clear();
		return "SUCCESS";
	}
}
