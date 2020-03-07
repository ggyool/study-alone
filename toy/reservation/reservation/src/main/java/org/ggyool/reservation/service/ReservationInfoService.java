package org.ggyool.reservation.service;

import java.util.Date;

import org.ggyool.reservation.vo.ReservationInfoVO;

public interface ReservationInfoService {
	public ReservationInfoVO addReservationInfo(ReservationInfoVO reservationInfoVO, Date reservationYearMonthDay);
}
