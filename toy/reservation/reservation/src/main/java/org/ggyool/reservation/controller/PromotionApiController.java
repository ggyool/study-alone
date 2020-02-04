package org.ggyool.reservation.controller;

import java.util.HashMap;

import org.ggyool.reservation.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/promotions")
public class PromotionApiController {
	
	@Autowired
	PromotionService promotionService;
	
	@GetMapping
	public HashMap<String, Object> promotions(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("items", promotionService.getPromotions());
		return map;
	}
}
