package com.thread.manage.manage3;

import java.util.concurrent.TimeUnit;

/**
 * @author elliott
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new FileSearch("C:", "动力环境模型设计.docx"));
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
