package org.ggyool.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="login")
public class LoginController {
	
	@GetMapping
	public String loginGet(HttpSession session) {
		String sessionEmail = (String)session.getAttribute("email");
		if(sessionEmail != null) {
			return "redirect:/reservations/me";
		}
		return "login";
	}
	@PostMapping
	public String loginPost(HttpSession session, @RequestParam(value="resrv_email", required=true)String email) {
		// db에 없는 이메일이라 해도 비어있는 내역을 주므로 그냥 go
		// 유효성 체크는 프론트에서 하고 넘어옴
		session.setAttribute("email", email);
		return "redirect:/reservations/me";
	}
}
