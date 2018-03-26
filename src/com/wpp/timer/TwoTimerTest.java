package com.wpp.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TwoTimerTest {

    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask{

        @Override
        public void run(){
            System.out.println("TASK 运行时间：" + new Date());
        }
    }

    static public class MyTask2 extends TimerTask{

        @Override
        public void run(){
            System.out.println("TASK 运行时间：" + new Date());

        }
    }

    public static void main(String[] args) {

        try {

            MyTask task = new MyTask();
            MyTask2 task2 = new MyTask2();

            SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dateString  = "2018-02-11 10:49:00";

            String dateString2 = "2018-02-11 10:50:00";

            Date dateRef = sdf.parse(dateString);
            Date dateRef2 = sdf.parse(dateString2);

            System.out.println("字符串时间为："+ dateRef.toLocaleString() +",当前时间：" +new Date());
            System.out.println("字符串时间为："+ dateRef2.toLocaleString() +",当前时间：" +new Date());


            timer.schedule(task,dateRef);
            timer.schedule(task2,dateRef2,2000); //每隔n毫秒 执行一下时间。
        }catch (ParseException e){
            e.printStackTrace();
        }

    }


}
