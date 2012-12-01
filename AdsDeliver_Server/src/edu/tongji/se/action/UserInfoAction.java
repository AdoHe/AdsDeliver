package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.User;
import edu.tongji.se.model.Userinfo;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.AuthorInterceptor;

public class UserInfoAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	
	private String realName;
	private String corperation;
	
	private String mobilePhone;
	private String telePhone;
	private String address;
	private int status;
	
	private Map<String, Object> session;
	
	private UserService mUserService;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setmUserService(UserService mUserService) {
		this.mUserService = mUserService;
	}
	
	public String userInfoPage() {
		return "USER_INFO";
	}
	
	/** 
	 * 获取用户信息
	 */
	public String userInfo() throws Exception {
		
		userName = (String)session.get(AuthorInterceptor.USER_SESSION_KEY);
		User user = mUserService.findUser(userName); 
		this.realName = user.getUserinfo().getUfName();
		this.corperation = user.getUserinfo().getUfCorperation();
		this.address = user.getUserinfo().getUfAddress();
		this.telePhone = user.getUserinfo().getUfTelephone();
		this.mobilePhone = user.getUserinfo().getUfMobilePhone();
		
		return SUCCESS;
	}
	
	public String saveInfo() throws Exception {
		userName = (String)session.get(AuthorInterceptor.USER_SESSION_KEY);
		User user = mUserService.findUser(userName);
		Userinfo userinfo = user.getUserinfo();
		userinfo.setUfAddress(this.address);
		userinfo.setUfCorperation(corperation);
		userinfo.setUfMobilePhone(mobilePhone);
		userinfo.setUfName(realName);
		userinfo.setUfTelephone(telePhone);
		
		try{
			mUserService.updateUserInfo(user.getId(), userinfo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "SAVE_SUCCESS";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
