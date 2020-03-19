package org.ggyool.reservation.controller;

import org.ggyool.reservation.dto.CommentResponseDTO;
import org.ggyool.reservation.dto.ReservationInfoResponseDTO;
import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.service.ReservationInfoResponseService;
import org.ggyool.reservation.service.ReservationResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path="/api/reservations")
public class ReservationApiController {
	
	@Autowired
	ReservationResponseService reservationResponseService;
	@Autowired
	ReservationInfoResponseService reservationInfoResponseService;
	
	@GetMapping
	public ReservationInfoResponseDTO reservationsGet(String reservationEmail) {
		return reservationInfoResponseService.getByEmail(reservationEmail);
	}
	@PostMapping
	public ReservationResponseDTO reservationsPost(@RequestBody ReservationParamDTO reservationParamDTO) {
		ReservationResponseDTO reservationResponseDTO = reservationResponseService.getReseravtionResponse(reservationParamDTO);
		return reservationResponseDTO;
	}
	@PutMapping(path="/{reservationId}")
	public ReservationResponseDTO reservationCancel(@PathVariable("reservationId") Integer reservationInfoId) {
		return reservationResponseService.cancelReseravtion(reservationInfoId);
	}
	@PostMapping("/{reservationInfoId}/comments")
	public CommentResponseDTO registerComment(@RequestParam(value="attachedImage", required=false) MultipartFile file,
			@RequestParam String comment,
			@RequestParam Integer productId,
			@RequestParam Integer score,
			@PathVariable Integer reservationInfoId) {
		
		System.out.println("originalName: " + file.getOriginalFilename());
		System.out.println("name: " + file.getName());
		System.out.println("size: " + file.getSize());
		System.out.println("contentType: " + file.getContentType());
		System.out.println("comment: " + comment);
		System.out.println("productId: " + productId);
		System.out.println("score: " + score);
		System.out.println("reservationInfoId: " + reservationInfoId);
		
		
		return null;
	}
}