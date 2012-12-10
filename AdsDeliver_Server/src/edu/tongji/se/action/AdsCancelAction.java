/**
 * 
 */
package edu.tongji.se.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;
import edu.tongji.se.tools.AuthorInterceptor;

/**
 * @author hezibo
 *
 */
public class AdsCancelAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;

	private int start;
	private int length;
	
	private ArrayList<Advertisement> aAds;
	
	private int all_count;
	
	private AdService mAdService;
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}

	public String getPagedAdsForCancel()
	{
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY)?
				(String)session.get(AuthorInterceptor.USER_SESSION_KEY):"";
				
		if(aAds != null)
		{
		}
		
		aAds = (ArrayList<Advertisement>)mAdService.getAds(userName, start, length);
		
		all_count = mAdService.getAllAdsCount(userName);
		return SUCCESS;
	}
	
	public String cancelAdPage()
	{
		return "CANCEL_AD_PAGE";
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ArrayList<Advertisement> getaAds() {
		return aAds;
	}

	public void setaAds(ArrayList<Advertisement> aAds) {
		this.aAds = aAds;
	}

	public int getAll_count() {
		return all_count;
	}

	public void setAll_count(int all_count) {
		this.all_count = all_count;
	}

	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
	
	
}
