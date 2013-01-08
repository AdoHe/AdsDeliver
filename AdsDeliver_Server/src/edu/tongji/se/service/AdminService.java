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
	 * ��֤����Ա���
	 * @param name
	 * @param password
	 * @return
	 */
	public int validateAdmin(String name, String password);
	
	/**
	 * ����¹���Ա
	 * @param administrator
	 */
	public void addAdmin(String name, String password, String rand, short level);
	
	/**
	 * �õ����еĹ���Ա
	 * @return
	 */
	public List<Administrator> getAdmins();
	
	/**
	 * ɾ��ĳ������Ա
	 * @param id
	 */
	public void deleteAdmin(short id);
	
	/**
	 * ͨ�����Ʋ��ҹ���Ա
	 * @param name
	 * @return
	 */
	public Administrator findAdmin(String name);
	
	/**
	 * �õ����д�ɾ���Ĺ���Ա
	 * @return
	 */
	public List<Administrator> getAdmins(short level, int offset, int length);
}
