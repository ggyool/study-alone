package org.ggyool.reservation.controller;

import org.springframework.stereotype.Controller;
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
	public String myReservation() {
		return "myreservation";
	}
	
}
