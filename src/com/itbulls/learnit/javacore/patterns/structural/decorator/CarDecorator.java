package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class CarDecorator extends Car {

	private Car car;
    public CarDecorator(Car car) {
		this.car = car;
	}

	@Override
	public String drive() {
		return this.car.drive();
	}

}
