package org.ggyool.reservation.dto;

public class PromotionDTO {
	private Integer id;
	private Integer productId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "PromotionDTO [id=" + id + ", productId=" + productId + "]";
	}
}
