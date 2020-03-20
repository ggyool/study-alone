package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.CommentDTO;
import org.ggyool.reservation.dto.CommentResponseDTO;
import org.ggyool.reservation.entity.FileInfoEntity;
import org.ggyool.reservation.entity.ReservationUserCommentEntity;

public interface CommentService {
	public List<CommentDTO> getComments(Integer productId);
	public Double getAverageScore(Integer productId);
	public CommentResponseDTO addReservation(ReservationUserCommentEntity reservationUserCommentEntity);
	public CommentResponseDTO addReservationWithFile(ReservationUserCommentEntity reservationUserCommentEntity, FileInfoEntity fileInfoEntity);
}
