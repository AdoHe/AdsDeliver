package edu.tongji.se.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import edu.tongji.se.dao.AdverinfoDao;
import edu.tongji.se.dao.AdvertisementDao;
import edu.tongji.se.dao.LocationDao;
import edu.tongji.se.dao.UserDao;
import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;
import edu.tongji.se.model.User;
import edu.tongji.se.service.AdService;

public class AdServiceImpl implements AdService {
	private AdvertisementDao mAdDao;
	private UserDao mUserDao;
	private LocationDao mLocationDao;
	private AdverinfoDao mAdverinfoDao;
	
	
	public void setmAdDao(AdvertisementDao mAdDao) {
		this.mAdDao = mAdDao;
	}

	public void setmUserDao(UserDao mUserDao) {
		this.mUserDao = mUserDao;
	}
	
	public void setmLocationDao(LocationDao mLocationDao) {
		this.mLocationDao = mLocationDao;
	}

	public void setmAdverinfoDao(AdverinfoDao mAdverinfoDao) {
		this.mAdverinfoDao = mAdverinfoDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo, short status) {
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
	public void delAd(Advertisement ad) {
		mAdDao.delete(ad);
		
	}

	@Override
	public void updateAd(Advertisement ad) {
		mAdDao.save(ad);
	}

	@Override
	public void updateAdInfo(int id, Adverinfo adinfo) {
		Advertisement ad = mAdDao.findById(id);
		
		ad.setAdverinfo(adinfo);
		
		mAdDao.attachDirty(ad);
		mAdDao.save(ad);
	}



	@Override
	public List<Advertisement> getAds(String userName, int offset, int limit) {
		
		return mAdDao.findAd(userName, offset, limit);
	}

	@Override
	public List<Advertisement> getAds(String userName, int status, int offset,
			int limit) {
		// TODO Auto-generated method stub
		return mAdDao.findAd(userName, status, offset, limit);
	}

	@Override
	public int getAllAdsCount(String userName) {
		// TODO Auto-generated method stub
		return mAdDao.getAllAdCount(userName);
	}

	@Override
	public int getActiveAdsCount(String userName) {
		// TODO Auto-generated method stub
		return mAdDao.getPaAdCount(userName, 2);
	}

	@Override
	public Advertisement getAd(int id) {
		// TODO Auto-generated method stub
		return mAdDao.findById(id);
	}

	@Override
	public List<Advertisement> getAdsNearby(float lng, float lat,
			float distance, int count) {
		return mAdDao.findAdsNearBy(distance, lng, lat, count);
	}

	@Override
	public Advertisement getAdRand() {
		// TODO Auto-generated method stub
		return (Advertisement)mAdDao.findAdsRandom().get(0);
	}

	@Override
	public List<Advertisement> getAllAds(short status, int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllAdsCount(short status) {
		// TODO Auto-generated method stub
		return 0;
	}



	


}
