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
public class AdminAddAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}

	public String adminAddPage()
	{
		return "ADD_ADMIN";
	}
}
