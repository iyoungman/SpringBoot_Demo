package com.youngman.springaopdemo;

import com.youngman.springaopdemo.service.EventService;
import com.youngman.springaopdemo.service.SimpleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary//같은 타입의 빈이 여러개 있을 때 그중 하나를 선택하는 방법
@Service
public class ProxySimpleEventService implements EventService {

    //프록시는 Real Subject 빈을 주입받아 사용한다
    @Autowired
    SimpleEventService simpleEventService;

    @Override
    public void createEvent() {
        long begin = System.currentTimeMillis();//부가적인 기능을 정의
        simpleEventService.createEvent();//프록시에서는 델리게이션(위임)을 한다
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvnet() {
        long begin = System.currentTimeMillis();
        simpleEventService.publishEvnet();
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
       simpleEventService.deleteEvent();
    }
}
