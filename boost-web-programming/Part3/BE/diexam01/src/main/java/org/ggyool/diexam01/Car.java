package org.ggyool.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine v8;
	public Car() {
		System.out.println("Car constructor!");
	}
	public void run() {
		System.out.println("car run!");
		v8.exec();
	}
}
