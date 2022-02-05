package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Counter implements Runnable {

      int count0, count1;

    @Override
    public void run(){
          increment();
     }

    private void increment() {

          try{
            synchronized (this) {
                while (true) {
                   System.out.println( Thread.currentThread().getName() + " increases " + "count0=" + ++count0 + " count1=" + ++count1);
                   TimeUnit.MILLISECONDS.sleep(10);
                 }
              }
          } catch (InterruptedException e) {
              System.out.println(Thread.currentThread().getName() + " is "+  Thread.currentThread().isInterrupted());
          }
    }


    public static void main (String... args)  {

        Counter counter = new Counter();
        int poolSize = 8;
        ExecutorService es = Executors.newFixedThreadPool(poolSize);
        for (int i=0; i<poolSize;i++) {
            es.submit(counter);
        }
        try {
            es.awaitTermination(3, TimeUnit.SECONDS);
        }
        catch(InterruptedException e){
             System.out.println(Thread.currentThread().isInterrupted());
        }
        finally{
             es.shutdownNow();
        }

    }
}
