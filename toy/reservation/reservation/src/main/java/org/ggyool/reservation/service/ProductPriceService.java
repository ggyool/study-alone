package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.vo.ProductPriceVO;

public interface ProductPriceService {
	public List<ProductPriceVO> getPrices(Integer productId);
	public ProductPriceVO getPrice(Integer productPriceId);
}
