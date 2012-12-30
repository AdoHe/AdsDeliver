/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hezibo
 *
 */
public class AdminChaPriPageAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String changeBannerPricePage()
	{
		return "BANNER_PRICE";
	}
	
	public String changeContentPricePage()
	{
		return "CONTENT_PRICE";
	}
}
