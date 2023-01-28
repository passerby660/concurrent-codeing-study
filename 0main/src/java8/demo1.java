package java8;

import java.util.concurrent.Callable;

/**
 * 捕获lambda表达式的异常
 */
public class demo1 {
    public static void main(String[] args) {
        Runnable sleeper = () -> {
            System.out.println("zzz");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Callable call = () -> {
            System.out.println("zzz");
            Thread.sleep(1000);
            return null;
        };

    }
}
