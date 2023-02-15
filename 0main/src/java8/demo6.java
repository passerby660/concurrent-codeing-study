package java8;

/**
 * @author elliott
 * @date 2023/2/15
 * @Desc
 **/
public class demo6 {
    public static void main(String[] args) {
        Runnable andThen = andThen(() -> System.out.println("runnable1"), () -> System.out.println("runnable2"));
        andThen.run();
    }

    private static Runnable andThen(Runnable runnable1, Runnable runnable2) {
        return () -> {
            runnable1.run();
            runnable2.run();
        };
    }
}
