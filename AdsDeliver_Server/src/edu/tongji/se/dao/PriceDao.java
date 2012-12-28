/**
 * 
 */
package edu.tongji.se.dao;

import java.util.List;

import edu.tongji.se.model.Price;

/**
 * @author hezibo
 *
 */
public interface PriceDao 
{
	/**
	 * 保存一个价格
	 * @param transientInstance
	 */
	public void save(Price transientInstance);
	
	/**
	 * 删除某个价格
	 * @param persistentInstance
	 */
	public void delete(Price persistentInstance);
	
	/**
	 * 通过id获取价格
	 * @param id
	 * @return
	 */
	public Price findById(java.lang.Short id);
	
	/**
	 * 通过某个属性获取price
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByProperty(String propertyName, Object value);
	
	/**
	 * 得到所有的price
	 * @return
	 */
	public List findAll();
	
	/**
	 * 更新banner和content的price 
	 * @param id（用于保持1）
	 * @param bannerPrice
	 * @param contentPrice
	 */
	public void updatePrice(float bannerPrice, float contentPrice);
}
