package org.ggyool.reservation.service;

import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;

public interface ReservationResponseService {
	ReservationResponseDTO getReseravtionResponse(ReservationParamDTO reservationParamDTO); 
}
