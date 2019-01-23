package com.youngman.springaopdemo.service;

import com.youngman.springaopdemo.PerLogging;
import org.springframework.stereotype.Service;

/**
 * Created by youngman on 2018-12-23.
 * Real Subject
 */
@Service
public class SimpleEventService implements EventService {

    @PerLogging
    @Override
    public void createEvent() {
//        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("create event");
//        System.out.println(System.currentTimeMillis() - begin);
    }

    @PerLogging
    @Override
    public void publishEvnet() {
//        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("publish event");
        deleteEvent();
//        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        System.out.println("delete event");
    }
}
