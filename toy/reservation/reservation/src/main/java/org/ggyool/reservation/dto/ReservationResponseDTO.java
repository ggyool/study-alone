package org.ggyool.reservation.dto;

import java.util.Date;
import java.util.List;

import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.ggyool.reservation.entity.ReservationInfoEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

// 처음 계획은 ReservationInfoVO 상속 받으려 했으나 부모->자식 캐스팅이 안되어 포기
// service 가 부모를 return 함
public class ReservationResponseDTO{
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
	private List<ReservationInfoPriceEntity> prices;
	public ReservationResponseDTO(ReservationInfoEntity reservationInfoVO, List<ReservationInfoPriceEntity> prices){
		this.reservationInfoId = reservationInfoVO.getReservationInfoId();
		this.productId = reservationInfoVO.getProductId();
		this.displayInfoId = reservationInfoVO.getDisplayInfoId();
		this.reservationName = reservationInfoVO.getReservationName();
		this.reservationTelephone = reservationInfoVO.getReservationTelephone();
		this.reservationEmail = reservationInfoVO.getReservationEmail();
		this.reservationDate = reservationInfoVO.getReservationDate();
		this.cancelYn = reservationInfoVO.isCancelYn();
		this.createDate = reservationInfoVO.getCreateDate();
		this.modifyDate = reservationInfoVO.getModifyDate();
		this.prices = prices;
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
	public List<ReservationInfoPriceEntity> getPrices() {
		return prices;
	}
	public void setPrices(List<ReservationInfoPriceEntity> prices) {
		this.prices = prices;
	}
	@Override
	public String toString() {
		return "ReservationResponseDTO [reservationInfoId=" + reservationInfoId + ", productId=" + productId
				+ ", displayInfoId=" + displayInfoId + ", reservationName=" + reservationName
				+ ", reservationTelephone=" + reservationTelephone + ", reservationEmail=" + reservationEmail
				+ ", reservationDate=" + reservationDate + ", cancelYn=" + cancelYn + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", prices=" + prices + "]";
	}
}

