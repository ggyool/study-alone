package org.ggyool.reservation.controller;

import javax.servlet.http.HttpSession;

import org.ggyool.reservation.dto.DisplayInfoDTO;
import org.ggyool.reservation.service.CommentService;
import org.ggyool.reservation.service.DisplayInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="products")
public class ProductController {
	
	@Autowired
	CommentService commentService;
	@Autowired
	DisplayInfoService displayInfoService;
	
	@GetMapping("/{displayInfoId}")
	public String productDetails(@PathVariable Integer displayInfoId, HttpSession session, Model model) {
		
		String sessionEmail = (String)session.getAttribute("email");
		if(sessionEmail!=null)
			model.addAttribute("sessionEmail", sessionEmail);
		return "detail";
	}
	
	@GetMapping("/{displayInfoId}/review")
	public String productReviewDetails(ModelMap model,
			@PathVariable Integer displayInfoId) {
		DisplayInfoDTO displayInfo = displayInfoService.get(displayInfoId);
		
		// null 이 안들어감
		System.out.println(displayInfo);
		if(displayInfo != null) {
			Integer productId = displayInfo.getProductId();
			String productDescription = displayInfo.getProductDescription();
			Double averageScore = commentService.getAverageScore(productId);
			model.addAttribute("displayInfoId", displayInfoId);
			model.addAttribute("productDescription", productDescription);
			model.addAttribute("commentList", commentService.getComments(productId));
			model.addAttribute("averageScore", averageScore);
			model.addAttribute("scorePercent", averageScore*20);
		}
		
		return "review";
	}
}


