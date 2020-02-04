package org.ggyool.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ggyool.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/products")
public class ProductApiController {
	
	@Autowired
	ProductService productSerice;
	
	@GetMapping
	public Map<String, Object> products(
			@RequestParam(name="categoryId", required= true) int categoryId,
			@RequestParam(name="start",  required=false, defaultValue="0") int start) {
		Map<String, Object> map = new HashMap<>();
		List<HashMap<String, Object>> list = productSerice.getPrductsByCategory(categoryId, start);
		int totalCount = list.size();
		map.put("items", list);
		map.put("totalCount", totalCount);
		return map;
	}
}




