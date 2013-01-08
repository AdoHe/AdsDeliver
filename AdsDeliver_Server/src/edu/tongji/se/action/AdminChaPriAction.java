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
	
	private float bannerPrice;
	private float contentPrice;
	
	public void setmPriceService(PriceService mPriceService) {
		this.mPriceService = mPriceService;
	}
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
	
	public String changeBannerPrice()
	{
		Price price = mPriceService.getPrice();
		price.setPcBanner(bannerPrice);
		
		//mPriceService.updatePrice((float)bannerPrice, price.getPcContent());
		mPriceService.save(price);
		return SUCCESS;
	}
	
	public String changeContentPrice()
	{
		Price price = mPriceService.getPrice();
		price.setPcContent(contentPrice);
		
		//mPriceService.updatePrice(price.getPcBanner(), (float)contentPrice);
		mPriceService.save(price);
		return SUCCESS;
	}
}
