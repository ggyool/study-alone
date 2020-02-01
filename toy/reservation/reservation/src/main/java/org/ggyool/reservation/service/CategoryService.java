package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.CategoryDTO;

public interface CategoryService {
	public List<CategoryDTO> getCategories();
	public CategoryDTO addCategory(CategoryDTO dto);
}
