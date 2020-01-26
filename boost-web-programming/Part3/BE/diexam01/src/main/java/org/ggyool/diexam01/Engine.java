package org.ggyool.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public Engine() {
		System.out.println("engine constructor!");
	}
	public void exec() {
		System.out.println("engine run!");
	}
}
