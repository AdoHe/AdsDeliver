package edu.tongji.se.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;
import edu.tongji.se.tools.AuthorInterceptor;

public class AdsListAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	private ArrayList<Advertisement> pAds;
	private ArrayList<Advertisement> aAds;
	
	private int start;
	private int length;
	private int all_count;
	private int active_count;
	
	private AdService mAdService;
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}
	
	public String getPagedAdsForAll()
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
	
	public String getPagedAdsForActive()
	{
		String userName = session.containsKey(AuthorInterceptor.USER_SESSION_KEY) ?
				(String)session.get(AuthorInterceptor.USER_SESSION_KEY):"";
				
		if(pAds != null)
		{
		}
		
		pAds = (ArrayList<Advertisement>)mAdService.getAds(userName, 2, start, length);
		
		active_count = mAdService.getActiveAdsCount(userName);
		
		return SUCCESS;
	}
	
	public String adListPage()
	{
		return "AD_LIST";
	}
	
	//some set/get methods
	public ArrayList<Advertisement> getpAds() {
		return pAds;
	}
	public void setpAds(ArrayList<Advertisement> pAds) {
		this.pAds = pAds;
	}
	public ArrayList<Advertisement> getaAds() {
		return aAds;
	}
	public void setaAds(ArrayList<Advertisement> aAds) {
		this.aAds = aAds;
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
	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
}
