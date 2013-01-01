/**
 * 
 */
package edu.tongji.se.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import edu.tongji.se.service.AdService;

/**
 * @author hezibo
 *
 */
public class AdminAdsCancelAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(AdminAdsCancelAction.class);
			
	private String str;
	
	private AdService mAdService;
	
	public String cancelAds()
	{
		log.debug("this is the str" + str);
		String[] strs = str.split(",");
		
		for(int i = 0; i < strs.length; i++)
		{
			int id = Integer.valueOf(strs[i]);
			mAdService.updateAdStatus(id, (short)3, "ÒÑÍ£Ö¹ÔËÐÐ");
		}
		
		return SUCCESS;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void setmAdService(AdService mAdService) {
		this.mAdService = mAdService;
	}
}
