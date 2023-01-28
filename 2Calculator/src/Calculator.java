/**
 * 计算2000以内的奇数
 */
public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 2000L;
        long numPrimes = 0L;

        System.out.println("线程启动: " + Thread.currentThread().getName());
        while (current<= max){
            if (isPrime(current)){
                numPrimes ++ ;
            }
            current++;
        }
        System.out.println(Thread.currentThread().getName() + "线程结束,奇数总和为:" + numPrimes);
    }

    private boolean isPrime(long current) {
        return false;
    }
}
