package org.ggyool.reservation.dto;

import java.util.Date;

import org.ggyool.reservation.entity.ReservationInfoEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationInfoDTO {
	private boolean cancelYn;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date createDate;
	private DisplayInfoDTO displayInfo;
	private Integer displayInfoId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modifyDate;
	private Integer productId;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date reservationDate;
	private String reservationEmail;
	private Integer reservationInfoId;
	private String reservationName;
	private String reservationTelephone;
	private Long totalPrice;
	public ReservationInfoDTO(ReservationInfoEntity reservationInfoEntity, DisplayInfoDTO displayInfoDTO, Long totalPrice){
		this.cancelYn = reservationInfoEntity.isCancelYn();
		this.createDate = reservationInfoEntity.getCreateDate();
		this.displayInfo = displayInfoDTO;
		this.displayInfoId = reservationInfoEntity.getDisplayInfoId();
		this.modifyDate = reservationInfoEntity.getModifyDate();
		this.productId = reservationInfoEntity.getProductId();
		this.reservationDate = reservationInfoEntity.getReservationDate();
		this.reservationEmail = reservationInfoEntity.getReservationEmail();
		this.reservationInfoId = reservationInfoEntity.getReservationInfoId();
		this.reservationName = reservationInfoEntity.getReservationName();
		this.reservationTelephone = reservationInfoEntity.getReservationTelephone();
		this.totalPrice = totalPrice;
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
	public DisplayInfoDTO getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(DisplayInfoDTO displayInfo) {
		this.displayInfo = displayInfo;
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
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "ReservationInfoDTO [cancelYn=" + cancelYn + ", createDate=" + createDate + ", displayInfo="
				+ displayInfo + ", displayInfoId=" + displayInfoId + ", modifyDate=" + modifyDate + ", productId="
				+ productId + ", reservationDate=" + reservationDate + ", reservationEmail=" + reservationEmail
				+ ", reservationInfoId=" + reservationInfoId + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + ", totalPrice=" + totalPrice + "]";
	}
}
