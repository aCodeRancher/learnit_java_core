package com.itbulls.learnit.javacore.multithreading.myHW;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriterRL {

    private Lock writeLock;

    private Post post;

    private int writeTimes;

    public WriterRL(ReentrantReadWriteLock lock, Post post){
            writeLock = lock.writeLock();
            this.post = post;
    }

    public void write(){
       while (!post.getDeleteFlag()) {
           try {
               writeLock.lock();

               if (post.getReadCount() == 0 && post.getPost().length() == 0) {
                   post.setPost(generateString());
                   System.out.println("Writer writes " + post.getPost());
               } else {
                   if (post.getReadCount() == 3) {
                       post.setPost("");
                       post.resetReadCount();
                       post.setPost(generateString());
                       System.out.println("Writer writes " + post.getPost());
                       writeTimes++;
                   }
               }
               //after writer writes 3 times, delete the post
               //once the post's delete flag is set to true, each reader will stop
               if (writeTimes == 3) {
                   post.setDeleteFlag(true);
               }

           } finally {
               writeLock.unlock();
           }
       }
    }

    private String generateString(){
        return RandomStringUtils.randomAlphabetic(5);
    }
}
