package com.thread.manage.manage2;

import java.util.concurrent.TimeUnit;


/**
 * @author Admin
 * 线程中断
 */
public class Main {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            //thread.sleep是以毫秒直接计算，，TimeUnit.SECONDS.sleep可以根据单位进行转换
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断线程
        task.interrupt();
        System.out.printf("Main : Status of the Thread: %s\n",task.getState());
        System.out.printf("Main : isInterrupted %s\n",task.isInterrupted());
        System.out.printf("Main : isAlive %s\n",task.isAlive());
    }
}
