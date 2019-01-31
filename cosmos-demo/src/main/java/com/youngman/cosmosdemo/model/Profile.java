package com.youngman.cosmosdemo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by youngman on 2019-01-29.
 */
@Getter
@Setter
@Entity
@ToString(exclude = "receiver")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private boolean current;

    /*
     * @JoinColumn : Join 컬럼명을 원하는대로 생성
     * 안하면 자동 mapping
     * 프로필에 회원정보 입력
     * p137 - 단방향
     */
    @ManyToOne
    private Receiver receiver;

    public Profile() {
    }

    @Builder
    public Profile(String fileName, boolean current, Receiver receiver) {
        this.fileName = fileName;
        this.current = current;
        this.receiver = receiver;
    }


    public String printToProfile() {
        return "Profile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", current=" + current +
                ", receiver-lastname=" + receiver.getName().getLastName() +
                ", receiver-firstname=" + receiver.getName().getFirstName() +
                ", receiver-adress-ciry=" + receiver.getAddress().getCity() +
                ", receiver-adress-groop=" + receiver.getAddress().getGroop() +
                ", receiver-adress-dong=" + receiver.getAddress().getDong() +
                '}';
    }
}
