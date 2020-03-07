package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.ReservationInfoPriceDAO;
import org.ggyool.reservation.vo.ReservationInfoPriceVO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationPriceDaoTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationInfoPriceDAO dao = ac.getBean(ReservationInfoPriceDAO.class);
		ReservationInfoPriceVO reservationPriceVO = new ReservationInfoPriceVO();
		reservationPriceVO.setCount(99);
		reservationPriceVO.setProductPriceId(1);
		reservationPriceVO.setReservationInfoId(1);		
		Integer res = dao.insert(reservationPriceVO);
		System.out.println(res);
		System.out.println(reservationPriceVO.getReservationInfoPriceId());
		
		
	}
}
