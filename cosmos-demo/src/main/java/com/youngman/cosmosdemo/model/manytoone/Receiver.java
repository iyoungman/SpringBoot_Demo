package com.youngman.cosmosdemo.model.manytoone;

import com.youngman.cosmosdemo.model.embedded.Address;
import com.youngman.cosmosdemo.model.embedded.Name;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-01-29.
 */

@Getter
@Setter
@Entity
@ToString
public class Receiver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Name name;

    /*
     * 중복적인 칼럼들을 자료형으로 규합 -> 객체지향
     * 참조 클래스의 필드를 그대로 자신으로 컬럼으로 만들고 싶을 때
     * @Embedded 값 타입을 사용한다고 명시
     * @AttributeOverrides : Embedded 타입 Mapping 정보 재정의
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "receiver_city")),
            @AttributeOverride(name = "groop", column = @Column(name = "receiver_groop")),
            @AttributeOverride(name = "dong", column = @Column(name = "receiver_dong"))
    })
    private Address address;

    public Receiver() {
    }

    @Builder
    public Receiver(Name name, Address address) {
        this.name = name;
        this.address = address;
    }
}
