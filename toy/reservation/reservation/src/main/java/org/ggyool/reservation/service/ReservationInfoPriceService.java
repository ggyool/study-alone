package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.vo.ReservationInfoPriceVO;

public interface ReservationInfoPriceService {
	public List<ReservationInfoPriceVO> addReservationPrices(List<ReservationInfoPriceVO> reservationPriceList, Integer reservationInfoId);
}
