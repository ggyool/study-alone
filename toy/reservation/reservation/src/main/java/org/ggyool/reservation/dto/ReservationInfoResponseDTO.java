package org.ggyool.reservation.dto;

import java.util.List;

public class ReservationInfoResponseDTO {
	private List<ReservationInfoDTO> reservations;
	private Integer size;
	public List<ReservationInfoDTO> getReservations() {
		return reservations;
	}
	public void setReservations(List<ReservationInfoDTO> reservations) {
		this.reservations = reservations;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "ReservationInfoResponseDTO [reservations=" + reservations + ", size=" + size + "]";
	}
}
