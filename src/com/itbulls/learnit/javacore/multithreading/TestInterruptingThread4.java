package com.itbulls.learnit.javacore.multithreading;

public class TestInterruptingThread4 extends Thread{

    public void run(){
        for (int i =1 ; i<=2;i++){
            if (Thread.interrupted()){
                System.out.println(Thread.currentThread().getName() + "is interrupted.");
            }
            else{
                System.out.println(Thread.currentThread().getName() + " is working normally.");
            }
        }
    }

    public static void main(String args[]){
        TestInterruptingThread4 t1 = new TestInterruptingThread4();
        TestInterruptingThread4 t2 = new TestInterruptingThread4();
        t1.start();
        t1.interrupt();
        t2.start();
    }
}
