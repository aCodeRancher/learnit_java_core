package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo4RL {

    public static void main(String... args){

        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        Post post = new Post();
        var es=  Executors.newFixedThreadPool(4);

        WriterRL writer = new WriterRL(reentrantReadWriteLock, post);
        ReaderRL reader0 = new ReaderRL(reentrantReadWriteLock,post);
        ReaderRL reader1 = new ReaderRL(reentrantReadWriteLock,post);
        ReaderRL reader2 = new ReaderRL(reentrantReadWriteLock,post);
        es.submit(() -> writer.write());

        es.submit(() -> reader0.read());
        es.submit(() -> reader1.read());
        es.submit(() -> reader2.read());

        try {
            es.awaitTermination(2, TimeUnit.SECONDS);
        }
        catch(InterruptedException e){
             e.printStackTrace();
        }
        finally{
            es.shutdown();
        }
    }
}
