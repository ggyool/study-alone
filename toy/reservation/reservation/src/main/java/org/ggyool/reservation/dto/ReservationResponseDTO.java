package org.ggyool.reservation.dto;

import java.util.Date;
import java.util.List;

import org.ggyool.reservation.vo.ReservationPriceVO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationResponseDTO {
	private boolean cancelYn;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date createDate;
	private Integer displayInfoId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modifyDate;
	private List<ReservationPriceVO> prices;
	private Integer productId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date reservationDate;
	private String reservationEmail;
	private Integer reservationInfoId;
	private String reservationName;
	private String reservationTelephone;
	public boolean isCancelYn() {
		return cancelYn;
	}
	public void setCancelYn(boolean cancelYn) {
		this.cancelYn = cancelYn;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(Integer displayInfoId) {
		this.displayInfoId = displayInfoId;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public List<ReservationPriceVO> getPrices() {
		return prices;
	}
	public void setPrices(List<ReservationPriceVO> prices) {
		this.prices = prices;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public Integer getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
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
	@Override
	public String toString() {
		return "ReservationResponseDTO [cancelYn=" + cancelYn + ", createDate=" + createDate + ", displayInfoId="
				+ displayInfoId + ", modifyDate=" + modifyDate + ", prices=" + prices + ", productId=" + productId
				+ ", reservationDate=" + reservationDate + ", reservationEmail=" + reservationEmail
				+ ", reservationInfoId=" + reservationInfoId + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + "]";
	}
}

