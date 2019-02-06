# AOP  

* 관점 지향 프로그래밍

* 비교
  + OOP : 핵심기능 모듈화  
  + AOP : 부가기능 모듈화  
  
* 주요 용어  
  + Aspect : 부가기능 모듈, 핵심기능에 부가되어 의미를 갖는 모듈, **어드바이스와 포인트컷을 갖고있다**
  + 어드바이스 : 부가기능에 대해 정의, **무엇을 언제 할지 의미**  
  + 조인포인트 : 적용될 시점(Spring에서는 메소드 조인포인트만 제공)
  + 포인트컷 : 부가기능이 적용될 대상(메소드)를 선정하는 **방법**  

***  
    
![image](https://user-images.githubusercontent.com/25604495/50534301-ff169b80-0b7d-11e9-81c9-ba32e7dfe28f.png)  
  
* 어드바이스  
  + 무엇 : calculatePerformanceTime  
  + 언제 : @Around -> 타겟 메소드 실행 전후  
* 포인트컷 표현식  
  + execution : 지정자  
  + (* com.blogcode.board.BoardService.getBoards(..)) : 타겟명세  
  
***
참고 사이트 : http://sjh836.tistory.com/157
             https://jojoldu.tistory.com/71  
