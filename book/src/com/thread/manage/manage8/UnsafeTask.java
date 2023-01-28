package com.thread.manage.manage8;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 * 使用线程本地变量-引发错误
 */
public class UnsafeTask implements Runnable {

    private Date startDate;

    @Override
    public void run() {
        //同一个线程引用同一个变量输出的时间不一致
        startDate = new Date();
        System.out.printf("Starting Thread : %s : %s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished:%s : %s\n",Thread.currentThread().getId(),startDate);
    }
}
