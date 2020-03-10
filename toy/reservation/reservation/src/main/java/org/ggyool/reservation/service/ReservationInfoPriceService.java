package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;

public interface ReservationInfoPriceService {
	public List<ReservationInfoPriceEntity> addReservationPrices(List<ReservationInfoPriceEntity> reservationPriceList, Integer reservationInfoId);
	public List<ReservationInfoPriceVO> getsByReservationInfoId(Integer reservationInfoId);
	Long calcTotalPrice(Integer reservationInfoId);
}
