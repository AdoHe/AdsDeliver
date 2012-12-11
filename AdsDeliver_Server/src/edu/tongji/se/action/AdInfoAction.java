package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;

public class AdInfoAction extends ActionSupport implements SessionAware{
	private int id;
	
	private Advertisement ad;
	
	private Map<String, Object> session;
	
	private AdService mAdservice;

	@Override
	public String execute() throws Exception {
		ad = mAdservice.getAd(id);
		
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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setmAdservice(AdService mAdservice) {
		this.mAdservice = mAdservice;
	}
	
	
	
}
