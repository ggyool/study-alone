package org.ggyool.reservation.service.impl;

import org.ggyool.reservation.dao.ReservationUserCommentImageDAO;
import org.ggyool.reservation.entity.ReservationUserCommentImageEntity;
import org.ggyool.reservation.service.ReservationUserCommentImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationUserCommentImageServiceImpl implements ReservationUserCommentImageService{

	@Autowired
	ReservationUserCommentImageDAO reservationUserCommentImageDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public ReservationUserCommentImageEntity addCommentImage(
			ReservationUserCommentImageEntity reservationUserCommentImageEntity) {
		
		Integer id = reservationUserCommentImageDAO.insert(reservationUserCommentImageEntity);
		reservationUserCommentImageEntity.setId(id);
		return reservationUserCommentImageEntity;
	}

}
