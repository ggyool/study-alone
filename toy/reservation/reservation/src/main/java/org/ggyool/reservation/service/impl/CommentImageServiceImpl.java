package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.CommentImageDAO;
import org.ggyool.reservation.dto.CommentImageDTO;
import org.ggyool.reservation.service.CommentImageService;
import org.ggyool.reservation.vo.CommentImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentImageServiceImpl implements CommentImageService{
	
	@Autowired
	CommentImageDAO commentImageDAO;
	
	@Override
	public List<CommentImageDTO> getsByCommentId(Integer commentId) {
		return commentImageDAO.selectByCommentId(commentId);
	}

	@Override
	public CommentImageVO getById(Integer commentImageId) {
		return commentImageDAO.selectById(commentImageId);
	}

}
