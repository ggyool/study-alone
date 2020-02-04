package org.ggyool.reservation.service.impl;

import java.util.HashMap;
import java.util.List;

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
	public List<HashMap<String, Object>> getPrductsByCategory(int categoryId, int start) {
		return productDao.selectByCategoryId(categoryId, start, LIMIT);
	}
}
