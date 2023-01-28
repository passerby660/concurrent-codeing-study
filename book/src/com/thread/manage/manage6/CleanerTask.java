package com.thread.manage.manage6;

import java.util.Date;
import java.util.Deque;

/**
 * @author elliott
 * 守护线程,用于清理队列中超过10s的事件
 */
public class CleanerTask extends Thread {

    /**
     * 申明一个存储事件的队列,并在类构造器中完成初始化
     */
    private Deque<Event> deque;
    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run(){
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    /**
     * @param date
     * 获取队列中的组后一个时间吗,如果该事件创建时间超过十秒则删除它
     * 并输出该事件的信息
     */
    private void clean(Date date) {
        long difference;
        boolean delete;
        if (deque.size() == 0){
            return;
        }
        delete = false;
        do {
            Event e = deque.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000){
                System.out.printf("Cleaner: %s\n",e.getEvent());
                deque.removeLast();
                delete = true;
            }
        }while (difference > 10000);
        if (delete){
            System.out.printf("Cleaner: Size of the queue: %d\n",deque.size());
        }
    }

}
