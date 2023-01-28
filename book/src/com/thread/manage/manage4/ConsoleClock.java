package com.thread.manage.manage4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 * 线程的休眠与唤醒
 */
public class ConsoleClock implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s \n" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interrupted");
            }
        }
    }
}
