package edu.tongji.se.webserviceImpl;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.jws.WebService;

import edu.tongji.se.dao.AccountDao;
import edu.tongji.se.dao.UserDao;
import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.webservice.AccountService;

@WebService(endpointInterface="edu.tongji.se.webservice.AccountService")
public class AccountServiceImpl implements AccountService 
{
	private UserDao mUserDao;
	private AccountDao mAccountDao;
	
	@Override
	public int getAccountBalance(String userName) 
	{
		User user = ((ArrayList<User>)mUserDao.findByUsName(userName)).get(0);
		Account account = ((ArrayList<Account>)mAccountDao.findByUser(user)).get(0);
		return account.getAcBalance();
	}

	@Resource(name="AccountDAO")
	public void setmAccountDao(AccountDao mAccountDao) 
	{
		this.mAccountDao = mAccountDao;
	}

	public void setmUserDao(UserDao mUserDao) {
		this.mUserDao = mUserDao;
	}
	
	

}
