package com.wpp.timer;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask{

        @Override
        public void run(){
            System.out.println("TASK 运行时间：" + new Date());

        }
    }

    public static void main(String[] args) {

        try {

            MyTask task = new MyTask();

            SimpleDateFormat sdf  =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dateString = "2018-02-11 10:48:00";

            Date dateRef = sdf.parse(dateString);

            System.out.println("字符串时间为："+ dateRef.toLocaleString());


            timer.schedule(task,dateRef);
        }catch (ParseException e){
            e.printStackTrace();
        }

    }


}
