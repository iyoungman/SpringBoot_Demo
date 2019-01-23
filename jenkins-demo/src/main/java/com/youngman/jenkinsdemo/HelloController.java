package com.youngman.jenkinsdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngman on 2018-12-18.
 */
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
