package com.thread.manage.manage9;

/**
 * @author Admin
 * 线程分组及线程组中不可控异常的处理
 */
public class Main {
    public static void main(String[] args) {
        int numberOfThread = 2 * Runtime.getRuntime().availableProcessors();
        ThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for (int i = 0; i < numberOfThread; i++) {
            Thread t = new Thread(threadGroup,task);
            t.start();
        }
        //输出Thread Group的信息
        System.out.printf("Number of Thread: %d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        //输出线程中各线程信息
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s : %s\n",threads[i].getName(),threads[i].getState());
        }
    }
}
