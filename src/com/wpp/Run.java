package com.wpp;

import java.util.Hashtable;
import java.util.Vector;

public class Run {

    public static void main(String[] args) {
        MyValidThread myThread = new MyValidThread();
//        MyThread myThread = new MyThread();
        myThread.setPriority(1);

        Thread A = new Thread(myThread,"A");
        Thread B = new Thread(myThread,"B");
        Thread C = new Thread(myThread,"C");
        Thread E = new Thread(myThread,"E");
        Thread D = new Thread(myThread,"D");


        B.start();
        A.start();
        D.start();
        C.start();
        E.start();


        MyThread myThread2 = new MyThread();
        myThread2.setName("wppmain");
        myThread2.start();
        // main线程，不一定最后出现
        System.out.println(Thread.currentThread().getName() + ",id ===" +Thread.currentThread().getId());


        //开启n个线程
//        MyThread[] myThreadArr = new MyThread[3];
//        for(int i=0;i<3;i++){
//
//            myThreadArr[i].setName("th" + i);
//            myThreadArr[i].start();
//        }

        Runnable runnable = new Runnable() {

            public void run() {
                System.out.println("运行接口....");
            }
        };

        runnable.run();


        Vector vector = new Vector<String>(100);
        System.out.println("capacity=========="+ vector.capacity());

        Vector vector2 = new Vector<String>();
        System.out.println("capacity2=========="+ vector2.capacity());


        Hashtable hashtable1 = new Hashtable<String,String>();
        System.out.println("hashtable1.capacity=========="+ hashtable1.size());

        Thread.
        try {
            Thread.sleep(10000000);

        }catch (Exception e){
            System.out.println("Exception_message: " +e.getMessage() );
        }
    }
}
