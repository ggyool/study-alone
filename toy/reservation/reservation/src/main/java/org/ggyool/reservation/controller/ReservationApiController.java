package org.ggyool.reservation.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;

import org.ggyool.reservation.dto.CommentResponseDTO;
import org.ggyool.reservation.dto.ReservationInfoResponseDTO;
import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.entity.FileInfoEntity;
import org.ggyool.reservation.entity.ReservationUserCommentEntity;
import org.ggyool.reservation.service.CommentService;
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
	
	private final String DEFAULT_PATH = "/Users/ggyool/tmp/";
	@Autowired
	ReservationResponseService reservationResponseService;
	@Autowired
	ReservationInfoResponseService reservationInfoResponseService;
	@Autowired
	CommentService commentService;
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
	
	// 현재 날짜를 기준으로 폴더를 만들고, 그 안에 productId_reservationInfoId_fileName 으로 저장한다.
	@PostMapping("/{reservationInfoId}/comments")
	public CommentResponseDTO registerComment(@RequestParam(value="attachedImage", required=false) MultipartFile file,
			@RequestParam String comment,
			@RequestParam Integer productId,
			@RequestParam Integer score,
			@PathVariable Integer reservationInfoId) {
//		System.out.println(file);
//		System.out.println(comment);
//		System.out.println(productId);
//		System.out.println(reservationInfoId);
//		System.out.println(score);
		String fileName = null;
		String saveFileName = null;
		if(file != null) {
			String folderName = makeFolderName();
			String savePath = "img/";
			fileName = productId.toString() + '_' + reservationInfoId.toString() + '_' + file.getOriginalFilename();
			File folder = new File(DEFAULT_PATH + savePath + folderName);
			if(!folder.exists()) {
				folder.mkdir();
			}
			saveFileName = savePath + folderName + '/' + fileName;
			try(
				FileOutputStream fos = new FileOutputStream(DEFAULT_PATH  + saveFileName);
				InputStream is = file.getInputStream();		
			) {
				int readCount = 0;
				byte[] buffer = new byte[1024];
				while((readCount=is.read(buffer)) != -1) {
					fos.write(buffer, 0, readCount);
				}
			}
			catch(Exception ex) {
				throw new RuntimeException();
			}
		}
		
		ReservationUserCommentEntity reservationUserCommentEntity = new ReservationUserCommentEntity();
		reservationUserCommentEntity.setComment(comment);
		reservationUserCommentEntity.setProductId(productId);
		reservationUserCommentEntity.setScore((double)score);
		reservationUserCommentEntity.setReservationInfoId(reservationInfoId);
		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
		if(file==null) {
			commentResponseDTO = commentService.addReservation(reservationUserCommentEntity);
		}
		else {
			FileInfoEntity fileInfoEntity = new FileInfoEntity();
			fileInfoEntity.setFileName(fileName);
			fileInfoEntity.setSaveFileName(saveFileName);
			fileInfoEntity.setContentType(file.getContentType());
			try {
				commentResponseDTO = commentService.addReservationWithFile(reservationUserCommentEntity, fileInfoEntity);
			}catch(Exception ex) {
			 	// db에 넣는데 실패하면 파일 삭제
				File deleteTarget = new File(DEFAULT_PATH + saveFileName);
				if(deleteTarget.exists()) {
					deleteTarget.delete();
				}
				commentResponseDTO = null;
			}
		}
		return commentResponseDTO;
	}
	
	public String makeFolderName() {
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH)+1);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		return year+month+day;
	}
}


