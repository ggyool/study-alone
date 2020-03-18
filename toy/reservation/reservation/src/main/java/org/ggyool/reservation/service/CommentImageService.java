package org.ggyool.reservation.service;

import java.util.List;

import org.ggyool.reservation.dto.CommentImageDTO;
import org.ggyool.reservation.vo.CommentImageVO;

public interface CommentImageService {
	public List<CommentImageDTO> getsByCommentId(Integer commentId);
	public CommentImageVO getById(Integer commentImageId);
}
