/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;

/**
 * @author hezibo
 *
 */
public class AdEditAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String title;
	private String address;
	private float lng;
	private float lat;
	
	private String bannerPic;
	private String bannerTitleOne;
	private String bannerTitleTwo;
	
	private String contentPic;
	private String content;
	
	private AdService mAdService;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public String getBannerPic() {
		return bannerPic;
	}
	public void setBannerPic(String bannerPic) {
		this.bannerPic = bannerPic;
	}
	public String getBannerTitleOne() {
		return bannerTitleOne;
	}
	public void setBannerTitleOne(String bannerTitleOne) {
		this.bannerTitleOne = bannerTitleOne;
	}
	public String getBannerTitleTwo() {
		return bannerTitleTwo;
	}
	public void setBannerTitleTwo(String bannerTitleTwo) {
		this.bannerTitleTwo = bannerTitleTwo;
	}
	public String getContentPic() {
		return contentPic;
	}
	public void setContentPic(String contentPic) {
		this.contentPic = contentPic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
	
	/**
	 * 获取广告信息
	 */
	public String getAdInfo() throws Exception
	{
		Advertisement ad = mAdService.getAd(id);
		
		this.title = ad.getAvName();
		this.address = ad.getAvAddress();
		this.lng = ad.getLocation().getLcLongitude();
		this.lat = ad.getLocation().getLcLatitude();
		this.bannerTitleOne = ad.getAdverinfo().getAfBannerWordOne();
		this.bannerTitleTwo = ad.getAdverinfo().getAfBannerWordTwo();
		this.bannerPic = ad.getAdverinfo().getAfBannerPic();
		this.contentPic = ad.getAdverinfo().getAfContentPic();
		this.content = ad.getAdverinfo().getAfContents();
		
		return SUCCESS;
	}
	
	/**
	 * 保存广告信息
	 */
	public String saveAdInfo() throws Exception
	{
		Advertisement ad = mAdService.getAd(id);
		
		Adverinfo info = ad.getAdverinfo();
		info.setAfBannerPic(bannerPic);
		info.setAfBannerWordOne(bannerTitleOne);
		info.setAfBannerWordTwo(bannerTitleTwo);
		info.setAfContents(content);
		info.setAfContentPic(contentPic);
		
		mAdService.updateAdInfo(id, info);
		
		return "SAVE_SUCCESS";
	}
}
