package com.youngman.pagingdemo.Embedd;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by youngman on 2019-01-23.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
