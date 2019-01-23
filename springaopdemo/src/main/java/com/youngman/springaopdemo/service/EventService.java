package com.youngman.springaopdemo.service;

import org.springframework.stereotype.Service;

/**
 * Created by youngman on 2018-12-23.
 * Subject
 */
@Service
public interface EventService {
    //AOP기능을 적용할 메소드1
    void createEvent();

    //AOP기능을 적용할 메소드2
    void publishEvnet();

    //AOP기능을 적용하지 않을 메소드
    void deleteEvent();
}

