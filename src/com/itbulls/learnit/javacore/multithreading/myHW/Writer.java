package com.itbulls.learnit.javacore.multithreading.myHW;

import org.apache.commons.lang3.RandomStringUtils;


public class Writer implements Runnable{

    private Post post;
    private boolean stop=false;
    private int writeTimes = 0;
    public Writer(Post m) {
        this.post = m;
    }

    @Override
    public void run() {
          while (!post.getDeleteFlag()) {
              synchronized (post) {
                  if (post.getReadCount() == 0 && post.getPost().length()==0) {
                      post.setPost(generateString());
                      System.out.println("Writer writes " + post.getPost());
                      writeTimes++;
                      post.notifyAll();
                  }
                  else {
                       if (post.getReadCount() == 3) {
                          post.setPost("");
                          post.resetReadCount();
                          post.setPost(generateString());
                          System.out.println("Writer writes " + post.getPost());
                          writeTimes++;
                          post.notifyAll();
                      }
                  }

                  if (writeTimes==3){
                      post.setDeleteFlag(true);
                  }
              }
          }

     }

    private String generateString(){
        return RandomStringUtils.randomAlphabetic(5);
     }
}
