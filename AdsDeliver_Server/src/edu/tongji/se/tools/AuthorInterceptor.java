/**
 * 
 */
package edu.tongji.se.tools;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import edu.tongji.se.serviceImpl.UserServiceImpl;

/**
 * @author hezibo
 *
 */
public class AuthorInterceptor extends AbstractInterceptor 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String USER_SESSION_KEY = "AD_SESSION_NAME";
	public static final String USER_COOKIE_KEY = "AD_COOKIE_NAME";
	public static final String GOING_TO_URL_KEY = "GOING_TO";

	private UserServiceImpl mUserService;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception 
	{
		// TODO Auto-generated method stub
		String name = invocation.getInvocationContext().getName();
		
		if(name.equals("LoginIn"))
		{
			return invocation.invoke();
		}else 
		{
			ActionContext ac = invocation.getInvocationContext();
			HttpServletRequest request = (HttpServletRequest)ac.get(StrutsStatics.HTTP_REQUEST);
			Map<String, Object> session = (Map<String, Object>)ac.get(ServletActionContext.SESSION);
			
			if(session != null && session.get(USER_SESSION_KEY) != null)
			{
				return invocation.invoke();
			}
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null)
			{
				for(Cookie cookie : cookies)
				{
					if(USER_COOKIE_KEY.equals(cookie.getName()))
					{
						String value = cookie.getValue();
						if(StringUtils.isNotBlank(value))
						{
							String[] split = value.split("==");
							String username = split[0];
							String password = split[1];
							
							if(mUserService.validateUser(username, password) == 1)
							{
								session.put(USER_SESSION_KEY, username);
							}
						}else
						{
							setGoingToURL(session, invocation);
							return "login";
						}
						
						return invocation.invoke();
					}
				}
			}
			
			setGoingToURL(session, invocation);
			return "login";
		}
	}
	
	private void setGoingToURL(Map<String, Object> session, ActionInvocation invocation)
	{
		String url = "";
		
		String namespace = invocation.getProxy().getNamespace();
		if(StringUtils.isNotBlank(namespace) && !namespace.equals("/"))
		{
			url += namespace;
		}
		
		String actionName = invocation.getProxy().getActionName();
		if(StringUtils.isNotBlank(actionName))
		{
			url += actionName;
		}
		
		session.put(GOING_TO_URL_KEY, url);
	}

	public UserServiceImpl getmUserService() {
		return mUserService;
	}

	public void setmUserService(UserServiceImpl mUserService) {
		this.mUserService = mUserService;
	}
}
