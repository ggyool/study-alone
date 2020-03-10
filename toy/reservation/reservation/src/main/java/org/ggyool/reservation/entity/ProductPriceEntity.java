package org.ggyool.reservation.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductPriceEntity {
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date createDate;
	private Double discountRate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Date modifyDate;
	private Integer price;
	private String priceTypeName;
	private Integer productId;
	private Integer productPriceId;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Double getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPriceTypeName() {
		return priceTypeName;
	}
	public void setPriceTypeName(String priceTypeName) {
		this.priceTypeName = priceTypeName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductPriceId() {
		return productPriceId;
	}
	public void setProductPriceId(Integer productPriceId) {
		this.productPriceId = productPriceId;
	}
	@Override
	public String toString() {
		return "ProductPriceEntity [createDate=" + createDate + ", discountRate=" + discountRate + ", modifyDate="
				+ modifyDate + ", price=" + price + ", priceTypeName=" + priceTypeName + ", productId=" + productId
				+ ", productPriceId=" + productPriceId + "]";
	}
}