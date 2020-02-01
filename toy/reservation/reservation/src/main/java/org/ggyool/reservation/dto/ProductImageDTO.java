package org.ggyool.reservation.dto;

public class ProductImageDTO {
	private Long id;
	private Long productId;
	private String type;
	private Long fileId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "ProductImageDTO [id=" + id + ", productId=" + productId + ", type=" + type + ", fileId=" + fileId + "]";
	}
}
