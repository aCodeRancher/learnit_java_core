package com.itbulls.learnit.javacore.patterns.structural.decorator;

public abstract class Car {

	protected String message;

	public abstract String drive();

	public  String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		  this.message = message;
	}
}