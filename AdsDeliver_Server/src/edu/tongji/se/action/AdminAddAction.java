/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.service.AdminService;
import edu.tongji.se.tools.Encry;

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
	
	private String name;
	private String password;
	private int level;
	private int result;
	
	private AdminService mAdminService;
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

	public String addAdmin()
	{
		if(mAdminService.findAdmin(name) != null)
		{
			result = 2;
			return SUCCESS;
		}else
		{
			String randString = Encry.generateSalt();
			String passwordInDb = Encry.generatePasswordInDatabase(password, randString);
			
			mAdminService.addAdmin(name, passwordInDb, randString, (short)level);
			
			result = 1;
			return SUCCESS;
		}
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setmAdminService(AdminService mAdminService) {
		this.mAdminService = mAdminService;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
