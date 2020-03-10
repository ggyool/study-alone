package org.ggyool.reservation.dto;

import java.util.Date;
import java.util.List;

import org.ggyool.reservation.entity.ReservationInfoPriceEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationParamDTO {
	private Integer displayInfoId;
	private List<ReservationInfoPriceEntity> prices;
	private Integer productId;
	private String reservationEmail;
	private String reservationName;
	private String reservationTelephone;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date reservationYearMonthDay;
	public Integer getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(Integer displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public List<ReservationInfoPriceEntity> getPrices() {
		return prices;
	}
	public void setPrices(List<ReservationInfoPriceEntity> prices) {
		this.prices = prices;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}
	public String getReservationTelephone() {
		return reservationTelephone;
	}
	public void setReservationTelephone(String reservationTelephone) {
		this.reservationTelephone = reservationTelephone;
	}
	public Date getReservationYearMonthDay() {
		return reservationYearMonthDay;
	}
	public void setReservationYearMonthDay(Date reservationYearMonthDay) {
		this.reservationYearMonthDay = reservationYearMonthDay;
	}
	@Override
	public String toString() {
		return "ReservationParamDTO [displayInfoId=" + displayInfoId + ", prices=" + prices + ", productId=" + productId
				+ ", reservationEmail=" + reservationEmail + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + ", reservationYearMonthDay="
				+ reservationYearMonthDay + "]";
	}
}
