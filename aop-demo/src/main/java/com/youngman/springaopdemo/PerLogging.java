package com.youngman.springaopdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by youngman on 2018-12-23.
 * 어노테이션으로 만든다
 * 어노테이션 설명
 */

@Retention(RetentionPolicy.CLASS)//어노테이션 정보를 얼마나 유지할 것인지
public @interface PerLogging {
}
