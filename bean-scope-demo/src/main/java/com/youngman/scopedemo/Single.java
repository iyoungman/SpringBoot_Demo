package com.youngman.scopedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

    @Autowired
    private Proto proto;//프록시 빈이 주입된다.

    public Proto getProto() {
        return proto;
    }
}
