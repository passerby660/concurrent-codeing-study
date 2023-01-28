package com.thread.manage.manage9;

import java.util.Random;

/**
 * @author Admin
 * 线程分组及线程组中不可控异常的处理
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            System.out.println(random.nextInt(100000));
            result = (int) (1000/random.nextInt(100000));
            if (Thread.currentThread().isInterrupted()) {
                // %d是表示替换整数,%f表示替换小数
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}
