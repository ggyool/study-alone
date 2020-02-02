package org.ggyool.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ggyool.reservation.dto.CategoryDTO;
import org.ggyool.reservation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class CategoryApiController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping(path="/categories")
	public Map<String, Object> categories(){
		Map<String, Object> map = new HashMap<>();
		List<CategoryDTO> categoryList = categoryService.getCategories();
		map.put("items", categoryList);
		return map;
	}
}