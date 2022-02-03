package com.itbulls.learnit.javacore.multithreading.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo2 {

	private Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		var demo = new ReentrantLockDemo2();
		var es = Executors.newFixedThreadPool(4);
		
		es.execute(() -> System.out.println(demo.calculate("+", 2, 3)));
		es.execute(() -> System.out.println(demo.calculate("+", 7, 12)));
		es.execute(() -> System.out.println(demo.calculate("+", 87, 4)));
		
		es.execute(() -> System.out.println(demo.calculate("-", 2, 3)));
		es.execute(() -> System.out.println(demo.calculate("-", 57, 12)));
		es.execute(() -> System.out.println(demo.calculate("-", 110, 7)));
		
		terminateExecutorService(es);
		
	}

	public double add(double value1, double value2) {
		try {
			lock.lock();
			System.out.println("-- add -- lock is acquired by Thread " +Thread.currentThread().getName());
			
			return value1 + value2;
		} finally {
			lock.unlock();
			System.out.println("-- add -- lock is released by Thread " +Thread.currentThread().getName());
		}
	}

	public double subtract(double value1, double value2) {
		try {
			lock.lock();
			System.out.println(" -- sub -- lock is acquired by Thread "+Thread.currentThread().getName());
			
			return value1 - value2;
		} finally {
			lock.unlock();
			System.out.println("-- sub -- lock is released by Thread " +Thread.currentThread().getName());
		}
	}

	public double calculate(String operation, double operand1, double operand2) {
		try {
			lock.lock();
			System.out.println("-- cal-- lock is acquired by Thread : " + Thread.currentThread().getName());

			switch (operation) {
			case "+":
				return add(operand1, operand2);
			case "-":
				return subtract(operand1, operand2);
			default:
				System.out.println("Calculate works only with + and - operators and two values only");
				return 0;
			}

		} finally {
			lock.unlock();
			System.out.println("lock is released by Thread " + Thread.currentThread().getName());
		}
	}
	
	private static void terminateExecutorService(ExecutorService es) throws InterruptedException {
		es.shutdown();
		es.awaitTermination(3, TimeUnit.SECONDS);
		es.shutdownNow();
	}
}