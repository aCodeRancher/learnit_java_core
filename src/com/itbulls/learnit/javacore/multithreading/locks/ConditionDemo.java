package com.itbulls.learnit.javacore.multithreading.locks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
	
	private static final int CAPACITY = 5;
	
	private Deque<String> stack = new LinkedList<>();
	private Lock lock = new ReentrantLock();
	private Condition stackEmptyCondition = lock.newCondition();
	private Condition stackFullCondition = lock.newCondition();

	public static void main(String[] args) {
		var demo = new ConditionDemo();
		var es = Executors.newFixedThreadPool(6);
		Random randomNo = new Random();
		int generatedNo = 0;
		AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0 ; i<10; i++) {
			generatedNo = randomNo.nextInt(10);
			atomicInteger.set(generatedNo);
			es.submit(() -> demo.pushToStack(Integer.toString(atomicInteger.get())));


		}
        for (int i=0;i<8;i++)
		   es.submit(()-> demo.popFromStack());

		es.shutdown();
	}

	public void pushToStack(String item) {
		try {
			lock.lock();
			while (stack.size() == CAPACITY) {
				stackFullCondition.await();
			}
			stack.push(item);
			System.out.println("push : " + item + " stack size: "+ stack.size());
			stackEmptyCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			
		}
	}

	public String popFromStack() {
		try {
			lock.lock();
			while (stack.size() == 0) {
				stackEmptyCondition.await();
			}
			System.out.println("pop out : " + stack.peek());

			stack.pop();
			System.out.println(" full signal all ");
			stackFullCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//stackFullCondition.signalAll();
			System.out.println("pop release lock, current size: "+ stack.size());
			lock.unlock();
		}
		return "current size : " + stack.size();
	}

}
