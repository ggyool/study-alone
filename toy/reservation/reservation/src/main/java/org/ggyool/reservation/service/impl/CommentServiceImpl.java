package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.CommentDAO;
import org.ggyool.reservation.dto.CommentDTO;
import org.ggyool.reservation.dto.CommentImageDTO;
import org.ggyool.reservation.dto.CommentResponseDTO;
import org.ggyool.reservation.entity.FileInfoEntity;
import org.ggyool.reservation.entity.ReservationUserCommentEntity;
import org.ggyool.reservation.entity.ReservationUserCommentImageEntity;
import org.ggyool.reservation.service.CommentImageService;
import org.ggyool.reservation.service.CommentService;
import org.ggyool.reservation.service.FileInfoService;
import org.ggyool.reservation.service.ReservationUserCommentImageService;
import org.ggyool.reservation.service.ReservationUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDAO commentDAO;
	@Autowired
	CommentImageService commentImageService;
	@Autowired
	ReservationUserCommentService reservationUserCommentService;
	@Autowired
	ReservationUserCommentImageService reservationUserCommentImageService;
	@Autowired
	FileInfoService fileInfoService;
	
	@Override
	@Transactional
	public List<CommentDTO> getComments(Integer productId) {
		List<CommentDTO> list = commentDAO.selectByProductId(productId);
		for(CommentDTO comment : list) {
			Integer commentId = comment.getCommentId();
			comment.setCommentImages(commentImageService.getsByCommentId(commentId));
		}
		return list;
	}

	@Override
	public Double getAverageScore(Integer productId) {
		return commentDAO.selectAverageScore(productId);
	}

	@Override
	public CommentResponseDTO addReservation(ReservationUserCommentEntity reservationUserCommentEntity) {
		reservationUserCommentEntity = reservationUserCommentService.addComment(reservationUserCommentEntity);
		return new CommentResponseDTO(reservationUserCommentEntity);
	}

	// start transcation
	@Override
	@Transactional(rollbackFor={Exception.class})
	public CommentResponseDTO addReservationWithFile(ReservationUserCommentEntity reservationUserCommentEntity, FileInfoEntity fileInfoEntity) {
		reservationUserCommentEntity = reservationUserCommentService.addComment(reservationUserCommentEntity);
		Integer reservationUserCommentId = reservationUserCommentEntity.getId();
		Integer reservationInfoId = reservationUserCommentEntity.getReservationInfoId();
		fileInfoEntity = fileInfoService.addFileInfo(fileInfoEntity);
		Integer fileId = fileInfoEntity.getId();
		
		ReservationUserCommentImageEntity reservationUserCommentImageEntity = new ReservationUserCommentImageEntity(); 
		reservationUserCommentImageEntity.setReservationInfoId(reservationInfoId);
		reservationUserCommentImageEntity.setReservationUserCommentId(reservationUserCommentId);
		reservationUserCommentImageEntity.setFileId(fileId);
		reservationUserCommentImageService.addCommentImage(reservationUserCommentImageEntity);
		
		CommentImageDTO commentImageDTO = new CommentImageDTO(reservationUserCommentImageEntity, fileInfoEntity);
		return new CommentResponseDTO(reservationUserCommentEntity, commentImageDTO);
	}
}




