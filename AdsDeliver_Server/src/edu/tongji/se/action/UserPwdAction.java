/**
 * 
 */
package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.User;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.AuthorInterceptor;
import edu.tongji.se.tools.Encry;

/**
 * @author hezibo
 *
 */
public class UserPwdAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String oldPwd = null;
	private String newPwd;
	private String newPwdAck;
	
	private Map<String, Object> session;
	
	private UserService mUserService;
	
	public String getOldPwd() 
	{
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) 
	{
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() 
	{
		return newPwd;
	}
	public void setNewPwd(String newPwd) 
	{
		this.newPwd = newPwd;
	}
	public String getNewPwdAck() 
	{
		return newPwdAck;
	}
	public void setNewPwdAck(String newPwdAck) 
	{
		this.newPwdAck = newPwdAck;
	}
	public UserService getmUserService() 
	{
		return mUserService;
	}
	public void setmUserService(UserService mUserService) 
	{
		this.mUserService = mUserService;
	}
	
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	public String changePwdPage() {
		return "CHANGE_PWD_PAGE";
	}
	
	public String changePwd() throws Exception 
	{
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY)?
				 (String)session.get(AuthorInterceptor.USER_SESSION_KEY):"";
		User user = mUserService.findUser(userName);
		
		String rand = user.getUsRand();
		if(Encry.checkPasswordByInput(oldPwd, rand, user.getUsPassword()))
		{
			mUserService.updateUserPwd(user.getId(), newPwdAck);
			return "SAVE_SUCCESS";
		}else
		{
			return "OLD_WRONG";
		}
	}
}
