package org.ggyool.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="reservations")
public class ReservationController {
	
	@GetMapping("/{displayInfoId}")
	public String doingReservation() {
		return "reservation";
	}
	
	@GetMapping(path="/me")
	public String myReservation(HttpSession session, Model model) {
		String sessionEmail = (String)session.getAttribute("email");
		if(sessionEmail!=null) model.addAttribute("sessionEmail", sessionEmail);
		return "myreservation";
	}
	
}
