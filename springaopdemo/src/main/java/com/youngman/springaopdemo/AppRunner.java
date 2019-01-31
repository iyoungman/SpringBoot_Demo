package com.youngman.springaopdemo;

import com.youngman.springaopdemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by youngman on 2018-12-23.
 */
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    EventService eventService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent();
        eventService.publishEvnet();
        eventService.deleteEvent();
    }
}
