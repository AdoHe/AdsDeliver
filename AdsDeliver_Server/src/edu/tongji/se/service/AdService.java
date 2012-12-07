package edu.tongji.se.service;

import java.util.List;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;

public interface AdService {
	
	/**
	 * 新建广告
	 * @param userName
	 * @param location
	 * @param name
	 * @param address
	 * @param adverinfo
	 */
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo);

	/**
	 * 删除广告
	 * @param ad
	 */
	public void delAd(Advertisement ad);
	
	/**
	 * 更新广告
	 * @param ad
	 */
	public void updateAd(Advertisement ad);
	
	/**
	 * 更新广告信息
	 * @param id
	 * @param adinfo
	 */
	public void updateAdInfo(int id, Adverinfo adinfo);
	
	/**
	 * 获得该用户的所有广告
	 * @param userName
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAds(String userName, int offset, int limit); 
	
	/**
	 * 得到该用户所有审核已经通过的广告
	 * @param userName
	 * @param status
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAds(String userName, int status, int offset, int limit);
}
