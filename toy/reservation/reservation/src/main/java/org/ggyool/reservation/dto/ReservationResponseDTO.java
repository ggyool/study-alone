package org.ggyool.reservation.dto;

import java.util.Date;
import java.util.List;

import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.ggyool.reservation.vo.ReservationInfoVO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationResponseDTO extends ReservationInfoVO{
	private List<ReservationInfoPriceVO> prices;
	public List<ReservationInfoPriceVO> getPrices() {
		return prices;
	}
	public void setPrices(List<ReservationInfoPriceVO> prices) {
		this.prices = prices;
	}
	@Override
	public String toString() {
		return super.toString() + "ReservationResponseDTO [prices=" + prices + "]";
	}
	
}

