package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.TimeUnit;

public class PrintDemo {

    public void execute(){
        for (int i=0;i<5;i++) {
            try {
                System.out.println("Demo 3: my name is " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted.");
            }
        }
    }

    public static void execute1(){
        for (int i=0;i<5;i++) {
            try {
                System.out.println("Demo 4: my name is " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted.");
            }
        }
    }
}
