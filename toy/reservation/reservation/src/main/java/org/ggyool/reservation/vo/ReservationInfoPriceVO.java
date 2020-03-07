package org.ggyool.reservation.vo;

// front에서의 입력을 바로 사용하기 위해 변수이름 기준을 그 쪽으로 했다.
public class ReservationInfoPriceVO {
	private Integer reservationInfoPriceId;
	private Integer reservationInfoId;
	private Integer productPriceId;
	private Integer count;
	public Integer getReservationInfoPriceId() {
		return reservationInfoPriceId;
	}
	public void setReservationInfoPriceId(Integer reservationInfoPriceId) {
		this.reservationInfoPriceId = reservationInfoPriceId;
	}
	public Integer getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(Integer reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ReservationInfoPriceVO [reservationInfoPriceId=" + reservationInfoPriceId + ", reservationInfoId="
				+ reservationInfoId + ", productPriceId=" + productPriceId + ", count=" + count + "]";
	}
}
