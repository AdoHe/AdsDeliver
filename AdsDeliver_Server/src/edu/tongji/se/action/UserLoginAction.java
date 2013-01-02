package edu.tongji.se.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.service.AdminService;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.AuthorInterceptor;

public class UserLoginAction extends ActionSupport implements SessionAware, CookiesAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserService mUserService;
	
	private AdminService mAdminService;
	
	private String loginname;
	
	private String password;
	
	private boolean remember;
	
	private int select;
	
	private String gtUrl;
	
	private int result;
	
	private Map<String, Object> session;
	private Map<String, String> cookies;
	
	public void setmUserService(UserService mUserService) {
		this.mUserService = mUserService;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginname() {
		return loginname;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	private void storeCookie()
	{
		if(result == 1) 
		{
			session.put(AuthorInterceptor.USER_SESSION_KEY, loginname);
			
			//ÃÌº”cookie÷ß≥÷
			if(remember)
			{
				Cookie cookie = new Cookie(AuthorInterceptor.USER_COOKIE_KEY, loginname + "==" + password);
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
				this.setGtUrl("UserLoginPage.action");
			}
		}
	}
	
	public String login() throws Exception 
	{
		
		if(select == 2)
		{
			result = mUserService.validateUser(loginname, password);
			storeCookie();
			
			return SUCCESS;
		}else
		{
			result = mAdminService.validateAdmin(loginname, password);
			storeCookie();
			
			return SUCCESS;
		}
	}
	
	public String loginPage() throws Exception
	{
		return "LOGIN_PAGE";
	}
	
	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		// TODO Auto-generated method stub
		this.cookies = cookies;
	}

	public String getGtUrl() {
		return gtUrl;
	}

	public void setGtUrl(String gtUrl) {
		this.gtUrl = gtUrl;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public void setmAdminService(AdminService mAdminService) {
		this.mAdminService = mAdminService;
	}
	
}
