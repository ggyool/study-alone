package org.ggyool.reservation.tests;

import java.util.List;
import java.util.Map;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.ReservationInfoPriceDAO;
import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationPriceDaoTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationInfoPriceDAO dao = ac.getBean(ReservationInfoPriceDAO.class);
		
		
		ReservationInfoPriceEntity reservationPriceEntity = new ReservationInfoPriceEntity();
		reservationPriceEntity.setCount(999);
		reservationPriceEntity.setReservationInfoId(1);
		reservationPriceEntity.setProductPriceId(1);
		Integer id =  dao.insert(reservationPriceEntity);
		System.out.println(id);
		
//		List<Map<String, Object>> list = dao.selectByReservationInfoId(1);
//		for(Map<String, Object> vo:list) {
//			System.out.println(vo);
//		}
		
		
		
	}
}
