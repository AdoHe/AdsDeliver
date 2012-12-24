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
	public void addAd(String userName, Location location, String name, String address, Adverinfo adverinfo, short status);

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
	 * �õ����û��������������еĹ��
	 * @param userName
	 * @param status ���״̬
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAds(String userName, int status, int offset, int limit);
	
	/**
	 * �õ��û��Ѿ�Ͷ�ŵ����й�������
	 * @param userName
	 * @return
	 */
	public int getAllAdsCount(String userName);
	
	/**
	 * �õ��û���ǰ�������еĹ�������
	 * @param userName
	 * @return
	 */
	public int getActiveAdsCount(String userName);
	
	/**
	 * ���ݹ��ĵ�ǰ״̬��ù���б�
	 * @param status
	 * @return
	 */
	public List<Advertisement> getAllAds(short status, int offset, int limit);
	
	/**
	 * �õ�ĳ��״̬�Ĺ�������
	 * @param status
	 * @return
	 */
	public int getAllAdsCount(short status);
	
	/**
	 * Ϊ����Ա�õ����еĹ���б�
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Advertisement> getAllAds(int offset, int limit);
	
	/**
	 * Ϊ����Ա�õ����еĹ�������
	 * @return
	 */
	public int getAllAdsCount();
	
	/**
	 * ͨ�����id��ù�����
	 * @param id
	 * @return
	 */
	public Advertisement getAd(int id);
	
	/**
	 * ͨ������λ�ò���һ����Χ�ڵĹ��
	 * @param lng
	 * @param lat
	 * @param distance �����ĵ�İ뾶
	 * @param count ���������
	 * @return
	 */
	public List<Advertisement> getAdsNearby(float lng, float lat, float distance, int count);
	
	public Advertisement getAdRand();
}
