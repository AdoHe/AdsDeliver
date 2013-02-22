package edu.tongji.se.webserviceImpl;

import java.util.List;

import javax.jws.WebService;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;
import edu.tongji.se.webservice.AdService;

@WebService(endpointInterface = "edu.tongji.se.webservice.AdService")
public class AdServiceImpl implements AdService 
{

	@Override
	public void addAd(String userName, Location location, String name,
			String address, Adverinfo adverinfo, short status) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delAd(Advertisement ad) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAd(Advertisement ad) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Advertisement> getAds(String userName, int offset, int limit) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAds(String userName, int status, int offset,
			int limit) 
			{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAdsNearby(float lng, float lat,
			float distance, int count) 
			{
		// TODO Auto-generated method stub
		return null;
	}

}
