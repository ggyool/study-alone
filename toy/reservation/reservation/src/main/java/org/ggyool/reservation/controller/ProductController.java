package org.ggyool.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="products")
public class ProductController {
	
	@GetMapping("/{displayInfoId}")
	public String productDetails(ModelMap model,
			@PathVariable Integer displayInfoId) {
		return "detail";
	}
}
