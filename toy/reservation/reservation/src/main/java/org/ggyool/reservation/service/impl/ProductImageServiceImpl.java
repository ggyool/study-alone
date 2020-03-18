package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.ProductImageDAO;
import org.ggyool.reservation.dto.ProductImageDTO;
import org.ggyool.reservation.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService{
	
	@Autowired
	ProductImageDAO productImageDao;
	
	@Override
	public List<ProductImageDTO> getImages(Integer productId) {
		return productImageDao.selectByProductId(productId);
	}

	@Override
	public ProductImageDTO getThumbnailImage(Integer productId) {
		return productImageDao.selectThumbnailByProductId(productId);
	}

	@Override
	public ProductImageDTO get(Integer productImageId) {
		return productImageDao.selectById(productImageId);
	}

}
