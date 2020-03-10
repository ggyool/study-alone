package org.ggyool.reservation.controller;

import org.ggyool.reservation.dto.ReservationInfoResponseDTO;
import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.service.ReservationInfoResponseService;
import org.ggyool.reservation.service.ReservationResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/reservations")
public class ReservationApiController {
	
	@Autowired
	ReservationResponseService reservationResponseService;
	@Autowired
	ReservationInfoResponseService reservationInfoResponseService;
	
	@GetMapping
	public ReservationInfoResponseDTO reservationsGet(String reservationEmail) {
		return reservationInfoResponseService.getByEmail(reservationEmail);
	}
	@PostMapping
	public ReservationResponseDTO reservationsPost(@RequestBody ReservationParamDTO reservationParamDTO) {
		ReservationResponseDTO reservationResponseDTO = reservationResponseService.getReseravtionResponse(reservationParamDTO);
		return reservationResponseDTO;
	}
}