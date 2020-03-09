package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.vo.ReservationInfoVO;

public interface ReservationInfoService {
	public ReservationInfoVO addReservationInfo(ReservationParamDTO reservationParamDTO);
	public List<ReservationInfoVO> getsByEmail(String reservationEmail);
}
