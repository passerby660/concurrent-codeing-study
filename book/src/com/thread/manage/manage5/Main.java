package com.thread.manage.manage5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Admin
 * 线程等待
 */
public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DataSourcesLoader());
        Thread thread2 = new Thread(new NetworkConnectionsLoader());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Configuration has been load: %s\n" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
