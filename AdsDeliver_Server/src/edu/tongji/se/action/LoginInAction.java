/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.serviceImpl.AdminServiceImpl;
import edu.tongji.se.tools.AuthorInterceptor;

/**
 * @author hezibo
 *
 */
public class LoginInAction extends ActionSupport implements SessionAware, CookiesAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session; //implements SessionAware interface to get the access to session
	private Map<String, String> cookie; //implements CookiesAware to get the access to cookie
	
	
	private AdminServiceImpl mAdminService;
	
	private String name = null;
	private String password;
	private boolean remember;
	private String gtUrl;
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
			//add user name to session
			session.put(AuthorInterceptor.USER_SESSION_KEY, name);
			
			//add session name to cookie
			if(remember == true)
			{
				Cookie cookie = new Cookie(AuthorInterceptor.USER_COOKIE_KEY, name + "==" + password);
				cookie.setMaxAge(60*60*24*30);
				cookie.setPath("/");
				HttpServletResponse response = ServletActionContext.getResponse();
				response.addCookie(cookie);
			}
			
			String goingToUrl = (String)session.get(AuthorInterceptor.GOING_TO_URL_KEY);
			if(StringUtils.isNotBlank(goingToUrl))
			{
				this.setGtUrl(goingToUrl);
				session.remove(AuthorInterceptor.GOING_TO_URL_KEY);
			}else
			{
				this.setGtUrl("");
			}
			
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

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	@Override
	public void setCookiesMap(Map<String, String> cookie) {
		// TODO Auto-generated method stub
		this.cookie = cookie;
	}

	public String getGtUrl() {
		return gtUrl;
	}

	public void setGtUrl(String gtUrl) {
		this.gtUrl = gtUrl;
	}

}
