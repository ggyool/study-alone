package org.ggyool.reservation.service.impl;

import java.util.List;

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
	public List<CategoryDTO> getCategories() {
		return categoryDao.selectAll();
	}

	@Override
	public CategoryDTO addCategory(CategoryDTO dto) {
		Long id = categoryDao.insert(dto);
		dto.setId(id);
		return dto;
	}
	
}




