package edu.tongji.se.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;

public class AdsListAction extends ActionSupport implements SessionAware 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	
	private ArrayList<Advertisement> pAds;
	private ArrayList<Advertisement> aAds;
	
	@Override
	public void setSession(Map<String, Object> session) 
	{
		// TODO Auto-generated method stub
		this.session = session;
	}
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

}
