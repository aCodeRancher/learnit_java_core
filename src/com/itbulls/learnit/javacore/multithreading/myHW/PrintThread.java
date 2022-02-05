package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.TimeUnit;

public class PrintThread extends Thread{

    @Override
    public void run(){
        for (int i=0;i<5;i++) {
            try {
                System.out.println("Demo 1: my name is " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted.");
            }
        }
    }

}
