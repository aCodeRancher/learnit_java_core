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
             //The message has not been visited by this reader and
             //it has not visited by all three readers, then read it.
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
             //if the message has already been visited by all three reader, then don't read it
             if (post.getReadCount()==3){
                 visit=0;
             }
         }
    }
}
