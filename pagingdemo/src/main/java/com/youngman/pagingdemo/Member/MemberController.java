package com.youngman.pagingdemo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngman on 2019-01-23.
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    /*
     * @RequestParam : 생략 가능
     */
    @GetMapping("/requestparam")
    public void requestParam(@RequestParam("name") String name, @RequestParam("hobby") String hobby) {
        System.out.println("이름 " + name);
        System.out.println("취미 " + hobby);
    }

    /*
     * URL : /pageable?page=0&size=10&sort=name,desc
     * 파라미터 name 이 이상할경우(page가 아닌 pa라던지..) 제대로 동작하지 않는다
     * 파라미터 : page, size, sort
     * Pageable 에 어떻게 들어가지?
     */
    @GetMapping("/pageable")
    public Page<Member> pageable(Pageable pageable) {
        return memberService.pageable(pageable);
    }

    /*
     * URL : /pagerequest/{1}
     * 내림차순 정렬
     * page, size, sort..
     */
    @GetMapping("/pagerequest/{no}")
    public Page<Member> pageRequest(@PathVariable int no) {
        return memberService.pageRequest(no);
    }

}
