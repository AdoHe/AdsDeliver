package edu.tongji.se.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;

@WebService
public interface AdService 
{
	/**
	 * 新建广告
	 * @param userName
	 * @param location
	 * @param name
	 * @param address
	 * @param adverinfo
	 * @param status
	 */
	@WebMethod(action="addAd")
	public void addAd(@WebParam(name="userName") String userName, @WebParam(name="location") Location location, 
			@WebParam(name="name") String name, @WebParam(name="address") String address, 
			@WebParam(name="adverinfo") Adverinfo adverinfo, @WebParam(name="status") short status);
	
	/**
	 * 删除广告
	 * @param ad
	 */
	@WebMethod(action="delAd")
	public void delAd(@WebParam(name="ad") Advertisement ad);
	
	/**
	 * 更新广告
	 * @param ad
	 */
	@WebMethod(action="updateAd")
	public void updateAd(@WebParam(name="ad") Advertisement ad);
	
	/**
	 * 获得该用户的所有的广告
	 * @param userName
	 * @param offset
	 * @param limit
	 * @return
	 */
	@WebMethod(action="getAds")
	public List<Advertisement> getAds(@WebParam(name="userName") String userName, @WebParam(name="offset") int offset, 
			@WebParam(name="limit") int limit);
	
	/**
	 * 得到该用户所有正在运行的广告
	 * @param userName
	 * @param status
	 * @param offset
	 * @param limit
	 * @return
	 */
	@WebMethod(action="getAdsRun")
	public List<Advertisement> getAds(@WebParam(name="userName") String userName, @WebParam(name="status") int status, 
			@WebParam(name="offset") int offset, @WebParam(name="limit") int limit);
	
	/**
	 * 得到一定范围内的广告
	 * @param lng
	 * @param lat
	 * @param distance
	 * @param count
	 * @return
	 */
	@WebMethod(action="getAdsNearby")
	public List<Advertisement> getAdsNearby(@WebParam(name="lng") float lng, @WebParam(name="lat") float lat, 
			@WebParam(name="distance") float distance, @WebParam(name="count") int count);
}
