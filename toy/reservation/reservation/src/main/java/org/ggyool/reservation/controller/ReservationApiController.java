package org.ggyool.reservation.controller;

import java.util.List;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.ggyool.reservation.service.ReservationInfoService;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.ggyool.reservation.vo.ReservationInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/reservations")
public class ReservationApiController {
	
	@Autowired
	ReservationInfoService reservationInfoService;
	@Autowired
	ReservationInfoPriceService reservationInfoPriceService;
	
	@PostMapping
	public ReservationResponseDTO reservationsPost(@RequestBody ReservationParamDTO reservationParamDTO) {
		ReservationInfoVO reservationInfoVO = reservationInfoService.addReservationInfo(reservationParamDTO);
		List<ReservationInfoPriceVO> prices = reservationInfoPriceService.addReservationPrices(reservationParamDTO.getPrices());
		ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO(reservationInfoVO, prices);
		return reservationResponseDTO;
	}
}