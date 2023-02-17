package java8.lambda;

import java.util.concurrent.Callable;

public class demo2 {
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
