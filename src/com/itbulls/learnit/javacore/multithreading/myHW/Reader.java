package com.itbulls.learnit.javacore.multithreading.myHW;

public class Reader implements Runnable {

    private Post post;
    private boolean stop = false;

    public Reader(Post post) {
        this.post = post;
    }

    @Override
    public void run() {
           while (!post.getDeleteFlag()) {
               synchronized (post) {
                   try {
                       post.wait();

                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   post.addReadCount();
                   System.out.println(Thread.currentThread().getName() + " reads : " + post.getPost() + " " +
                           "read count: " + post.getReadCount());
                   }
           }
    }


}
