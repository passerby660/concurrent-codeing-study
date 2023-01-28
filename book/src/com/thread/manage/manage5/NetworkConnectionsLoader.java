package com.thread.manage.manage5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Admin
 */
public class NetworkConnectionsLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Beginning NetworkConnections loading: %s\n" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("NetworkConnections loading has finished: %s\n" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
