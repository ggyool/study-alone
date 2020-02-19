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
		return productImageDao.selectById(productId);
	}

}
