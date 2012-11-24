/**
 * 
 */
package edu.tongji.se.tools;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

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

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
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
			Map session = (Map)ac.get(ServletActionContext.SESSION);
			
			if(session == null)
			{
				return Action.LOGIN;
			}else
			{
				String username = (String)session.get("USERNAME");
				
				if(username == null)
				{
					return Action.LOGIN;
				}else
				{
					return invocation.invoke();
				}
			}
		}
	}

}
