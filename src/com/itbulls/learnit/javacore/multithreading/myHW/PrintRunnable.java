package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.TimeUnit;

public class PrintRunnable implements Runnable{


    @Override
    public void run(){
         for (int i=0;i<5;i++) {
             try {
                 System.out.println("Demo 2: my name is " + Thread.currentThread().getName());
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 System.out.println(Thread.currentThread().getName() + " is interrupted.");
             }
         }
    }
}
