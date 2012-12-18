package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;

public class AdInfoAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private Advertisement ad;
	
	private AdService mAdService;

	public String getAdInfo() throws Exception {
		ad = mAdService.getAd(id);
		
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Advertisement getAd() {
		return ad;
	}

	public void setAd(Advertisement ad) {
		this.ad = ad;
	}

	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
	
	
	
}
