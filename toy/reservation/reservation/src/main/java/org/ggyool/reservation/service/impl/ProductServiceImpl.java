package org.ggyool.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.ggyool.reservation.dao.ProductDAO;
import org.ggyool.reservation.entity.ProductEntity;
import org.ggyool.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDao;
	
	@Override
	public List<Map<String, Object>> getPrductsByCategory(Integer categoryId, int start) {
		return productDao.selectByCategoryId(categoryId, start, LIMIT);
	}

	@Override
	public ProductEntity get(Integer productId) {
		return	productDao.select(productId);
	}
}
