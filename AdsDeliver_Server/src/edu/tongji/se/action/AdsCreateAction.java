package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;
import edu.tongji.se.service.AdService;
import edu.tongji.se.tools.AuthorInterceptor;

public class AdsCreateAction extends ActionSupport implements SessionAware{
	private String name;
	private String address;
	
	// 位置信息
	private Float longitude;
	private Float latitude;
	
	// 广告详细信息
	private String bannerPic;
	private String bannerWordOne;
	private String bannerWordTwo;
	private String contentPic;
	private String contents;
	
	private Map<String, Object> session;
	
	private AdService mAdservice;

	
	public String createAd() throws Exception {
		Location location = new Location();
		location.setLcLongitude(longitude);
		location.setLcLatitude(latitude);
		
		Adverinfo adverInfo = new Adverinfo();
		adverInfo.setAfBannerPic(bannerPic);
		adverInfo.setAfBannerWordOne(bannerWordOne);
		adverInfo.setAfBannerWordTwo(bannerWordTwo);
		adverInfo.setAfContentPic(contentPic);
		adverInfo.setAfContents(contents);
		
		mAdservice.addAd((String)session.get(AuthorInterceptor.USER_SESSION_KEY), 
				location, name, address, adverInfo);
		
		return SUCCESS;
	}
	
	public String newAdPage() {
		return "NEW_AD_PAGE";
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setmAdservice(AdService mAdservice) {
		this.mAdservice = mAdservice;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	
}
