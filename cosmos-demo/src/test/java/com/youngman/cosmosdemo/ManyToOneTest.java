package com.youngman.cosmosdemo;

import com.youngman.cosmosdemo.model.manytoone.Profile;
import com.youngman.cosmosdemo.model.manytoone.Receiver;
import com.youngman.cosmosdemo.model.manytoone.Sender;
import com.youngman.cosmosdemo.model.embedded.Address;
import com.youngman.cosmosdemo.model.embedded.Name;
import com.youngman.cosmosdemo.repository.ProfileRepository;
import com.youngman.cosmosdemo.repository.ReceiverRepository;
import com.youngman.cosmosdemo.repository.SenderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by YoungMan on 2019-01-29.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyToOneTest {
    private Logger logger = LoggerFactory.getLogger(ManyToOneTest.class);

    @Autowired
    private ReceiverRepository receiverRepository;

    @Autowired
    private SenderRepository senderRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Test
    public void saveReceiver() {
        Name name = Name.builder()
                .lastName("이")
                .firstName("영준")
                .build();
        Address address = Address.builder()
                .city("서울")
                .groop("노원구")
                .dong("중계동")
                .build();

        receiverRepository.save(Receiver.builder()
                .name(name)
                .address(address)
                .build());
    }

    @Test
    public void saveSender() {
        Name name = Name.builder()
                .lastName("박")
                .firstName("춘소")
                .build();
        Address address = Address.builder()
                .city("경기도")
                .groop("양평읍")
                .dong("용문동")
                .build();

        senderRepository.save(Sender.builder()
                .name(name)
                .address(address)
                .build());
    }

    @Test
    public void findIdByName() {
        Name name = Name.builder()
                .lastName("이")
                .firstName("영준")
                .build();

        Long id = receiverRepository.findIdByName(name);
        logger.info("================이름으로 기본키 찾기=================== : " + id.toString());
    }

    @Test
    public void saveProfile() {
       /* Name name = Name.builder()
                .firstName("영준")
                .lastName("리")
                .build();

        Receiver receiver = Receiver.builder()
                .address(null)
                .name(name)
                .build();*/
        Receiver receiver = new Receiver();
        receiver.setId(1L);

        Profile profile = Profile.builder()
                .current(true)
                .receiver(receiver)
                .build();

        profileRepository.save(profile);
    }

    @Test
    public void getProfile() {
        Profile profile = profileRepository.findProfileById(1L);
        logger.info("================프로필 출력===================");
        logger.info(profile.printToProfile());
    }

    /*
     * p156 - 단방향인데 회원 정보를 조회하면서 그 회원의 프로필 정보 어떻게 볼까?
     */
    @Test
    public void getReceiverWithProfileCount() {
        Name name = Name.builder()
                .lastName("박")
                .firstName("영준")
                .build();

        List<Object[]> lists = receiverRepository.getReceiverWithProfileCount(name);
        logger.info("==============이름으로 멤버와 프로필 출력하기================");
        lists.forEach(arr -> logger.info(Arrays.toString(arr)));
    }

    @Test
    public void getReceiverWithProfile() {
        Name name = Name.builder()
                .lastName("박")
                .firstName("영준")
                .build();

        List<Object[]> lists = receiverRepository.getReceiverWithProfile(name);
        logger.info("==============이름으로 멤버와 프로필 출력하기================");
        lists.forEach(arr -> logger.info(Arrays.toString(arr)));
    }

    @Test
    public void getAllReceiverWithProfile() {
        List<Object[]> lists = receiverRepository.getAllReceiverWithProfile();
        logger.info("==============전체 멤버와 프로필 출력하기================");
        lists.forEach(arr -> logger.info(Arrays.toString(arr)));
    }
}
