package com.wpp;

public class MyValidThread extends  Thread{

    private volatile  int count = 5;

    @Override
     public void run(){ //不会共享变量
//    synchronized  public void run(){  //可以顺序执行

        super.run();
        count--;
        System.out.println("当前线程的名字："+ this.currentThread().getName() +"计数值：" + count);
    }



}
