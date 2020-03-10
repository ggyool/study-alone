package org.ggyool.reservation.tests;

import java.util.ArrayList;
import java.util.List;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.dto.ReservationParamDTO;
import org.ggyool.reservation.dto.ReservationResponseDTO;
import org.ggyool.reservation.entity.ReservationInfoPriceEntity;
import org.ggyool.reservation.entity.ReservationInfoEntity;
import org.ggyool.reservation.service.ReservationInfoPriceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReservationPriceServiceTests {
	
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ReservationInfoPriceService service = ac.getBean(ReservationInfoPriceService.class);
		System.out.println(service.getsByReservationInfoId(1));
		
		
		
		/*
		List<ReservationPriceVO> dummys = new ArrayList<>();
		for(int i=0 ;i<3; ++i) {
			ReservationPriceVO vo = new ReservationPriceVO();
			vo.setCount(i*111);
			vo.setProductPriceId(1);
			if(i==2) vo.setReservationInfoId(2);
			else vo.setReservationInfoId(1);
			dummys.add(vo);
		}
		List<ReservationPriceVO> list = service.addReservationPrices(dummys);
		for(int i=0; i<3; ++i) {
			System.out.println(list.get(i));
		}*/
	
		
	}
}




