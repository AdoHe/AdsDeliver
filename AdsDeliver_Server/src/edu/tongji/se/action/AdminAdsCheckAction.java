/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.model.Advertisement;
import edu.tongji.se.service.AdService;

/**
 * @author hezibo
 *
 */
public class AdminAdsCheckAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private Advertisement ad;
	
	private AdService mAdService;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Advertisement getAd() {
		return ad;
	}
	public void setAd(Advertisement ad) {
		this.ad = ad;
	}
	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
	
	public String getAdInfo() throws Exception
	{
		ad = mAdService.getAd(id);
		
		return SUCCESS;
	}
	
	public String passAd()
	{
		mAdService.updateAdStatus(id, (short)2, "正在运行中");
		
		return SUCCESS;
	}
	
	public String unPassAd()
	{
		return SUCCESS;
	}
}
