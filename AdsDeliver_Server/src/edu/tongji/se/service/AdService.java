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
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo, short status);

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
	 * 得到该用户所有正在运行中的广告
	 * @param userName
	 * @param status 广告状态
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAds(String userName, int status, int offset, int limit);
	
	/**
	 * 得到用户已经投放的所有广告的数量
	 * @param userName
	 * @return
	 */
	public int getAllAdsCount(String userName);
	
	/**
	 * 得到用户当前正在运行的广告的数量
	 * @param userName
	 * @return
	 */
	public int getActiveAdsCount(String userName);
	
	/**
	 * 根据广告的当前状态获得广告列表
	 * @param status
	 * @return
	 */
	public List<Advertisement> getAllAds(short status, int offset, int limit);
	
	/**
	 * 得到某种状态的广告的数量
	 * @param status
	 * @return
	 */
	public int getAllAdsCount(short status);
	
	/**
	 * 为管理员得到所有的广告列表
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAllAds(int offset, int limit);
	
	/**
	 * 为管理员得到所有的广告的数量
	 * @return
	 */
	public int getAllAdsCount();
	
	/**
	 * 通过广告id获得广告对象
	 * @param id
	 * @return
	 */
	public Advertisement getAd(int id);
	
	/**
	 * 通过地理位置查找一定范围内的广告
	 * @param lng
	 * @param lat
	 * @param distance 到中心点的半径
	 * @param count 请求的数量
	 * @return
	 */
	public List<Advertisement> getAdsNearby(float lng, float lat, float distance, int count);
	
	public Advertisement getAdRand();
}
