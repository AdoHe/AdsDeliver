/**
 * 
 */
package edu.tongji.se.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.tongji.se.dao.AccountDao;
import edu.tongji.se.dao.RecordDao;
import edu.tongji.se.model.Account;
import edu.tongji.se.model.Record;
import edu.tongji.se.model.User;
import edu.tongji.se.service.AccountService;

/**
 * @author hezibo
 *
 */
public class AccountServiceImpl implements AccountService 
{
	private AccountDao mAccountDao;
	private RecordDao mRecordDao;
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
		List<Account> accounts = (ArrayList<Account>)mAccountDao.findByUser(user);
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
	public void saveAccountRecharge(Account account, int number) 
	{
		int currentBalance = account.getAcBalance();
		account.setAcBalance(currentBalance + number);
		mAccountDao.save(account);

		Record record = new Record();
		record.setAccount(account);
		record.setReIncome(number);
		record.setReCategory("充值");
		record.setReDate(new Timestamp(System.currentTimeMillis()));
		record.setReOutcome(0);
		record.setReBalance(currentBalance + number);
		
		mRecordDao.save(record);
	}

	@Override
	public List<Record> getAccountRecords(String userName, int offset,
			int length) {
		// TODO Auto-generated method stub
		return mRecordDao.findRe(userName, offset, length);
	}
	
	@Override
	public int getRecordsCount(String userName) {
		return mRecordDao.getCount(userName);
	}

	public AccountDao getmAccountDao() 
	{
		return mAccountDao;
	}

	public void setmAccountDao(AccountDao mAccountDao) 
	{
		this.mAccountDao = mAccountDao;
	}

	public RecordDao getmRecordDao() {
		return mRecordDao;
	}

	public void setmRecordDao(RecordDao mRecordDao) {
		this.mRecordDao = mRecordDao;
	}

	@Override
	public void updateAccount(Account account, float fee) {
		int currentBalance = account.getAcBalance();
		account.setAcBalance(currentBalance - (int)fee);
		mAccountDao.save(account);
		
		Record record = new Record();
		record.setAccount(account);
		record.setReIncome(0);
		record.setReOutcome((int)fee);
		record.setReCategory("广告费扣除");
		record.setReBalance(currentBalance - (int)fee);
		record.setReDate(new Timestamp(System.currentTimeMillis()));
		
		mRecordDao.save(record);
	}
}
