package edu.tongji.se.action;

import java.util.ArrayList;
import java.util.Random;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;

public class AdRequestAction extends ActionSupport{
	private float lng;
	private float lat;
	private Advertisement ad;
	
	private AdService mAdService;
	
	public String requestAd() {
		
		Random random = new Random();
		if(lng != 0 && lat != 0) {
			
			// 指定了地理位置的情况
			ArrayList<Advertisement> lstAd = (ArrayList<Advertisement>)mAdService.getAdsNearby(lng, lat, 10, 5); 
			if(lstAd != null && lstAd.size() != 0) {
				ad = lstAd.get(random.nextInt(lstAd.size() > 4 ? 4 : lstAd.size()));
			}
		}else {
			
			// 未指定地理信息
			ad = mAdService.getAdRand();
		}
		
		
		return "success";
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}

	public Advertisement getAd() {
		return ad;
	}

	public void setAd(Advertisement ad) {
		this.ad = ad;
	}
	
	
}
