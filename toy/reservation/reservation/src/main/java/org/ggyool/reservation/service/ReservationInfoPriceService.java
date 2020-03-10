package org.ggyool.reservation.service;

import java.util.List;
import java.util.Map;

import org.ggyool.reservation.entity.ReservationInfoPriceEntity;

public interface ReservationInfoPriceService {
	public List<ReservationInfoPriceEntity> addReservationPrices(List<ReservationInfoPriceEntity> reservationPriceList, Integer reservationInfoId);
	public List<Map<String, Object>> getsByReservationInfoId(Integer reservationInfoId);
}
