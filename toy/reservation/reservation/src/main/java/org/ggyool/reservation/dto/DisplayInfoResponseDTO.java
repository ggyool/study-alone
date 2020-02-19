package org.ggyool.reservation.dto;

import java.util.List;

import org.ggyool.reservation.vo.ProductPriceVO;

public class DisplayInfoResponseDTO {
	private Double averageScore;
	private List<CommentDTO> comments;
	private DisplayInfoDTO displayInfo;
	private DisplayInfoImageDTO displayInfoImage;
	private List<ProductImageDTO> productImages;
	private List<ProductPriceVO> productPrices;
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	public List<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	public DisplayInfoDTO getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(DisplayInfoDTO displayInfo) {
		this.displayInfo = displayInfo;
	}
	public DisplayInfoImageDTO getDisplayInfoImage() {
		return displayInfoImage;
	}
	public void setDisplayInfoImage(DisplayInfoImageDTO displayInfoImage) {
		this.displayInfoImage = displayInfoImage;
	}
	public List<ProductImageDTO> getProductImages() {
		return productImages;
	}
	public void setProductImages(List<ProductImageDTO> productImages) {
		this.productImages = productImages;
	}
	public List<ProductPriceVO> getProductPrices() {
		return productPrices;
	}
	public void setProductPrices(List<ProductPriceVO> productPrices) {
		this.productPrices = productPrices;
	}
	@Override
	public String toString() {
		return "DisplayInfoResponseDTO [averageScore=" + averageScore + ", comments=" + comments + ", displayInfo="
				+ displayInfo + ", displayInfoImage=" + displayInfoImage + ", productImages=" + productImages
				+ ", productPrices=" + productPrices + "]";
	}
	
}
