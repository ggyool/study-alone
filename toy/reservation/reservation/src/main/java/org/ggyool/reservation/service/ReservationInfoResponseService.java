package org.ggyool.reservation.service;

import org.ggyool.reservation.dto.ReservationInfoResponseDTO;

public interface ReservationInfoResponseService {
	public ReservationInfoResponseDTO getByEmail(String reservationEmail);
}
