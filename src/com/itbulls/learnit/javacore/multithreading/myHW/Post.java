package com.itbulls.learnit.javacore.multithreading.myHW;

public class Post {

    private String message;

    private int readCount;

    private boolean deleteFlag;

    public Post(){
          message="";
    }

    public void setPost(String message){
        this.message=message;
    }


    public String  getPost(){
        return message;
    }

    public void addReadCount(){
        readCount++;

    }
    public void resetReadCount(){
        readCount = 0;
    }
    public int getReadCount(){
        return readCount;
    }

    public void setDeleteFlag(boolean flag){
         deleteFlag = flag;
    }

    public boolean getDeleteFlag(){
        return deleteFlag;
    }
}
