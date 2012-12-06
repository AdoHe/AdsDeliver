package edu.tongji.se.service;

import java.util.List;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.model.Location;

public interface AdService {
	
	/**
	 * �½����
	 * @param userName
	 * @param location
	 * @param name
	 * @param address
	 * @param adverinfo
	 */
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo);

	/**
	 * ɾ�����
	 * @param ad
	 */
	public void delAd(Advertisement ad);
	
	/**
	 * ���¹��
	 * @param ad
	 */
	public void updateAd(Advertisement ad);
	
	/**
	 * ���¹����Ϣ
	 * @param id
	 * @param adinfo
	 */
	public void updateAdInfo(int id, Adverinfo adinfo);
	
	/**
	 * ��ø��û������й��
	 * @param userName
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAds(String userName, int offset, int limit); 
	
	/**
	 * �õ����û���������Ѿ�ͨ���Ĺ��
	 * @param userName
	 * @param status
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAds(String userName, int status, int offset, int limit);
}
