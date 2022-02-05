package com.itbulls.learnit.javacore.multithreading.myHW;

public class Demo1 {

    public static void main (String... args) throws InterruptedException{
        PrintRunnable task = new PrintRunnable();
        Thread t = new Thread(task);
        t.start();
        t.join();

        PrintThread t1 = new PrintThread();
        t1.start();
        t1.join();

        PrintDemo demo = new PrintDemo();
        Thread t2 = new Thread(()->demo.execute());
        t2.start();
        t2.join();

        Thread t3 = new Thread(PrintDemo::execute1);
        t3.start();
        t3.join();
    }

}

