package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.entity.ReservationUserCommentEntity;
import org.ggyool.reservation.service.ReservationUserCommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationUserCommentServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationUserCommentService service = ac.getBean(ReservationUserCommentService.class);
		
		
//		ReservationUserCommentEntity reservationUserCommentEntity= new ReservationUserCommentEntity();
//		reservationUserCommentEntity.setComment("comment");
//		reservationUserCommentEntity.setProductId(2);
//		reservationUserCommentEntity.setReservationInfoId(74);
//		reservationUserCommentEntity.setScore(2.0);
//		service.addComment(reservationUserCommentEntity);
	}
	
}
