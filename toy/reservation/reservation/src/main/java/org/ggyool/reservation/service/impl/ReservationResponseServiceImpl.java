package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.ggyool.reservation.service.ReservationInfoService;
import org.ggyool.reservation.service.ReservationResponseService;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.ggyool.reservation.vo.ReservationInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationResponseServiceImpl implements ReservationResponseService{

	@Autowired
	ReservationInfoService reservationInfoService;
	@Autowired
	ReservationInfoPriceService reservationInfoPriceService;
	
	@Override
	// 어떠한 exception에도 transaction 할 수 있도록
	@Transactional(rollbackFor={Exception.class})
	public ReservationResponseDTO getReseravtionResponse(ReservationParamDTO reservationParamDTO) {
		ReservationInfoVO reservationInfoVO = reservationInfoService.addReservationInfo(reservationParamDTO);
		Integer reservationInfoId = reservationInfoVO.getReservationInfoId();
		List<ReservationInfoPriceVO> prices = reservationInfoPriceService.addReservationPrices(reservationParamDTO.getPrices(), reservationInfoId);
		ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO(reservationInfoVO, prices);
		return reservationResponseDTO;
	}
}