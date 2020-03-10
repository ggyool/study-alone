package org.ggyool.reservation.tests;

import java.util.List;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dto.ReservationInfoDTO;
import org.ggyool.reservation.dto.ReservationInfoResponseDTO;
import org.ggyool.reservation.service.ReservationInfoResponseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationInfoResponseServiceTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationInfoResponseService service = ac.getBean(ReservationInfoResponseService.class);
		
		ReservationInfoResponseDTO response = service.getByEmail("ggyool@naver.com");
		List<ReservationInfoDTO> list = response.getReservations();
		int len = response.getSize();
		for(int i=0; i<len; ++i) {
			Integer id = list.get(i).getReservationInfoId();
			String name = list.get(i).getReservationName();
			System.out.println(id + " " + name + list.get(i).getTotalPrice());
		}
	}
}
