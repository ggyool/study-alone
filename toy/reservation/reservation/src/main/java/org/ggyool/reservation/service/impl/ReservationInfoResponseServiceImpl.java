package org.ggyool.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.reservation.dto.DisplayInfoDTO;
import org.ggyool.reservation.dto.ReservationInfoDTO;
import org.ggyool.reservation.dto.ReservationInfoResponseDTO;
import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.ggyool.reservation.entity.ReservationInfoEntity;
import org.ggyool.reservation.service.DisplayInfoService;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.ggyool.reservation.service.ReservationInfoResponseService;
import org.ggyool.reservation.service.ReservationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationInfoResponseServiceImpl implements ReservationInfoResponseService{

	@Autowired
	ReservationInfoService reservationInfoService;
	@Autowired
	DisplayInfoService displayInfoService;
	@Autowired
	ReservationInfoPriceService reservationInfoPriceService;
	
	@Override
	public ReservationInfoResponseDTO getByEmail(String reservationEmail) {
		List<ReservationInfoDTO> reservations = new ArrayList<>();
		List<ReservationInfoEntity> list = reservationInfoService.getsByEmail(reservationEmail); 
		for(ReservationInfoEntity reservationInfoEntity : list) {	
			Integer displayInfoId = reservationInfoEntity.getDisplayInfoId();
			Integer reservationInfoId = reservationInfoEntity.getReservationInfoId();
			DisplayInfoDTO displayInfoDTO = displayInfoService.get(displayInfoId);
			Long totalPrice = reservationInfoPriceService.calcTotalPrice(reservationInfoId);
			ReservationInfoDTO reservationInfoDTO = new ReservationInfoDTO(reservationInfoEntity, displayInfoDTO, totalPrice);
			reservations.add(reservationInfoDTO);
		}
		Integer size = reservations.size();
		ReservationInfoResponseDTO reservationInfoResponseDTO = new ReservationInfoResponseDTO();
		reservationInfoResponseDTO.setReservations(reservations);
		reservationInfoResponseDTO.setSize(size);
		return reservationInfoResponseDTO;
	}

}
