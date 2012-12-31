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
	
	private int bannerPrice;
	private int contentPrice;
	
	private PriceService mPriceService;
	
	public int getBannerPrice() {
		return bannerPrice;
	}
	public void setBannerPrice(int bannerPrice) {
		this.bannerPrice = bannerPrice;
	}
	public int getContentPrice() {
		return contentPrice;
	}
	public void setContentPrice(int contentPrice) {
		this.contentPrice = contentPrice;
	}
	public void setmPriceService(PriceService mPriceService) {
		this.mPriceService = mPriceService;
	}

	public String getPriceInfo()
	{
		Price price = mPriceService.getPrice();
		
		bannerPrice = (int)price.getPcBanner().floatValue();
		contentPrice = (int)price.getPcContent().floatValue();
		return SUCCESS;
	}
}
