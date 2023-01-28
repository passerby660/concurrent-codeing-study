package com.thread.manage.manage10;

/**
 * @author Admin
 * 使用工厂创建线程
 *      如果一个类的创建很复杂并且使用的地方很多，则适合使用工厂模式，
 *  创建一个工厂，由工厂来创建具体的实例，当使用的时候直接调用工厂就好了
 *  如果按照传统方法来创建10个线程则需要new10个thread，如果使用工厂模式
 *  就相当于把new thread封装成一个方法，通过调用方法来调用new thread
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();
        Thread thread;
        System.out.printf("Starting the Thread\n");
        for (int i = 0; i < 10; i++) {
            thread = myThreadFactory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n",myThreadFactory.getStats());
    }
}
