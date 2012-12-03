package edu.tongji.se.service;

import java.util.List;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;

public interface AdService {
	
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo);

	public void delAd(Advertisement ad);
	
	public void updateAd(Advertisement ad);
	
	public void updateAdInfo(int id, Adverinfo adinfo);
	
	public List<Advertisement> getAds(String userName, int offset, int limit);
}
