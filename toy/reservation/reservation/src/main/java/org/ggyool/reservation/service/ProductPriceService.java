package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.entity.ProductPriceEntity;

public interface ProductPriceService {
	public List<ProductPriceEntity> getPrices(Integer productId);
	public ProductPriceEntity getPrice(Integer productPriceId);
}
