package com.youngman.pagingdemo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by youngman on 2019-01-23.
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /*
     * 다른 Package 간 호출시에는 public 을 붙여야 하지만
     * 같은 Package 이므로 default 접근 제한자
     */
    Page<Member> pageable(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    Page<Member> pageRequest(int no) {
        PageRequest pageRequest = new PageRequest(no - 1, 10, Sort.Direction.DESC, "name");

        return memberRepository.findAll(pageRequest);
    }
}
