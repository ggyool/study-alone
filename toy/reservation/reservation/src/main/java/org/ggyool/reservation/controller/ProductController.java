package org.ggyool.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ggyool.reservation.dto.CommentDTO;
import org.ggyool.reservation.entity.ProductEntity;
import org.ggyool.reservation.service.CommentService;
import org.ggyool.reservation.service.ProductService;
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
	ProductService productService;
	
	@GetMapping("/{displayInfoId}")
	public String productDetails(@PathVariable Integer displayInfoId, HttpSession session, Model model) {
		
		String sessionEmail = (String)session.getAttribute("email");
		if(sessionEmail!=null)
			model.addAttribute("sessionEmail", sessionEmail);
		return "detail";
	}
	
	@GetMapping("/{productId}/reviews")
	public String productReviewDetails(ModelMap model,
			@PathVariable Integer productId) {
		ProductEntity productEntity = productService.get(productId);
		String productDescription = productEntity.getDescription();
		List<CommentDTO> commentList = commentService.getComments(productId);
		Double averageScore;
		if(commentList.isEmpty()) {
			averageScore = 0D;
		}
		else {
			averageScore = commentService.getAverageScore(productId);
		}
		model.addAttribute("productDescription", productDescription);
		model.addAttribute("commentList", commentList);
		model.addAttribute("averageScore", averageScore);
		model.addAttribute("scorePercent", averageScore*20);
		return "review";
	}
	
	@GetMapping("/{productId}/review")
	public String productReviewWrite(ModelMap model,
			@PathVariable Integer productId) {
		ProductEntity productEntity = productService.get(productId);
		String productDescription = productEntity.getDescription();
		model.addAttribute("productDescription", productDescription);  
		return "reviewwrite"; 
	}
}


