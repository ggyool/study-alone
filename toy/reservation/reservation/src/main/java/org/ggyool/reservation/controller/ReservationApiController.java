package org.ggyool.reservation.controller;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.service.ReservationResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/reservations")
public class ReservationApiController {
	
	@Autowired
	ReservationResponseService reservationResponseService;
	
	@PostMapping
	public ReservationResponseDTO reservationsPost(@RequestBody ReservationParamDTO reservationParamDTO) {
		ReservationResponseDTO reservationResponseDTO = reservationResponseService.getReseravtionResponse(reservationParamDTO);
		return reservationResponseDTO;
	}
}