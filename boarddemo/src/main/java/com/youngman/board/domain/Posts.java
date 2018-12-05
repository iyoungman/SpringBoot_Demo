package com.youngman.board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //Lombok - 클래스내 모든 필드의 Getter 메소드를 자동생성
//@Table(name = "BoardDB")
@NoArgsConstructor //Lombok - 기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스임을 나타냅니다.
public class Posts extends BaseTimeEntity {

	@Id//Primary키
	@GeneratedValue(strategy= GenerationType.AUTO)//자동 생성
	private Long id;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	private String writer;

	@Builder //해당 클래스의 빌더패턴 클래스를 생성 - 생성자와 역활은 비슷하지만 어느 필드에 어떤 값을 채워야 할지
	public Posts(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

}
