package org.ggyool.reservation.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ggyool.reservation.service.CategoryService;
import org.ggyool.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/products")
public class ProductApiController {
	
	@Autowired
	ProductService productSerice;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public Map<String, Object> products(
			@RequestParam(name="categoryId", required=false) Integer categoryId,
			@RequestParam(name="start",  required=false, defaultValue="0") int start) {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = productSerice.getPrductsByCategory(categoryId, start);
		int totalCount = categoryService.countProducts(categoryId);
		map.put("items", list);
		map.put("totalCount", totalCount);
		return map;
	}
	
	@GetMapping("/{displayInfoId}")
	public Map<String, Object> productsDetails(
			@PathVariable("displayInfoId") int displayInfoId){
		
		
		return Collections.emptyMap();
	}
}




