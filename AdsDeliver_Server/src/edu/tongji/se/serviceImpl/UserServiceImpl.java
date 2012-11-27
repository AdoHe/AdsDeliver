package edu.tongji.se.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import edu.tongji.se.dao.AccountDao;
import edu.tongji.se.dao.UserDao;
import edu.tongji.se.dao.UserinfoDao;
import edu.tongji.se.daoImpl.UserDaoImpl;
import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.model.Userinfo;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.Encry;

public class UserServiceImpl implements UserService {

	private UserDao mUserDao;
	private UserinfoDao mUserinfoDao;
	private AccountDao mAccountDao;
	
	@Override
	public int validateUser(String name, String password) {
		
		List<User> lstUsers = mUserDao.findByUsName((Object)name);
		
		if(lstUsers.size() != 0) {
			String salt = lstUsers.get(0).getUsRand();
			String pwdInDb = lstUsers.get(0).getUsPassword();
		
			if(Encry.checkPasswordByInput(password, salt, pwdInDb))
				return 1; //login successfully
			else
				return 2; //the password is wrong
		}else
		{
			return 3; //there is no such a user
		}
		
	}

	@Override
	public void addUser(String name, String passwd, String rand, 
			String realName, String corperation, String mobilePhone,
			String telePhone, String address, int status) {
		User user = new User();
		user.setUsName(name);
		user.setUsPassword(passwd);
		user.setUsRand(rand);
		
		Userinfo userInfo = new Userinfo();
		userInfo.setUfName(realName);
		userInfo.setUfAddress(address);
		userInfo.setUfCorperation(corperation);
		userInfo.setUfMobilePhone(mobilePhone);
		userInfo.setUfTelephone(telePhone);
		userInfo.setUfStatus((short)status);
		userInfo.setUser(user);
		
		Account account = new Account();
		account.setAcBalance(0);
		account.setUser(user);
		
		user.setUserinfo(userInfo);
		user.setAccount(account);
		mUserinfoDao.save(userInfo);
		mAccountDao.save(account);
		mUserDao.save(user);
	}

	@Override
	public void delUser(User user) {
		mUserDao.delete(user);
	}

	public void setmUserDao(UserDao mUserDao) {
		this.mUserDao = mUserDao;
	}
	

	public void setmUserinfoDao(UserinfoDao mUserinfoDao) {
		this.mUserinfoDao = mUserinfoDao;
	}

	public void setmAccountDao(AccountDao mAccountDao) {
		this.mAccountDao = mAccountDao;
	}

	@Override
	public void updateUserInfo(int id, Userinfo userinfo) {
		User user = mUserDao.findById(id);
		user.setUserinfo(userinfo);
		
		mUserDao.save(user);
	}

	@Override
	public User findUser(int id) {
		return mUserDao.findById(id);
		
	}

	@Override
	public User findUser(String name) {
		List<User> result = (ArrayList<User>)mUserDao.findByUsName(name);
		if(result != null & result.size() > 0)
			return result.get(0);
		else 
			return null;
	}

	@Override
	public void updateUserAccount(int id, Account account) {
		User user = mUserDao.findById(id);
		user.setAccount(account);
		
		mUserDao.save(user);
	}
	
	
}
