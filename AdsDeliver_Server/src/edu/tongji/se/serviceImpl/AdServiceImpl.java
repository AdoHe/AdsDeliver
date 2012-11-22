package edu.tongji.se.serviceImpl;

import edu.tongji.se.dao.AdvertisementDao;
import edu.tongji.se.dao.UserDao;
import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;
import edu.tongji.se.model.User;
import edu.tongji.se.service.AdService;

public class AdServiceImpl implements AdService {
	private AdvertisementDao mAdDao;
	private UserDao mUserDao;
	
	
	public void setmAdDao(AdvertisementDao mAdDao) {
		this.mAdDao = mAdDao;
	}
	
	

	public void setmUserDao(UserDao mUserDao) {
		this.mUserDao = mUserDao;
	}



	@Override
	public void addAd(int userId, Location location, String name, String address) {
		Advertisement ad = new Advertisement();
		ad.setLocation(location);
		ad.setAvName(name);
		ad.setAvAddress(address);
		
		User user = mUserDao.findById(userId);
		ad.setUser(user);
		Adverinfo adverinfo = new Adverinfo();
		ad.setAdverinfo(adverinfo);
		
		ad.setAvStatus((short)0);
		ad.setAvClickTimes(0);
		
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


}
