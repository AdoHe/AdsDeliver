/**
 * 
 */
package edu.tongji.se.service;

import edu.tongji.se.model.Price;

/**
 * @author hezibo
 *
 */
public interface PriceService {

	/**
	 * ����banner��content��price
	 * @param bannerPrice
	 * @param contentPrice
	 */
	public void updatePrice(float bannerPrice, float contentPrice);
	
	/**
	 * �õ���ǰ��banner��content��price
	 * @return
	 */
	public Price getPrice();
}
