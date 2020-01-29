package org.ggyool.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
	
	@RequestMapping(path="/plusform", method=RequestMethod.GET)
	public String plusform() {
		return "plusForm";
	}
	
	@PostMapping(path="/plus")
	public String plus(@RequestParam(name="value1", required=true) int value1, 
			@RequestParam(name="value2", required=true) int value2, ModelMap modelMap){
		int result = value1 + value2;
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
		return "plusResult";
	}
	
}
