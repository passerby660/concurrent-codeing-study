package com.thread.manage.manage10;

import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 * 使用工厂创建线程
 */
public class Task implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
