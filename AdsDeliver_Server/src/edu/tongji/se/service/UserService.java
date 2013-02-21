package edu.tongji.se.service;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.model.Userinfo;

public interface UserService {
	
	/**
	 * ��֤�û�
	 * @return
	 */
	public int validateUser(String name, String password);
	
	/**
	 * ����û�
	 * @param name
	 * @param passwd
	 */
	public void addUser(String name, String passwd, String rand, 
			String realName, String corperation, String mobilePhone,
			String telePhone, String address, int status);
	
	/**
	 * ɾ���û�
	 * @param id
	 */
	public void delUser(User user);
	
	/**
	 * �����û�����
	 * @param userinfo
	 */
	public void updateUserInfo(int id, Userinfo userinfo);
	
	/**
	 * ����id��ȡUser
	 * @param id
	 * @return
	 */
	public User findUser(int id);
	
	/**
	 * �����û�����ȡUser����
	 * @param name
	 * @return
	 */
	public User findUser(String name);
	
	/**
	 * 
	 * @param id
	 * @param account
	 */
	public void updateUserAccount(int id, Account account);
	
	
	/**
	 * 
	 */
	public void updateUserPwd(int id, String newPwd);
	
}

