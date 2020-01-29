package org.ggyool.mvcexam.controller;

import org.ggyool.mvcexam.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@GetMapping(path="/userform")
	public String userform() {
		return "userForm";
	}
	
	
	// dto 를 사용하려면  @modelAttribute 사용
	@PostMapping(path="regist")
	public String regist(@ModelAttribute User user) { 
		System.out.println(user);
		return "regist";
	}
}
