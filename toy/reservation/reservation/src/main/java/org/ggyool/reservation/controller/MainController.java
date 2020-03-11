package org.ggyool.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(HttpSession session, Model model) {
		String sessionEmail = (String)session.getAttribute("email"); 
		if(sessionEmail!=null) 
			model.addAttribute("sessionEmail", "ggyool@naver.com");
		return "main";
	}
}










