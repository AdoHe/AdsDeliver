/**
 * 
 */
package edu.tongji.se.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Record;
import edu.tongji.se.service.AccountService;
import edu.tongji.se.tools.AuthorInterceptor;

/**
 * @author hezibo
 *
 */
public class AccountRecordsAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	
	private ArrayList<Record> records;
	
	private AccountService mAccountService;
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	public String getRecord()
	{
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY) ?
				(String)session.get(AuthorInterceptor.USER_SESSION_KEY):"";
				
		records = (ArrayList<Record>) mAccountService.getAccountRecords(userName, 0, 3);
		
		return SUCCESS;
	}
	
	public AccountService getmAccountService() {
		return mAccountService;
	}

	public void setmAccountService(AccountService mAccountService) {
		this.mAccountService = mAccountService;
	}

	public ArrayList<Record> getRecords() {
		return records;
	}
	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

}
