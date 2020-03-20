package org.ggyool.reservation.service.impl;

import java.util.Date;

import org.ggyool.reservation.dao.ReservationUserCommentDAO;
import org.ggyool.reservation.entity.ReservationUserCommentEntity;
import org.ggyool.reservation.service.ReservationUserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationUserCommentServiceImpl implements ReservationUserCommentService{

	@Autowired
	ReservationUserCommentDAO reservationUserCommentDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ReservationUserCommentEntity addComment(ReservationUserCommentEntity reservationUserCommentEntity) {
		Date currentDate = new Date();
		reservationUserCommentEntity.setCreateDate(currentDate);
		reservationUserCommentEntity.setModifyDate(currentDate);
		Integer id = reservationUserCommentDAO.insert(reservationUserCommentEntity);
		reservationUserCommentEntity.setId(id);
		return reservationUserCommentEntity;
	}

}
