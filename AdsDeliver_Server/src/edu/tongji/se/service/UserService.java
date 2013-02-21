package edu.tongji.se.service;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.User;
import edu.tongji.se.model.Userinfo;

public interface UserService {
	
	/**
	 * 验证用户
	 * @return
	 */
	public int validateUser(String name, String password);
	
	/**
	 * 添加用户
	 * @param name
	 * @param passwd
	 */
	public void addUser(String name, String passwd, String rand, 
			String realName, String corperation, String mobilePhone,
			String telePhone, String address, int status);
	
	/**
	 * 删除用户
	 * @param id
	 */
	public void delUser(User user);
	
	/**
	 * 更新用户资料
	 * @param userinfo
	 */
	public void updateUserInfo(int id, Userinfo userinfo);
	
	/**
	 * 根据id获取User
	 * @param id
	 * @return
	 */
	public User findUser(int id);
	
	/**
	 * 根据用户名获取User对象
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

