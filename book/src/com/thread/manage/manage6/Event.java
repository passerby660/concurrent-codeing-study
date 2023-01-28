package com.thread.manage.manage6;

import java.util.Date;

/**
 * @author Admin
 * 这个类用来存储事件信息
 */
public class Event {
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

//    public Event(){}
//
//    public Event(Date date, String event) {
//        this.date = date;
//        this.event = event;
//    }
}
