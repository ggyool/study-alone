package org.ggyool.calculatorcli;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
	public int plus(int v1, int v2) {
		return v1+v2;
	}
	public int minus(int v1, int v2) {
		return v1-v2;
	}
	public int multiple(int v1, int v2) {
		return v1*v2;
	}
	public int divide(int v1, int v2) throws ArithmeticException{
		return v1/v2;
	}
}
