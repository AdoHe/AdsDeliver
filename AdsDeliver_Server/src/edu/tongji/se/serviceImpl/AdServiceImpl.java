package edu.tongji.se.serviceImpl;

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
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo) {
		Advertisement ad = new Advertisement();
		
		adverinfo.setAdvertisement(ad);
		
		ad.setLocation(location);
		ad.setAdverinfo(adverinfo);
		ad.setAvName(name);
		ad.setAvAddress(address);
		
		User user = ((ArrayList<User>)mUserDao.findByUsName(userName)).get(0);
		ad.setUser(user);
		
		ad.setAvStatus((short)0);
		ad.setAvClickTimes(0);
		
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



	


}
