/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.service.AccountService;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.AuthorInterceptor;

/**
 * @author hezibo
 *
 */
public class AccountManageAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AccountService mAccountService;
	private UserService mUserService;
	
	private int balance;
	
	private int rechargeAmount;
	
	private Map<String, Object> session;
	
	private static final Logger log = LoggerFactory.getLogger(AccountManageAction.class);
	
	public void setmUserService(UserService mUserService) {
		this.mUserService = mUserService;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

	public int getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(int rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	private void putResultIntoRequest()
	{
		
	}
	
	public String accountCheck()
	{
		putResultIntoRequest();
		return SUCCESS;
	}
	
	// 查看余额
	public String getUserBalance() throws Exception 
	{
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY) ? 
				(String)session.get(AuthorInterceptor.USER_SESSION_KEY) : "";
		User user = mUserService.findUser(userName);
		
		balance = user.getAccount().getAcBalance();
		log.debug("balance:::::" + balance);
		
		return SUCCESS;
	}
	
	// 充值 
	public String recharge() throws Exception {
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY) ? 
				(String)session.get(AuthorInterceptor.USER_SESSION_KEY) : "";
		User user = mUserService.findUser(userName);
		
		Account account = user.getAccount();
		mAccountService.saveAccountRecharge(account, rechargeAmount);
		
		return SUCCESS;
	}
	
	// 查看余额界面
	public String accountPage() throws Exception {
		return "ACCOUNT_PAGE";
	}
	
	public String rechargePage() throws Exception {
		return "RECHARGE_PAGE";
	}
	
	public void setmAccountService(AccountService mAccountService) 
	{
		this.mAccountService = mAccountService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}
}
