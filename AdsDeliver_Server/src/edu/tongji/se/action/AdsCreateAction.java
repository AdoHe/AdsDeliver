package edu.tongji.se.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Account;
import edu.tongji.se.model.Adverinfo;
import edu.tongji.se.model.Location;
import edu.tongji.se.model.Price;
import edu.tongji.se.model.User;
import edu.tongji.se.service.AdService;
import edu.tongji.se.service.PriceService;
import edu.tongji.se.service.UserService;
import edu.tongji.se.tools.AuthorInterceptor;

public class AdsCreateAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	
	// 位置信息
	private float longitude;
	private float latitude;
	
	// 广告详细信息
	private String bannerPic;
	private String bannerWordOne;
	private String bannerWordTwo;
	private String contentPic;
	private String contents;
	
	private int result;
	
	private Map<String, Object> session;
	
	private AdService mAdservice;
	
	private UserService mUserService;
	
	private PriceService mPriceService;
	
	public String createAd() throws Exception {
		
		String userName = (String)session.get(AuthorInterceptor.USER_SESSION_KEY);
		User user = mUserService.findUser(userName);
		
		Account account = user.getAccount();
		Price price = mPriceService.getPrice();
		int totalPrice = (int)(price.getPcBanner() + price.getPcContent());
		
		if(account.getAcBalance() > totalPrice)
		{
			Location location = new Location();
			location.setLcLongitude(longitude);
			location.setLcLatitude(latitude);
			
			Adverinfo adverInfo = new Adverinfo();
			adverInfo.setAfBannerPic(bannerPic);
			adverInfo.setAfBannerWordOne(bannerWordOne);
			adverInfo.setAfBannerWordTwo(bannerWordTwo);
			adverInfo.setAfContentPic(contentPic);
			adverInfo.setAfContents(contents);
			
			mAdservice.addAd(userName, 
					location, name, address, adverInfo, (short)1);
			
			result = 1;
			return SUCCESS;
		}else
		{
			result = 2;
			return SUCCESS;
		}
	}
	
	/**
	 * 保存草稿
	 * @return
	 * @throws Exception
	 */
	public String createAdForDraft() throws Exception {
		Location location = new Location();
		location.setLcLongitude(longitude);
		location.setLcLatitude(latitude);
		
		Adverinfo adverInfo = new Adverinfo();
		adverInfo.setAfBannerPic(bannerPic);
		adverInfo.setAfBannerWordOne(bannerWordOne);
		adverInfo.setAfBannerWordTwo(bannerWordTwo);
		adverInfo.setAfContentPic(contentPic);
		adverInfo.setAfContents(contents);
		
		mAdservice.addAd((String)session.get(AuthorInterceptor.USER_SESSION_KEY), 
				location, name, address, adverInfo, (short)0);
		
		return "SAVE_SUCCESS";
	}
	
	public String newAdPage() {
		return "NEW_AD_PAGE";
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setmAdservice(AdService mAdservice) {
		this.mAdservice = mAdservice;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getBannerPic() {
		return bannerPic;
	}

	public void setBannerPic(String bannerPic) {
		this.bannerPic = bannerPic;
	}

	public String getBannerWordOne() {
		return bannerWordOne;
	}

	public void setBannerWordOne(String bannerWordOne) {
		this.bannerWordOne = bannerWordOne;
	}

	public String getBannerWordTwo() {
		return bannerWordTwo;
	}

	public void setBannerWordTwo(String bannerWordTwo) {
		this.bannerWordTwo = bannerWordTwo;
	}

	public String getContentPic() {
		return contentPic;
	}

	public void setContentPic(String contentPic) {
		this.contentPic = contentPic;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setmUserService(UserService mUserService) {
		this.mUserService = mUserService;
	}

	public void setmPriceService(PriceService mPriceService) {
		this.mPriceService = mPriceService;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
