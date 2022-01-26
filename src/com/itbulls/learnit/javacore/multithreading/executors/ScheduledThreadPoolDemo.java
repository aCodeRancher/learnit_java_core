package com.itbulls.learnit.javacore.multithreading.executors;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {

	public static void main(String[] args) {
		var es = Executors.newScheduledThreadPool(4);
		es.schedule(() -> System.out.println("Schedule example 1 : " +
							Thread.currentThread().getName() + System.currentTimeMillis()), 1, TimeUnit.SECONDS);
		es.schedule(() -> System.out.println("Schedule example 2: " +
				Thread.currentThread().getName()+ System.currentTimeMillis() ), 1, TimeUnit.SECONDS);
		es.schedule(() -> System.out.println("Schedule example 3 : " +
				Thread.currentThread().getName()+  System.currentTimeMillis()), 1, TimeUnit.SECONDS);
		es.schedule(() -> System.out.println("Schedule example 4: " +
				Thread.currentThread().getName()+ System.currentTimeMillis()), 1, TimeUnit.SECONDS);
		es.schedule(() -> System.out.println("Schedule example 5: " +
				Thread.currentThread().getName()+ System.currentTimeMillis()), 1, TimeUnit.SECONDS);
		es.shutdown();
		
		
	}
	
}
