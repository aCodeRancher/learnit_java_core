package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Demo4 {

    public static void main (String... args) throws InterruptedException{

        Post post = new Post();
        var es = Executors.newFixedThreadPool(4);
           es.execute(new Reader(post));
           es.execute(new Reader(post));
           es.execute(new Reader(post));
           es.execute(new Writer(post));

           es.awaitTermination(2, TimeUnit.SECONDS);
          es.shutdownNow();

     }
}
