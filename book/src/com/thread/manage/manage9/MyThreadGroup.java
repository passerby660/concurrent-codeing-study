package com.thread.manage.manage9;

/**
 * @author Admin
 * 线程分组及线程组中不可控异常的处理
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("The thread %s has thrown an Exception\n" , t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
}
