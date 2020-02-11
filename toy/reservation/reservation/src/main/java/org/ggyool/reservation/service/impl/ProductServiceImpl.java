package org.ggyool.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.ggyool.reservation.dao.ProductDAO;
import org.ggyool.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO productDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Map<String, Object>> getPrductsByCategory(Integer categoryId, int start) {
		return productDao.selectByCategoryId(categoryId, start, LIMIT);
	}
}
