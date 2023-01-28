package com.thread.manage.manage2;

/**
 * @author Admin
 * 线程中断
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrime(number)){
                System.out.printf("Number %d is Prime\n",number);
            }
            //测试线程是否被中断
            if (isInterrupted()){
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
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

}
