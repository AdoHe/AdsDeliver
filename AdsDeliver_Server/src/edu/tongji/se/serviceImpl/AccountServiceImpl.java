/**
 * 
 */
package edu.tongji.se.serviceImpl;

import java.util.List;

import edu.tongji.se.dao.AccountDao;
import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.service.AccountService;

/**
 * @author hezibo
 *
 */
public class AccountServiceImpl implements AccountService 
{
	private AccountDao mAccountDao;
	/* (non-Javadoc)
	 * @see edu.tongji.se.service.AccountService#getAccountBalance(int)
	 */
	@Override
	public int getAccountBalance(int id) 
	{
		// TODO Auto-generated method stub
		Account account = mAccountDao.findById(id);
		return account.getAcBalance();
	}

	/* (non-Javadoc)
	 * @see edu.tongji.se.service.AccountService#getAccountBalance(edu.tongji.se.model.User)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int getAccountBalance(User user) 
	{
		// TODO Auto-generated method stub
		List<Account> accounts = (List<Account>)mAccountDao.findByProperty("user", user);
		if(accounts.size() != 0)
		{
			Account account = accounts.get(0);
			return account.getAcBalance();
		}
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.tongji.se.service.AccountService#accountRecharge(edu.tongji.se.model.User, int)
	 */
	@Override
	public void accountRecharge(User user, int number) 
	{
		// TODO Auto-generated method stub

	}

	public AccountDao getmAccountDao() 
	{
		return mAccountDao;
	}

	public void setmAccountDao(AccountDao mAccountDao) 
	{
		this.mAccountDao = mAccountDao;
	}

}
