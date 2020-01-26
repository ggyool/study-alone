package org.ggyool.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//Car car = (Car)ac.getBean("car"); // 둘 다 됨
		Car car = (Car)ac.getBean(Car.class);
		car.run();
	}
}
