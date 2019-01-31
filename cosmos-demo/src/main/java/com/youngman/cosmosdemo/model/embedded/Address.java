package com.youngman.cosmosdemo.model.embedded;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by youngman on 2019-01-29.
 * @Embeddable 값 타입을 사용한다고 명시
 */
@Embeddable
@Getter
@Setter
@ToString
public class Address {
    @Column(name = "city")
    private String city;//서울시

    @Column(name = "groop")
    private String groop;//노원구

    @Column(name = "dong")
    private String dong;//중계동

    public Address() {
    }

    @Builder
    public Address(String city, String groop, String dong) {
        this.city = city;
        this.groop = groop;
        this.dong = dong;
    }

    /*
     * 클래스로 정의함으로써 효과
     * 해당 모델에 맞는 다양한 함수 정의 용이
     */
    public String getFullAddress() {
        return this.city + this.groop + this.dong;
    }
}
