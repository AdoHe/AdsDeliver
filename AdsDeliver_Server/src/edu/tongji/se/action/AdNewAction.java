/**
 * 
 */
package edu.tongji.se.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hezibo
 *
 */
public class AdNewAction extends ActionSupport 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String newAdPage() throws Exception
	{
		return "NEW_AD";
	}

}
