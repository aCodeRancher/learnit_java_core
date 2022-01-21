package com.itbulls.learnit.javacore.multithreading;

public class JavaYieldExp extends Thread{

    public void run(){
        for (int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }

    public static void main (String[] args){
        JavaYieldExp t1 = new JavaYieldExp();
        JavaYieldExp t2 = new JavaYieldExp();

        t1.start();
        t2.start();
        for (int i=0;i<3;i++){

            t2.yield();
            t1.yield();
            System.out.println(Thread.currentThread().getName() + " in control");
        }

    }
}
