package org.ggyool.reservation.service.impl;

import java.util.List;

import org.ggyool.reservation.dao.CommentDAO;
import org.ggyool.reservation.dao.CommentImageDAO;
import org.ggyool.reservation.dto.CommentDTO;
import org.ggyool.reservation.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDAO commentDao;
	@Autowired
	CommentImageDAO commentImageDao;
	
	@Override
	@Transactional
	public List<CommentDTO> getComments(Integer productId) {
		List<CommentDTO> list = commentDao.selectByProductId(productId);
		for(CommentDTO comment : list) {
			Integer commentId = comment.getCommentId();
			comment.setCommentImages(commentImageDao.selectByCommentId(commentId));
		}
		return list;
	}

	@Override
	public Double getAverageScore(Integer productId) {
		return commentDao.selectAverageScore(productId);
	}

}
