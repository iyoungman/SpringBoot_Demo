package com.youngman.cosmosdemo.repository;

import com.youngman.cosmosdemo.model.Receiver;
import com.youngman.cosmosdemo.model.embedded.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by youngman on 2019-01-29.
 */
public interface ReceiverRepository extends JpaRepository<Receiver, Long> {

//    Long findIdByName(Name name);

    @Query("select r.id from Receiver r where r.name = :name")
    Long findIdByName(@Param("name") Name name);

    /*
     * Left Outer Join
     * 기준 테이블 Left Join 기준에 따라가는 테이블
     * 프로필이 없는 사람도 출력하기 위함
     */
    @Query("select r.name, count(p) from Receiver r left outer join Profile p "+
            " on r.id = p.receiver where r.name = :name group by r")
    List<Object[]> getReceiverWithProfileCount(@Param("name") Name name);

    /*
     * 현재 사용중인 프로필 출력
     * p에 null 값 허용하기 위함
     */
    @Query("select r.name, p from Receiver r left outer join Profile p " +
            " on r.id = p.receiver where r.name = :name and p.current = true")
    List<Object[]> getReceiverWithProfile(@Param("name") Name name);

    /*
     * 전체 출력
     * p에 null 값 허용하기 위함
     */
    @Query("select r.name, p from Receiver r left outer join Profile p " +
            " on r.id = p.receiver")
    List<Object[]> getAllReceiverWithProfile();

}
