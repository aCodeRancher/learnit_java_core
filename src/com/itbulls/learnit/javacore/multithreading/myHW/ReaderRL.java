package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderRL {
    private Lock readLock;

    private Post post;


    public ReaderRL(ReentrantReadWriteLock lock, Post post){
        readLock = lock.readLock();
        this.post = post;
    }

    public void read(){
         while(!post.getDeleteFlag()) {
             try {
                 readLock.lock();
                 post.addReadCount();
                 System.out.println(Thread.currentThread().getName() + " reads : " + post.getPost() + " " +
                         "read count: " + post.getReadCount());

             } finally {
                 readLock.unlock();
             }
         }

    }
}
