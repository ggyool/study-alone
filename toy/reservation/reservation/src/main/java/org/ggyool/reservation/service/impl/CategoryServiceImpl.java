package org.ggyool.reservation.service.impl;

import static org.ggyool.reservation.dao.CategorySqls.COUNT_PRODUCTS;
import static org.ggyool.reservation.dao.CategorySqls.COUNT_PRODUCTS_BY_CATEGORY_ID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ggyool.reservation.dao.CategoryDAO;
import org.ggyool.reservation.dto.CategoryDTO;
import org.ggyool.reservation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<HashMap<String, Object>> getCategories() {
		return categoryDao.selectWithCount();
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO dto) {
		Integer id = categoryDao.insert(dto);
		dto.setId(id);
		return dto;
	}

	@Override
	public Integer countProducts(Integer categoryId) {
		return categoryDao.countProducts(categoryId);
	}
}




