/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.service.AccountService;

/**
 * @author hezibo
 *
 */
public class AccountManageAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AccountService mAccountService;
	
	private void putResultIntoRequest()
	{
		
	}
	
	public String accountCheck()
	{
		putResultIntoRequest();
		return "SUCCESS";
	}
	
	@Override
	public String execute() throws Exception 
	{
		// TODO Auto-generated method stub
		return super.execute();
	}
	public AccountService getmAccountService() 
	{
		return mAccountService;
	}
	public void setmAccountService(AccountService mAccountService) 
	{
		this.mAccountService = mAccountService;
	}
}
