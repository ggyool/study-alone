package org.ggyool.reservation.service;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.vo.CategoryVO;

public interface CategoryService {
	public List<HashMap<String, Object>> getCategories();
	public CategoryVO addCategory(CategoryVO dto);
	public Integer countProducts(Integer categoryId);
}
