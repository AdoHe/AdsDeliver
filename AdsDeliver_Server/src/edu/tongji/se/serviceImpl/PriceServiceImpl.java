/**
 * 
 */
package edu.tongji.se.serviceImpl;

import edu.tongji.se.dao.PriceDao;
import edu.tongji.se.model.Price;
import edu.tongji.se.service.PriceService;

/**
 * @author hezibo
 *
 */
public class PriceServiceImpl implements PriceService {

	private PriceDao mPriceDao;
	
	public PriceDao getmPriceDao() {
		return mPriceDao;
	}

	public void setmPriceDao(PriceDao mPriceDao) {
		this.mPriceDao = mPriceDao;
	}

	/* (non-Javadoc)
	 * @see edu.tongji.se.service.PriceService#updatePrice(float, float)
	 */
	@Override
	public void updatePrice(float bannerPrice, float contentPrice) {
		// TODO Auto-generated method stub
		mPriceDao.updatePrice(bannerPrice, contentPrice);
	}

	/* (non-Javadoc)
	 * @see edu.tongji.se.service.PriceService#getPrice()
	 */
	@Override
	public Price getPrice() {
		// TODO Auto-generated method stub
		return mPriceDao.findById((short)1);
	}

}
