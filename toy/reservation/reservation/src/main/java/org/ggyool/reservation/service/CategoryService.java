package org.ggyool.reservation.service;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.entity.CategoryEntity;

public interface CategoryService {
	public List<HashMap<String, Object>> getCategories();
	public CategoryEntity addCategory(CategoryEntity dto);
	public Integer countProducts(Integer categoryId);
}
