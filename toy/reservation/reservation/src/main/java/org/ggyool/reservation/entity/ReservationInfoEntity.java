package org.ggyool.reservation.entity;

import java.util.Date;

import org.ggyool.reservation.dto.ReservationParamDTO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationInfoEntity {
	private Integer reservationInfoId;
	private Integer productId;
	private Integer displayInfoId;
	private String reservationName;
	private String reservationTelephone;
	private String reservationEmail;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date reservationDate;
	private boolean cancelYn;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modifyDate;
	ReservationInfoEntity(){
		
	}
	public ReservationInfoEntity(ReservationParamDTO reservationParamDTO) {
		this.displayInfoId = reservationParamDTO.getDisplayInfoId();
		this.productId = reservationParamDTO.getProductId();
		this.reservationEmail = reservationParamDTO.getReservationEmail();
		this.reservationName = reservationParamDTO.getReservationName();
		this.reservationTelephone = reservationParamDTO.getReservationTelephone();
	}
	public Integer getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getDisplayInfoId() {
		return displayInfoId;
	}
	public void setDisplayInfoId(Integer displayInfoId) {
		this.displayInfoId = displayInfoId;
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
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
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
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "ReservationInfoEntity [reservationInfoId=" + reservationInfoId + ", productId=" + productId
				+ ", displayInfoId=" + displayInfoId + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + ", reservationEmail=" + reservationEmail
				+ ", reservationDate=" + reservationDate + ", cancelYn=" + cancelYn + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + "]";
	}
}
