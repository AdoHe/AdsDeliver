package edu.tongji.se.service;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;

public interface AdService {
	
	public void addAd(int userId, Location location, String name, 
			String address);
	
	public void delAd(Advertisement ad);
	
	public void updateAd(Advertisement ad);
	
	public void updateAdInfo(int id, Adverinfo adinfo);
	
}
