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
		for(ReservationInfoEntity reservationInfoVO : list) {	
			Integer displayInfoId = reservationInfoVO.getDisplayInfoId();
			Integer reservationInfoId = reservationInfoVO.getReservationInfoId();
			Long totalPrice = 0L;
			DisplayInfoDTO displayInfoDTO = displayInfoService.get(displayInfoId);
			// join 으로 바꾸기 
//			List<ReservationInfoPriceVO> prices = 
//			reservationInfoPriceService.getsByReservationInfoId(reservationInfoId);
			
			
			
			
			//ReservationInfoDTO reservationInfoDTO = new ReservationInfoDTO(reservationInfoVO);
			
		}
		return null;
	}

}
