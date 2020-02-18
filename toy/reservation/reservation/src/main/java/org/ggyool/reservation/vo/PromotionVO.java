package org.ggyool.reservation.vo;

import java.util.Date;

public class PromotionVO {
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
		return "PromotionVO [id=" + id + ", productId=" + productId + "]";
	}
}
