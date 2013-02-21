/**
 * 
 */
package edu.tongji.se.webserviceImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import edu.tongji.se.dao.UserDao;
import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.tools.Encry;
import edu.tongji.se.tools.SessionUtil;
import edu.tongji.se.webservice.UserService;

/**
 * @author hezibo
 *
 */
@WebService(endpointInterface = "edu.tongji.se.webservice.UserService")
public class UserServiceImpl implements UserService 
{
	private UserDao mUserDao;
	/* (non-Javadoc)
	 * @see edu.tongji.se.webservice.UserService#validateUser(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int validateUser(String name, String pwd) 
	{
		// TODO Auto-generated method stub
		System.out.println("Validate user is called");
		List<User> lstUsers = mUserDao.findByUsName((Object)name);
		
		if(lstUsers.size() != 0) {
			String salt = lstUsers.get(0).getUsRand();
			String pwdInDb = lstUsers.get(0).getUsPassword();
		
			if(Encry.checkPasswordByInput(pwd, salt, pwdInDb))
			{
				String session = SessionUtil.generateSessionId();
				//mUserDao.updateSession(name, session);
				System.out.println("The session is:" + session);
				return 1; //login successfully
			}else
			{
				return 2; //the password is wrong
			}
		}else
		{
			return 3; //there is no such a user
		}
	}

	@Override
	public void updateUserPwd(int id, String pwd) 
	{
		// TODO Auto-generated method stub
		User user = mUserDao.findById(id);
		
		String newRand = Encry.generateSalt();
		String password = Encry.generatePasswordInDatabase(pwd, newRand);
		
		user.setUsPassword(password);
		user.setUsRand(newRand);
		
		mUserDao.save(user);
	}

	@Override
	public String getSessionById(int id) 
	{
		// TODO Auto-generated method stub
		return mUserDao.getSession(id);
	}

	@Resource(name="UserDAO")
	public void setmUserDao(UserDao mUserDao) 
	{
		this.mUserDao = mUserDao;
	}

	@Override
	public void updateUserAccount(int id, Account account) 
	{
		// TODO Auto-generated method stub
		User user = mUserDao.findById(id);
		user.setAccount(account);
		
		mUserDao.save(user);
	}

}
