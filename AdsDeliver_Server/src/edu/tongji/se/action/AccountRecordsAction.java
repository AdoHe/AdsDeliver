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
	
	private int start;
	
	private int length;
	
	private int totalPage = 0;
	
	private int count = 0;
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}
	
//	public String firstTenRecords()
//	{
//		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY) ?
//				(String)session.get(AuthorInterceptor.USER_SESSION_KEY):"";
//				
//		if(records != null) {
//			//records.clear();
//		}
//		records = (ArrayList<Record>) mAccountService.getAccountRecords(userName, 0, 10);
//		
//		if(records.size() <= 5)
//		{
//			totalPage = 1;
//		}else
//		{
//			totalPage = ((totalPage%5)==0)?(totalPage/5):(totalPage/5+1);
//		}
//		
//		return SUCCESS;
//	}
	
	public String getPagedRecords() {
		
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY) ?
				(String)session.get(AuthorInterceptor.USER_SESSION_KEY):"";
		
		if(records != null) {
			//records.clear();
		}
		records = (ArrayList<Record>) mAccountService.getAccountRecords(userName, start, length);
		
		count = mAccountService.getRecordsCount(userName);
		return SUCCESS;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	
	

}
