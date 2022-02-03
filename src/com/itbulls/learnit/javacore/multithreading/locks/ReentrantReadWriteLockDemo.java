package com.itbulls.learnit.javacore.multithreading.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDemo {


    public static void main (String... args){
      var es=  Executors.newFixedThreadPool(2);
      ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
      es.submit(() -> demo.put("k" ,"v") );
      es.submit(() -> System.out.println(demo.get("k")));
      es.shutdown();
    }

	private Map<String, String> syncHashMap = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();

    public void put(String key, String value) {
        try {
            writeLock.lock();
            TimeUnit.SECONDS.sleep(10);
            syncHashMap.put(key, value);
        }
        catch(InterruptedException e) {}
        finally {
            writeLock.unlock();
        }
    }

    public String remove(String key){
        try {
            writeLock.lock();
            return syncHashMap.remove(key);
        } finally {
            writeLock.unlock();
        }
    }
    
    public String get(String key){
        try {
            readLock.lock();
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public boolean containsKey(String key) {
        try {
            readLock.lock();
            return syncHashMap.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

}
