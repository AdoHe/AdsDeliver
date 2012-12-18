/**
 * 
 */
package edu.tongji.se.serviceImpl;

import java.util.List;

import edu.tongji.se.daoImpl.AdministratorDaoImpl;
import edu.tongji.se.model.Administrator;
import edu.tongji.se.service.AdminService;
import edu.tongji.se.tools.Encry;

/**
 * @author hezibo
 *
 */
public class AdminServiceImpl implements AdminService 
{
	private AdministratorDaoImpl mAdminDao;
	
	/* (non-Javadoc)
	 * @see edu.tongji.se.service.AdminService#validateAdmin(java.lang.String, java.lang.String)
	 */
	@Override
	public int validateAdmin(String name, String password) 
	{
		// TODO Auto-generated method stub
		List<Administrator> admin = (List<Administrator>)mAdminDao.findByAdName((Object)name);
		
		if(admin.size() != 0)
		{
			String salt = admin.get(0).getAdRand();
			String pwdInDb = admin.get(0).getAdPassword();
			
			if(Encry.checkPasswordByInput(password, salt, pwdInDb))
				return 1; //login successfully
			else
				return 2; //the password is wrong
		}else
		{
			return 3; //there is no such an administrator
		}
	}

	public AdministratorDaoImpl getmAdminDao() {
		return mAdminDao;
	}

	public void setmAdminDao(AdministratorDaoImpl mAdminDao) {
		this.mAdminDao = mAdminDao;
	} 
}
