package com.youngman.pagingdemo.Member;

import com.youngman.pagingdemo.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by youngman on 2019-01-23.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

}
