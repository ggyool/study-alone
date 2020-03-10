package org.ggyool.reservation.vo;

public class ReservationInfoPriceVO {
	private Integer reservationInfoPriceId;
	private Integer reservationInfoId;
	private Integer productPriceId;
	private Integer count;
	private Integer price;
	private Double discountRate;
	
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "ReservationInfoPriceVO [reservationInfoPriceId=" + reservationInfoPriceId + ", reservationInfoId="
				+ reservationInfoId + ", productPriceId=" + productPriceId + ", count=" + count + ", price=" + price
				+ ", discountRate=" + discountRate + "]";
	}
	
}
