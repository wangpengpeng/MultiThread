package com.mobin.thread.Lock;


/**
 * Created by Mobin on 2016/3/20.
 */
public class LockTest01 {



    public static void main(String[] args) {

        MyService myService = new MyService();

        MyThread myThread1 = new MyThread(myService);
        MyThread myThread2 = new MyThread(myService);
        MyThread myThread3 = new MyThread(myService);

        myThread1.start();
        myThread2.start();
        myThread3.start();

    }
}
