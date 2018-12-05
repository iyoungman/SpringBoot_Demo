package com.youngman.mongodemo.repository;

import com.youngman.mongodemo.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
