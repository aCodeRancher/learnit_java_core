package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class SportsCar extends CarDecorator {

	private String transmissionMode;
	
	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public String drive() {
		 return super.drive().concat(this.getMessage());
	 }
	
	public void setTransmissionMode(String transmissionMode) {
		this.transmissionMode = transmissionMode;
	}
}