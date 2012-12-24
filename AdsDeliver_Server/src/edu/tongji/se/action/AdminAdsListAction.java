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
	private ArrayList<Advertisement> pAds;
	private ArrayList<Advertisement> aAds;
	
	private int length;
	private int start;
	
	private int ads_count;
	private int all_count;
	private int active_count;
	
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
	public ArrayList<Advertisement> getpAds() {
		return pAds;
	}
	public void setpAds(ArrayList<Advertisement> pAds) {
		this.pAds = pAds;
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
	public int getActive_count() {
		return active_count;
	}
	public void setActive_count(int active_count) {
		this.active_count = active_count;
	}
	public ArrayList<Advertisement> getAds() {
		return ads;
	}
	public void setAds(ArrayList<Advertisement> ads) {
		this.ads = ads;
	}

	/**
	 * 得到管理员首页上显示的广告列表
	 * @return
	 */
	public String getPagedAds()
	{
		if(ads != null)
		{
		}
		
		ads =(ArrayList<Advertisement>)mAdService.getAllAds((short)1, start, length);
		
		ads_count = mAdService.getAllAdsCount((short)1);
		return SUCCESS;
	}
	
	/**
	 * 得到管理员查看广告页面显示的广告
	 * @return
	 */
	public String getPagedAdsForAll()
	{
		if(aAds != null)
		{
		}
		
		aAds = (ArrayList<Advertisement>)mAdService.getAllAds(start, length);
		
		all_count = mAdService.getAllAdsCount();
		return SUCCESS;
	}
	
	/**
	 * 得到管理员撤销广告页面的广告
	 * @return
	 */
	public String getPagedAdsForActive()
	{
		if(aAds != null)
		{
		}
		
		pAds = (ArrayList<Advertisement>)mAdService.getAllAds((short)2, start, length);
		
		active_count = mAdService.getAllAdsCount((short)2);
		return SUCCESS;
	}
}
