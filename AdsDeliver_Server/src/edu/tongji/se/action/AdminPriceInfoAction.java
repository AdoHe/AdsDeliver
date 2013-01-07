/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Price;
import edu.tongji.se.service.PriceService;

/**
 * @author hezibo
 *
 */
public class AdminPriceInfoAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float bannerPrice;
	private float contentPrice;
	
	private PriceService mPriceService;
	
	public float getBannerPrice() {
		return bannerPrice;
	}
	public void setBannerPrice(float bannerPrice) {
		this.bannerPrice = bannerPrice;
	}
	public float getContentPrice() {
		return contentPrice;
	}
	public void setContentPrice(float contentPrice) {
		this.contentPrice = contentPrice;
	}
	public void setmPriceService(PriceService mPriceService) {
		this.mPriceService = mPriceService;
	}

	public String getPriceInfo()
	{
		Price price = mPriceService.getPrice();
		
		bannerPrice = price.getPcBanner();
		contentPrice = price.getPcContent();
		return SUCCESS;
	}
}
