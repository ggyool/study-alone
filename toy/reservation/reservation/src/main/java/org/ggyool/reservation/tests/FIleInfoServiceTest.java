package org.ggyool.reservation.tests;

import org.ggyool.reservation.config.ApplicationConfig;
import org.ggyool.reservation.entity.FileInfoEntity;
import org.ggyool.reservation.service.FileInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FIleInfoServiceTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		FileInfoService service = ac.getBean(FileInfoService.class);
		
//		FileInfoEntity fileInfoEntity = new FileInfoEntity();
//		fileInfoEntity.setContentType("sss");
//		fileInfoEntity.setFileName("fname");
//		fileInfoEntity.setSaveFileName("sfname");
//	
	}
}
