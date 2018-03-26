package com.mobin.thread.Lock;

import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public  class MyService {

    Lock lock = new ReentrantLock();

    public  void testMethod() {

        lock.lock();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("threadName :"+ Thread.currentThread().getName() + ",thread " +(i+1) );
            }
            // lock.unlock();//释放锁（如果上面的代码在unlock之前出错，那么锁将不会被释放，所以最好放到finally中）
        }finally {
            lock.unlock();//释放锁
        }


    }
}