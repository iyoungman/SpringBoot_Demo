package com.youngman.scopedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScepoedemoRunner implements ApplicationRunner {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*
         * 프로토타입 스코프'
         * 사용시마다 다른 인스턴스
         */
        System.out.println("proto");
        System.out.println(applicationContext.getBean(Proto.class));
        System.out.println(applicationContext.getBean(Proto.class));

        /*
         * 싱글톤 스코프
         * 사용시마다 같은 인스턴스
         */
        System.out.println("single");
        System.out.println(applicationContext.getBean(Single.class));
        System.out.println(applicationContext.getBean(Single.class));

        /*
         * 프록시 패턴을 쓰지 않는다면 Single Class 에 의해서 같은 주소가 찍힌다
         */
        System.out.println("proto by single");
        System.out.println(applicationContext.getBean(Single.class).getProto());
        System.out.println(applicationContext.getBean(Single.class).getProto());
    }
}
