package org.ggyool.reservation.controller;

import java.util.HashMap;
import java.util.List;

import org.ggyool.reservation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/main")
	public String main(ModelMap model) {
		List<HashMap<String, Object>> list = categoryService.getCategories();
		model.addAttribute("categoryList", list);
		return "main";
	}
}










