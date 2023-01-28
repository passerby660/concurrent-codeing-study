package com.thread.manage.manage4;

import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 * 线程的休眠与唤醒
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new ConsoleClock());
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
