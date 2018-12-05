package com.youngman.mongodemo.account;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")//collection은 Rdb에서 테이블
@Getter
@Setter
public class Account {

    @Id
    String id;//이름을 어떻게 짓든 db에는 _id로 들어간다.
    String username;
    String email;
}

