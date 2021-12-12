package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class BasicCar extends Car {


    @Override
	public String drive() {
            return  this.getMessage() ;
	}

}
