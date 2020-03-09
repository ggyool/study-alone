package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.ProductPriceDAO;
import org.ggyool.reservation.service.ProductPriceService;
import org.ggyool.reservation.vo.ProductPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPriceServiceImpl implements ProductPriceService{
	
	@Autowired
	ProductPriceDAO productPriceDao;
	
	@Override
	public List<ProductPriceVO> getPrices(Integer productId) {
		return productPriceDao.selectByProductId(productId);
	}

	@Override
	public ProductPriceVO getPrice(Integer productPriceId) {
		return productPriceDao.selectById(productPriceId);
	}

}
