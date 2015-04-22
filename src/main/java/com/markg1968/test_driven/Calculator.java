package com.markg1968.test_driven;

public class Calculator {

	public int add(int numberOne, int numberTwo) {
		return numberOne + numberTwo;
	}
	
	public int add(int numberOne, NumberProvider numberProvider) {
		return numberOne + numberProvider.getNumber();
	}

}
