package com.itbulls.learnit.javacore.multithreading.myHW;

import java.io.IOException;
import java.io.InputStream;


public class Demo2 {

    public static void main(String... args) throws InterruptedException {

        int[] intervals = {2000, 3000, 5000, 4000, 4000};
        String[] messages = {"hello", "good morning", "nice", "see you", "talk to you later"};
        Spam spam = new Spam(intervals, messages);
        Thread spamThread = new Thread(spam);
        Interrupter inputRunnable = new Interrupter(spamThread);
        Thread inputThread = new Thread(inputRunnable);

        inputThread.setDaemon(true);
        inputThread.start();
        spamThread.start();
     }
}


class Interrupter implements Runnable {

    Thread t;

    Interrupter(Thread t) {
        this.t = t;

    }

    @Override
    public void run() {
        InputStream inputStream = System.in;
        while(true){
                 try{
                       if (System.in.available() > 0 && System.in.read() == '\n') {
                           System.setIn(inputStream);
                           System.out.println("about to interrupt another thread");
                           t.interrupt();
                      }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
        }
    }
}

class Spam implements Runnable{
    int size = 5;
    int [] intervals  ;
    String[] messages ;

    Spam (int[] intervals, String[] messages){
             this.intervals= intervals;
             this.messages = messages;
    }

    public void run(){
        while (true) {
            for (int i = 0; i < size; i++)
                try{
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread interrupted : " + Thread.currentThread().isInterrupted());
                    } else {
                             System.out.println("Message " + i + " " + messages[i]);
                             Thread.sleep(intervals[0]);
                         }
                }
               catch (InterruptedException e){
                    System.out.println(Thread.currentThread().getName() + " is interrupted");
                }
        }
    }
}


