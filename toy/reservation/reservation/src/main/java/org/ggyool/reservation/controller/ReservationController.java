package org.ggyool.reservation.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ggyool.reservation.entity.ProductEntity;
import org.ggyool.reservation.service.ProductService;
import org.ggyool.reservation.service.ReservationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping(path="reservations")
public class ReservationController {
	
	@Autowired
	ProductService productService;
	@Autowired
	ReservationInfoService reservationInfoService;
	
	@GetMapping(path="/me")
	public String myReservation(HttpSession session, Model model) {
		String sessionEmail = (String)session.getAttribute("email");
		if(sessionEmail!=null) model.addAttribute("sessionEmail", sessionEmail);
		return "myreservation";
	}
	
	
	// productId를 주소에서 숨기기 위해 redirect 하였음 
	@GetMapping("/{reservationInfoId}/review")
	public String productReviewWrite(HttpServletRequest request, ModelMap model,
			@PathVariable Integer reservationInfoId) {
		Map<String,?> flashMap = RequestContextUtils.getInputFlashMap(request);
		// redirect로 접근하지 않은 경우
		if(flashMap==null) {
			return "redirect:/reservations/me";
		}
		Integer productId = (Integer)flashMap.get("productId");
		ProductEntity productEntity = productService.get((Integer)productId);
		String productDescription = productEntity.getDescription();
		model.addAttribute("productDescription", productDescription);
		model.addAttribute("productId", productId);
		return "reviewwrite"; 
	}
	
	@GetMapping("/{reservationInfoId}/review/{productId}")
	public String passProductReviewWrite(RedirectAttributes rttr,
			@PathVariable("reservationInfoId") Integer reservationInfoId,
			@PathVariable("productId") Integer productId) {
		rttr.addFlashAttribute("productId", productId);
		return "redirect:/reservations/"+reservationInfoId+"/review";
	}
	
	
}
