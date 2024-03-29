package java8.lambda;

/**
 * @author elliott
 * @date 2023/2/15
 * @Desc
 **/
public class demo6 {
    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("zzz");
            Thread.sleep(100);
        })).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () ->{
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    @FunctionalInterface interface RunnableEx{
        void run() throws Exception;
    }
}
