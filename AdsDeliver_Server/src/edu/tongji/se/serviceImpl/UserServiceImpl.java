package edu.tongji.se.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import edu.tongji.se.daoImpl.UserDaoImpl;
import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.model.Userinfo;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.Encry;

public class UserServiceImpl implements UserService {

	private UserDaoImpl mUserDao;
	
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
		
		Account account = new Account();
		account.setAcBalance(0);
		
		user.setUserinfo(userInfo);
		user.setAccount(account);
		
		mUserDao.save(user);
	}

	@Override
	public void delUser(User user) {
		mUserDao.delete(user);
	}

	public void setmUserDao(UserDaoImpl mUserDao) {
		this.mUserDao = mUserDao;
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
		return ((ArrayList<User>)mUserDao.findByUsName(name)).get(0);
	}

	@Override
	public void updateUserAccount(int id, Account account) {
		User user = mUserDao.findById(id);
		user.setAccount(account);
		
		mUserDao.save(user);
	}
	
	
}
