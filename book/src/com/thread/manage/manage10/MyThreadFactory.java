package com.thread.manage.manage10;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @author Admin
 * 使用工厂创建线程
 */
public class MyThreadFactory implements ThreadFactory {
    private int counter;
    private String name;
    private List<String> stats;

    public MyThreadFactory(String name) {
        this.name = name;
        this.counter = 0;
        stats = new ArrayList<String>();
    }

    @Override
    public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, name + "-Thread_"+counter);
        counter++;
        stats.add(String.format("Created thread1 %d with name %s on %s\n",thread.getId(),thread.getName(),new Date()));
        return thread;
    }

    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> iterator = stats.iterator();
        while (iterator.hasNext()){
            buffer.append(iterator.next());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
