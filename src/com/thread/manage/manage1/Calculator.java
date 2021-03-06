package com.thread.manage.manage1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author elliott
 * 线程优先级
 */
public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;
        System.out.printf("Thread '%s': START\n",Thread.currentThread().getName());

        while (current <= max){
            if (isPrime(current)){
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': END.Number of Primes: %d\n",Thread.currentThread().getName(),numPrimes);
    }

    private boolean isPrime(long number) {
        if (number <= 2){
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s\n",Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximum Priority: %s\n",Thread.MAX_PRIORITY);

        Thread[] threads;
        Thread.State[] states;
        threads = new Thread[10];
        states = new Thread.State[10];
        AtomicInteger num = new AtomicInteger();
        num.set(10);
        for (int i = 0; i < num.get(); i++) {
            threads[i] = new Thread(new Calculator());
            if ((i % 2) == 0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("My Thread " + i);
        }

        AtomicInteger integer = new AtomicInteger();
        integer.set(0);
        try(FileWriter file = new FileWriter("D:\\Git\\concurrent-codeing-study\\out\\log.txt");PrintWriter pw = new PrintWriter(file)){
            for (int i = 0; i < num.get(); i++) {
                pw.println("Main : Status of Thread "+ i +" : " +threads[i].getState());
                states[i] = threads[i].getState();
            }
            for (int i = 0; i < num.get(); i++) {
                threads[i].start();
            }
            boolean finish = false;
            while (!finish){
                for (int i = 0; i < num.get(); i++) {
                    if (threads[i].getState() != states[i]){
                        writeThreadInfo(pw,threads[i],states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < num.get(); i++) {
                    System.out.println("------------------------------------------------------------------------------------");
                    System.out.println("threads[i].getState(): "+threads[i].getState()+" -- i : "+i+" --integer : "+integer.get()+" --判断"+String.valueOf(finish && (threads[i].getState() == Thread.State.TERMINATED)));
                    System.out.println("finish: "+String.valueOf(finish)+"-----threads[i].getState(): "+String.valueOf(threads[i].getState())+"-----判断结果: "+String.valueOf(finish && (threads[i].getState() == Thread.State.TERMINATED)));
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                    System.out.println("判断结果: " + String.valueOf(finish));
                    integer.set(integer.get()+1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(),thread.getName());
        pw.printf("Main : Priority: %d\n",thread.getPriority());
        pw.printf("Main : Old State: %s\n",state);
        pw.printf("Main : New State: %s\n",thread.getState());
        pw.printf("Main : ************************************************\n");
    }
}
