package com.itbulls.learnit.javacore.patterns.structural.decorator;

public class Demo {
	public static void main(final String[] args) {
		Car basicCar = new BasicCar();
		basicCar.setMessage("Basic car drives");
		System.out.println(basicCar.drive());
		System.out.println("\n*****");

		BasicCar basicCar1 = new BasicCar();
		basicCar1.setMessage("Basic car drives");
	    SportsCar sportsCar = new SportsCar(basicCar1);
	    sportsCar.setMessage("And drivers fast like a Sports Car");
		System.out.println(sportsCar.drive());
		sportsCar.setTransmissionMode("sport+");
		System.out.println("\n*****");

		BasicCar basicCar2 = new BasicCar();
		basicCar2.setMessage("Basic car drives");
		LuxuryCar luxuryCar = new LuxuryCar(basicCar2);
		luxuryCar.setMessage(" And drives soft as luxury car");
		SportsCar sportsLuxuryCar = new SportsCar(luxuryCar);
		sportsLuxuryCar.setMessage(" And drivers fast like a Sports Car");
		System.out.println(sportsLuxuryCar.drive());
		System.out.println("\n*****");
   }
}
