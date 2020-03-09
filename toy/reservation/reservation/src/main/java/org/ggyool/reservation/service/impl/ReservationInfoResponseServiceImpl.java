package org.ggyool.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.reservation.dto.DisplayInfoDTO;
import org.ggyool.reservation.dto.ReservationInfoDTO;
import org.ggyool.reservation.dto.ReservationInfoResponseDTO;
import org.ggyool.reservation.service.DisplayInfoService;
import org.ggyool.reservation.service.ReservationInfoResponseService;
import org.ggyool.reservation.service.ReservationInfoService;
import org.ggyool.reservation.vo.ReservationInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationInfoResponseServiceImpl implements ReservationInfoResponseService{

	@Autowired
	ReservationInfoService reservationInfoService;
	@Autowired
	DisplayInfoService displayInfoService;
	
	@Override
	public ReservationInfoResponseDTO getByEmail(String reservationEmail) {
		List<ReservationInfoDTO> reservations = new ArrayList<>();
		List<ReservationInfoVO> list = reservationInfoService.getsByEmail(reservationEmail); 
		for(ReservationInfoVO reservationInfoVO : list) {	
			DisplayInfoDTO displayInfoDTO = displayInfoService.get(reservationInfoVO.getDisplayInfoId());
			
		
			//ReservationInfoDTO reservationInfoDTO = new ReservationInfoDTO(reservationInfoVO);
			
		}
		return null;
	}

}
