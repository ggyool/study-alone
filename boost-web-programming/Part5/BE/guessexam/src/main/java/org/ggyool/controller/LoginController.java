package org.ggyool.controller;

import org.ggyool.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String doLoginGet(@ModelAttribute("user") User user)
		System.out.println("get run");
		System.out.println(user);
		return "dologin";
	}
	
	@RequestMapping(value="/dologin", method= {RequestMethod.POST})
	public String doLogin(@ModelAttribute("user") User user) {
		System.out.println("post run");
		System.out.println(user);
		return "redirect:/dologin";
	}
}
