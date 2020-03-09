package org.ggyool.reservation.tests;

import java.util.List;

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
		
		List<ReservationInfoPriceVO> list = dao.selectByReservationInfoId(1);
		for(ReservationInfoPriceVO vo:list) {
			System.out.println(vo);	
		}
		
		
		
	}
}
