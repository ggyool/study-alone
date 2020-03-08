package org.ggyool.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ggyool.reservation.dto.DisplayInfoResponseDTO;
import org.ggyool.reservation.service.CategoryService;
import org.ggyool.reservation.service.CommentService;
import org.ggyool.reservation.service.DisplayInfoImageService;
import org.ggyool.reservation.service.DisplayInfoService;
import org.ggyool.reservation.service.ProductImageService;
import org.ggyool.reservation.service.ProductPriceService;
import org.ggyool.reservation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/products")
public class ProductApiController {
	
	@Autowired
	ProductService productSerice;
	@Autowired
	CategoryService categoryService;
	@Autowired
	CommentService commentService;
	@Autowired
	DisplayInfoService displayInfoService;
	@Autowired
	DisplayInfoImageService displayInfoImageService;
	@Autowired
	ProductImageService productImageService;
	@Autowired
	ProductPriceService productPriceService;
	
	@GetMapping
	public Map<String, Object> products(
			@RequestParam(name="categoryId", required=false) Integer categoryId,
			@RequestParam(name="start",  required=false, defaultValue="0") int start) {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = productSerice.getPrductsByCategory(categoryId, start);
		int totalCount = categoryService.countProducts(categoryId);
		map.put("items", list);
		map.put("totalCount", totalCount);
		return map;
	}
	
	@GetMapping("/{displayInfoId}")
	public DisplayInfoResponseDTO productsDetails(
			@PathVariable("displayInfoId") Integer displayInfoId){
		// 서비스로 빼야하는지 잘 모르겠다. insert 없어서 걍 했다.
		Integer productId;
		DisplayInfoResponseDTO dto = new DisplayInfoResponseDTO();
		dto.setDisplayInfo(displayInfoService.get(displayInfoId));
		dto.setDisplayInfoImage(displayInfoImageService.getImage(displayInfoId));
		productId = dto.getDisplayInfo().getProductId();
		dto.setProductImages(productImageService.getImages(productId));
		dto.setProductPrices(productPriceService.getPrices(productId));
		dto.setComments(commentService.getComments(productId));
		dto.setAverageScore(commentService.getAverageScore(productId));
		return dto;
	}
}




