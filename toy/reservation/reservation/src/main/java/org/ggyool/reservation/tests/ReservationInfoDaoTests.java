package org.ggyool.reservation.tests;

import java.util.List;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dao.ReservationInfoDAO;
import org.ggyool.reservation.entity.ReservationInfoEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationInfoDaoTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationInfoDAO dao = ac.getBean(ReservationInfoDAO.class);
		List<ReservationInfoEntity> list = dao.selectByEmail("ggyool@naver.com"); 
		for(ReservationInfoEntity vo : list) {
			System.out.println(vo);
		}
	}
}
