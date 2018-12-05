package com.youngman.mongodemo;

import com.youngman.mongodemo.account.Account;
import com.youngman.mongodemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoRunner implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;

    //스프링 어플리케이션 실행시 구동되는 메소드
    @Override
    public void run(ApplicationArguments args) throws Exception {
        accountRepository.deleteAll();

        Account account = new Account();
        account.setEmail("testUserEmail");
        account.setUsername("testUserName");

        accountRepository.insert(account);


    }
}
