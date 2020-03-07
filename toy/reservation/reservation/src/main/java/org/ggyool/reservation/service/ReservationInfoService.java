package org.ggyool.reservation.service;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.vo.ReservationInfoVO;

public interface ReservationInfoService {
	public ReservationInfoVO addReservationInfo(ReservationParamDTO reservationParamDTO);
}
