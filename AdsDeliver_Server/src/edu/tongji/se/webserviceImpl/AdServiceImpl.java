package edu.tongji.se.webserviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import edu.tongji.se.dao.AdverinfoDao;
import edu.tongji.se.dao.AdvertisementDao;
import edu.tongji.se.dao.LocationDao;
import edu.tongji.se.dao.UserDao;
import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Advertisements;
import edu.tongji.se.model.Location;
import edu.tongji.se.model.User;
import edu.tongji.se.webservice.AdService;

@WebService(endpointInterface = "edu.tongji.se.webservice.AdService")
public class AdServiceImpl implements AdService 
{
	private AdvertisementDao mAdDao;
	private UserDao mUserDao;
	private LocationDao mLocationDao;
	private AdverinfoDao mAdverinfoDao;

	@Resource(name="AdvertisementDAO")
	public void setmAdDao(AdvertisementDao mAdDao) 
	{
		this.mAdDao = mAdDao;
	}

	@Resource(name="UserDAO")
	public void setmUserDao(UserDao mUserDao) 
	{
		this.mUserDao = mUserDao;
	}

	@Resource(name="LocationDAO")
	public void setmLocationDao(LocationDao mLocationDao) 
	{
		this.mLocationDao = mLocationDao;
	}

	@Resource(name="AdverinfoDAO")
	public void setmAdverinfoDao(AdverinfoDao mAdverinfoDao) 
	{
		this.mAdverinfoDao = mAdverinfoDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addAd(String userName, Location location, String name,
			String address, Adverinfo adverinfo, short status) 
	{
		// TODO Auto-generated method stub
		Advertisement ad = new Advertisement();
		
		
		ad.setLocation(location);
		ad.setAdverinfo(adverinfo);
		ad.setAvName(name);
		ad.setAvAddress(address);
		
		User user = ((ArrayList<User>)mUserDao.findByUsName(userName)).get(0);
		ad.setUser(user);
		
		//初始化一些默认值
		ad.setAvShowTimes(0);
		ad.setAvStatus(status);
		ad.setAvClickTimes(0);
		ad.setAvPublishTime(new Timestamp(System.currentTimeMillis()));
		ad.setAvDesc("等待审核中");
		
		adverinfo.setAdvertisement(ad);
		
		mLocationDao.save(location);
		mAdverinfoDao.save(adverinfo);
		mAdDao.save(ad);
	}

	@Override
	public void delAd(Advertisement ad) 
	{
		// TODO Auto-generated method stub
		mAdDao.delete(ad);
	}

	@Override
	public void updateAd(Advertisement ad) 
	{
		// TODO Auto-generated method stub
		mAdDao.save(ad);
	}

	@Override
	public Advertisements getAllAds(String userName, int offset, int limit) 
	{
		// TODO Auto-generated method stub
		ArrayList<Advertisement> allAds = (ArrayList<Advertisement>) mAdDao.findAd(userName, offset, limit);
		Advertisements ads = new Advertisements();
		ads.setAllAds(allAds);
		return ads;
	}

	@Override
	public List<Advertisement> getAds(String userName, int status, int offset,
			int limit) 
	{
		// TODO Auto-generated method stub
		return mAdDao.findAd(userName, status, offset, limit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advertisement> getAdsNearby(float lng, float lat,
			float distance, int count) 
	{
		// TODO Auto-generated method stub
		return (List<Advertisement>)mAdDao.findAdsNearBy(distance, lng, lat, count);
	}

	@Override
	public Advertisement getAdById(int id) 
	{
		// TODO Auto-generated method stub
		return mAdDao.findById(id);
	}

}