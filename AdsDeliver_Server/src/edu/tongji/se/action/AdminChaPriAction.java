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
public class AdminChaPriAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PriceService mPriceService;
	
	private int bannerPrice;
	private int contentPrice;
	
	public void setmPriceService(PriceService mPriceService) {
		this.mPriceService = mPriceService;
	}
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
	
	public String changeBannerPrice()
	{
		Price price = mPriceService.getPrice();
		price.setPcBanner((float)bannerPrice);
		
		//mPriceService.updatePrice((float)bannerPrice, price.getPcContent());
		mPriceService.save(price);
		return SUCCESS;
	}
	
	public String changeContentPrice()
	{
		Price price = mPriceService.getPrice();
		price.setPcContent((float)contentPrice);
		
		//mPriceService.updatePrice(price.getPcBanner(), (float)contentPrice);
		mPriceService.save(price);
		return SUCCESS;
	}
}
