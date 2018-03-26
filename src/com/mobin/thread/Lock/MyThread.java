package com.mobin.thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public  class MyThread  extends  Thread{

    private MyService myService;

    public MyThread(MyService myService){
        super();
        this.myService = myService;
    }

    @Override
    public void run() {

        myService.testMethod();
    }


}