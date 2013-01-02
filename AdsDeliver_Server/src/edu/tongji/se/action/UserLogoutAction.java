/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.tools.AuthorInterceptor;

/**
 * @author hezibo
 *
 */
public class UserLogoutAction extends ActionSupport implements ServletRequestAware, ServletResponseAware 
{
	private HttpServletRequest request;
	private HttpServletResponse response;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null)
			session.removeAttribute(AuthorInterceptor.USER_SESSION_KEY);
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if(AuthorInterceptor.USER_COOKIE_KEY.equals(cookie.getName()))
				{
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					return "login";
				}
			}
		}
		
		return "login";
	}

	@Override
	public void setServletResponse(HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) 
	{
		// TODO Auto-generated method stub
		this.request = request;
	}
}
