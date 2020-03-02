package org.ggyool.controller;

import org.ggyool.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@ModelAttribute("user")
	public User setUpUserForm() {
		User user = new User();
		user.setId("default id");
		user.setPassword("default password");
		System.out.println("default run");
		return user;
	}
	
	@RequestMapping(value="/dologin", method= {RequestMethod.GET})
	public String doLoginGet(@ModelAttribute User user) {
		return "dologin";
	}
	
	@RequestMapping(value="/dologin", method= {RequestMethod.POST})
	public String doLoginPost(@ModelAttribute User user) {
		return "redirect:/dologin";
	}
	
	@RequestMapping(value="/dologin2", method= {RequestMethod.GET})
	public String doLogin2(@SessionAttribute User user) {
		return "dologin2";
	}
}
