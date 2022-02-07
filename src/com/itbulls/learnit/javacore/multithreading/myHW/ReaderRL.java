package com.itbulls.learnit.javacore.multithreading.myHW;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderRL {
    private Lock readLock;

    private Post post;

   private int visit= 0;

    public ReaderRL(ReentrantReadWriteLock lock, Post post){
        readLock = lock.readLock();
        this.post = post;
    }

    public void read(){
         while(!post.getDeleteFlag()) {
             if (visit==0 && post.getReadCount()<3) {
                 try {

                     readLock.lock();
                     post.addReadCount();
                     System.out.println(Thread.currentThread().getName() + " reads : " + post.getPost() + " " +
                             "read count: " + post.getReadCount());
                     visit++;
                  } finally {
                     readLock.unlock();
                 }
             }
             if (post.getReadCount()==3){
                 visit=0;
             }
         }
    }
}
