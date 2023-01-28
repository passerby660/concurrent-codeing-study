package com.thread.manage.manage7;

/**
 * @author Admin
 * 调用线程任务并引发异常
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
