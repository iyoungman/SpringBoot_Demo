package com.youngman.pagingdemo.Embedd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by youngman on 2019-01-23.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void test() {
        User user = userRepository.findByName("이영준");
        System.out.println("Full 주소 : " + user.getAdress().getFullAddress());
    }
}
