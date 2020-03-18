package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.ProductImageDTO;

public interface ProductImageService {
	List<ProductImageDTO> getImages(Integer productId);
	ProductImageDTO getThumbnailImage(Integer productId);
	ProductImageDTO get(Integer productImageId);
}
