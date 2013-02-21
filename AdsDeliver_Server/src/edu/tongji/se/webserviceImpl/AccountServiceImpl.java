package edu.tongji.se.webserviceImpl;

import javax.annotation.Resource;
import javax.jws.WebService;

import edu.tongji.se.dao.AccountDao;
import edu.tongji.se.model.Account;
import edu.tongji.se.webservice.AccountService;

@WebService(endpointInterface="edu.tongji.se.webservice.AccountService")
public class AccountServiceImpl implements AccountService 
{
	private AccountDao mAccountDao;
	
	@Override
	public int getAccountBalance(int id) 
	{
		// TODO Auto-generated method stub
		Account account = mAccountDao.findById(id);
		return account.getAcBalance();
	}
	
	@Resource(name="AccountDAO")
	public void setmAccountDao(AccountDao mAccountDao) 
	{
		this.mAccountDao = mAccountDao;
	}

}
