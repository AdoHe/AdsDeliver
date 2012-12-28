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
	 * ����һ���۸�
	 * @param transientInstance
	 */
	public void save(Price transientInstance);
	
	/**
	 * ɾ��ĳ���۸�
	 * @param persistentInstance
	 */
	public void delete(Price persistentInstance);
	
	/**
	 * ͨ��id��ȡ�۸�
	 * @param id
	 * @return
	 */
	public Price findById(java.lang.Short id);
	
	/**
	 * ͨ��ĳ�����Ի�ȡprice
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List findByProperty(String propertyName, Object value);
	
	/**
	 * �õ����е�price
	 * @return
	 */
	public List findAll();
	
	/**
	 * ����banner��content��price 
	 * @param id�����ڱ���1��
	 * @param bannerPrice
	 * @param contentPrice
	 */
	public void updatePrice(float bannerPrice, float contentPrice);
}
