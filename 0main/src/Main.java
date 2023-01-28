
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
    private static ArrayList<Integer> integers = new ArrayList<Integer>();

    private static ArrayList<Integer> newintegers = new ArrayList<Integer>();
    private Integer number = 0;
    private Integer newNumber = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }

        Main test = new Main();
        Thread producer = new Thread(test.new Producer());
        Thread consumer = new Thread(test.new Consumer());
        producer.start();
        consumer.start();
        for (Integer i : newintegers) {
            System.out.println("处理后的集合" + i);
        }
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (number < integers.size()) {
                try {
                    queue.put(integers.get(number));
                    System.out.println("向队列取中插入一个元素" + integers.get(number) + "===========队列剩余空间：" + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    number++;
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (newNumber < integers.size()) {
                try {
                    Integer take = queue.take();
                    System.out.println("从队列取走一个元素，" + queue.take() + "========队列剩余" + queue.size() + "个元素");
                    newintegers.add(take += 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    newNumber++;
                }
            }
        }
    }

}
