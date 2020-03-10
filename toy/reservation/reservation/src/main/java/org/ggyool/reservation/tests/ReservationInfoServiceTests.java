package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.entity.ReservationInfoEntity;
import org.ggyool.reservation.service.ReservationInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationInfoServiceTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationInfoService service = ac.getBean(ReservationInfoService.class);
		
		//ReservationInfoVO reservationInfoVO = new ReservationInfoVO();
		//reservationInfoVO.setDisplayInfoId(displayInfoId);
		
		//service.addReservationInfo(reservationInfoVO)
		
		
	}
}
