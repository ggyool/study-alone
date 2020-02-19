package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.CommentDTO;

public interface CommentService {
	public List<CommentDTO> getComments(Integer productId);
	public Double getAverageScore(Integer productId);
}
