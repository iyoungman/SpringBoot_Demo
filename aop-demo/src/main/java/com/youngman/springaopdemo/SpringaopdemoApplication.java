package com.youngman.springaopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringaopdemoApplication {

    public static void main(String[] args) {
        //웹 서버 구동X
        SpringApplication app = new SpringApplication(SpringaopdemoApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

        //웹 서버 구동
//        SpringApplication.run(SpringaopdemoApplication.class, args);
    }

}

