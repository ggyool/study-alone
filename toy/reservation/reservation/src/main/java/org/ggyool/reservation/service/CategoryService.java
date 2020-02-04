package org.ggyool.reservation.service;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.dto.CategoryDTO;

public interface CategoryService {
	public List<HashMap<String, Object>> getCategories();
	public CategoryDTO addCategory(CategoryDTO dto);
	public Integer countProducts(Integer categoryId);
}
