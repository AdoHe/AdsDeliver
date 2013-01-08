/**
 * 
 */
package edu.tongji.se.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Administrator;
import edu.tongji.se.service.AdminService;
import edu.tongji.se.tools.AuthorInterceptor;

/**
 * @author hezibo
 *
 */
public class AdminCancelAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(AdminCancelAction.class);

	private Map<String, Object> session;
	
	private String str;
	
	private int result;
	
	private int start;
	private int length;
	private int count;
	
	private ArrayList<Administrator> admins;
	
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
	
	public String adminCancelPage()
	{
		return "ADMIN_CANCEL";
	}
	
	public String adminCancel()
	{
		log.debug("this is the str" + str);
		
		String adminName = (String)session.get(AuthorInterceptor.USER_SESSION_KEY);
		Administrator administrator = mAdminService.findAdmin(adminName);
		
		if(administrator.getAdLevel() == 1)
		{
			result = 1;
			String[] strs = str.split(",");
			
			for(int i = 0; i < strs.length; i++)
			{
				int id = Integer.valueOf(strs[i]);
				mAdminService.deleteAdmin((short)id);
			}
			
			return SUCCESS;
		}else
		{
			result = 2;
			return SUCCESS;
		}
	}
	
	public String getPagedAdminForCancel()
	{
		admins = (ArrayList<Administrator>)mAdminService.getAdmins((short)2, start, length);
		count = admins.size();
		
		return SUCCESS;
	}
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
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

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<Administrator> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<Administrator> admins) {
		this.admins = admins;
	}

}
