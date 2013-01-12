/**
 * 
 */
package edu.tongji.se.serviceImpl;

import java.util.List;

import edu.tongji.se.dao.AdministratorDao;
import edu.tongji.se.model.Administrator;
import edu.tongji.se.service.AdminService;
import edu.tongji.se.tools.Encry;

/**
 * @author hezibo
 *
 */
public class AdminServiceImpl implements AdminService 
{
	private AdministratorDao mAdminDao;
	
	/* (non-Javadoc)
	 * @see edu.tongji.se.service.AdminService#validateAdmin(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int validateAdmin(String name, String password) 
	{
		// TODO Auto-generated method stub
		List<Administrator> admin = (List<Administrator>)mAdminDao.findByProperty("adName", (Object)name);
		
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

	public AdministratorDao getmAdminDao() {
		return mAdminDao;
	}

	public void setmAdminDao(AdministratorDao mAdminDao) {
		this.mAdminDao = mAdminDao;
	}

	@Override
	public void addAdmin(String name, String password, String rand, short level) {
		// TODO Auto-generated method stub
		Administrator admin = new Administrator();
		
		admin.setAdName(name);
		admin.setAdPassword(password);
		admin.setAdRand(rand);
		admin.setAdLevel(level);
		
		mAdminDao.save(admin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> getAdmins() {
		// TODO Auto-generated method stub
		return (List<Administrator>)mAdminDao.findAll();
	}

	@Override
	public void deleteAdmin(short id) {
		// TODO Auto-generated method stub
		mAdminDao.delete(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Administrator findAdmin(String name) {
		// TODO Auto-generated method stub
		List<Administrator> admins = (List<Administrator>)mAdminDao.findByProperty("adName", (Object)name);
		
		if(admins != null & admins.size() > 0)
			return admins.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Administrator> getAdmins(short level, int offset, int length) {
		// TODO Auto-generated method stub
		return mAdminDao.findAll(level, offset, length);
	} 
}
