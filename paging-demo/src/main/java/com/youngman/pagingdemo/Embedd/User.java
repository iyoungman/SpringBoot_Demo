package com.youngman.pagingdemo.Embedd;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by youngman on 2019-01-23.
 */
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /*
     * jpa 에서 엔터티 내에 참조 클래스의 필드를 그대로 자신으로 컬럼으로 만들고 싶다면 혹은
     * 배송 관련 서비스에서 발송인(Sender), 수취인(Receiver)가 있을 경우 중복적으로 주소에 관련 칼럼들이 요구 됩니다.
     * 이러한 중복적인 칼럼들을 자료형으로 규합해서 훨씬더 객체지향적으로 풀어 나갈 수 있을 거같습니다.
     * @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "user_city")),
            @AttributeOverride(name = "street", column = @Column(name = "user_street")),
            @AttributeOverride(name = "zip_code", column = @Column(name = "user_zip_code"))
        })
     */
    @Embedded
    private Adress adress;
}
