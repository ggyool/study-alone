package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.entity.ReservationInfoEntity;

public interface ReservationInfoService {
	public ReservationInfoEntity addReservationInfo(ReservationParamDTO reservationParamDTO);
	public List<ReservationInfoEntity> getsByEmail(String reservationEmail);
}
