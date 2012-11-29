/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.Encry;

/**
 * @author hezibo
 *
 */
public class RegisterAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName = null;
	private String password;
	
	private String realName;
	private String corperation;
	
	private String mobilePhone;
	private String telePhone;
	private String address;
	
	private UserService mUserService;
	
	public String getName() 
	{
		return userName;
	}
	public void setName(String name) 
	{
		this.userName = name;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCorperation() {
		return corperation;
	}
	public void setCorperation(String corperation) {
		this.corperation = corperation;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RegisterAction() 
	{
	}
	
	@Override
	public String execute() throws Exception 
	{
		if(userName == null)
			return "REGISTER";
		
		String randString = Encry.generateSalt();
		String passwdInDb = Encry.generatePasswordInDatabase(password, randString);
		
		try {
		mUserService.addUser(userName, passwdInDb, randString, realName, corperation, 
				mobilePhone, telePhone, address, 0);
		}catch(Exception ex) {
			
			// ×¢²áÊ§°Ü
			ex.printStackTrace();
			return "ERROR";
		}
		
		return "SUCCESS";
	}
	public void setmUserService(UserService mUserService) {
		this.mUserService = mUserService;
	}
	
	
	
}
