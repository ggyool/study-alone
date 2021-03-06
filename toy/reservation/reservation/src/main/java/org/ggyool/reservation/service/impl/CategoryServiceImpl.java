package org.ggyool.reservation.service.impl;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.dao.CategoryDAO;
import org.ggyool.reservation.entity.CategoryEntity;
import org.ggyool.reservation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDao;
	
	@Override
	public List<HashMap<String, Object>> getCategories() {
		return categoryDao.selectWithCount();
	}

	@Override
	public CategoryEntity addCategory(CategoryEntity dto) {
		Integer id = categoryDao.insert(dto);
		dto.setId(id);
		return dto;
	}

	@Override
	public Integer countProducts(Integer categoryId) {
		return categoryDao.countProducts(categoryId);
	}
}




