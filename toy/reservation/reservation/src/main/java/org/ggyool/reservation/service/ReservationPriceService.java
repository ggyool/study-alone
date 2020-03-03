package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.vo.ReservationPriceVO;

public interface ReservationPriceService {
	public List<ReservationPriceVO> addReservationPrices(List<ReservationPriceVO> reservationPriceList);
}
