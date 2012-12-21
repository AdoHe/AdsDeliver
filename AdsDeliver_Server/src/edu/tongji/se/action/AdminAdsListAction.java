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

/**
 * @author hezibo
 *
 */
public class AdminAdsListAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<String, Object> session;
	
	private ArrayList<Advertisement> ads;
	
	private int length;
	private int start;
	private int ads_count;
	
	private AdService mAdService;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getAds_count() {
		return ads_count;
	}
	public void setAds_count(int ads_count) {
		this.ads_count = ads_count;
	}
	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}
	public ArrayList<Advertisement> getAds() {
		return ads;
	}
	public void setAds(ArrayList<Advertisement> ads) {
		this.ads = ads;
	}

	public String getPagedAds()
	{
		if(ads != null)
		{
		}
		
		ads =(ArrayList<Advertisement>)mAdService.getAllAds((short)1, start, length);
		
		ads_count = mAdService.getAllAdsCount((short)1);
		return SUCCESS;
	}
}
