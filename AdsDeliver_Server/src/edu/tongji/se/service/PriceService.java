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
	 * 更新banner和content的price
	 * @param bannerPrice
	 * @param contentPrice
	 */
	public void updatePrice(float bannerPrice, float contentPrice);
	
	/**
	 * 得到当前的banner和content的price
	 * @return
	 */
	public Price getPrice();
}
