/**
 * 
 */
package edu.tongji.se.service;

import java.util.List;

import edu.tongji.se.model.Administrator;

/**
 * @author hezibo
 *
 */
public interface AdminService 
{
	/**
	 * 验证管理员身份
	 * @param name
	 * @param password
	 * @return
	 */
	public int validateAdmin(String name, String password);
	
	/**
	 * 添加新管理员
	 * @param administrator
	 */
	public void addAdmin(String name, String password, String rand, short level);
	
	/**
	 * 得到所有的管理员
	 * @return
	 */
	public List<Administrator> getAdmins();
	
	/**
	 * 删除某个管理员
	 * @param id
	 */
	public void deleteAdmin(short id);
	
	/**
	 * 通过名称查找管理员
	 * @param name
	 * @return
	 */
	public Administrator findAdmin(String name);
	
	/**
	 * 得到所有待删除的管理员
	 * @return
	 */
	public List<Administrator> getAdmins(short level, int offset, int length);
}
