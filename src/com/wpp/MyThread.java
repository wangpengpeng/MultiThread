package com.wpp;

import com.mobin.thread.ForkAndJoin.CountTask;

public class MyThread  extends  Thread{

    private int count = 5;

    @Override
    public void run(){
        super.run();
        count--;
        System.out.println("当前线程的名字："+ this.currentThread().getName() +"计数值：" + count);

        System.out.println("当前线程的名字："+ this.currentThread().getName() +",isalive " + this.isAlive());

        System.out.println("当前线程的名字："+ this.currentThread().getName() +",getid======= " + this.getId());
    }
}
//
//当前线程的名字：B计数值：4
//        当前线程的名字：B,isalive false
//        当前线程的名字：A计数值：2
//        当前线程的名字：C计数值：2
//        当前线程的名字：A,isalive false
//        当前线程的名字：C,isalive false
//        当前线程的名字：D计数值：1
//        当前线程的名字：D,isalive false
//        main
//        当前线程的名字：E计数值：0
//        当前线程的名字：E,isalive false
