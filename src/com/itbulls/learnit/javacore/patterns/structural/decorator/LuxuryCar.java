package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class LuxuryCar extends CarDecorator {


	public LuxuryCar(Car car) {
		super(car);
	}

	@Override
	public String drive() {
		return super.drive().concat(this.getMessage());
    }

}