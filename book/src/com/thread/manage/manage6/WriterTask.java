package com.thread.manage.manage6;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @author elliott
 * 用户线程,用于向队列写入事件
 */
public class WriterTask implements Runnable {

    /**
     * 申明一个存储事件的队列,并在类构造器中完成初始化
     */
    private Deque<Event> deque;
    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    /**
     * 创建一百个事件并将其存储到队列中
     */
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an %d event", Thread.currentThread().getId(),i));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
