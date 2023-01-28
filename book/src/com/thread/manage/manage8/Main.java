package com.thread.manage.manage8;

import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        //错误的示例
//        UnsafeTask unsafeTask = new UnsafeTask();
        SafeTask safeTask = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(safeTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
