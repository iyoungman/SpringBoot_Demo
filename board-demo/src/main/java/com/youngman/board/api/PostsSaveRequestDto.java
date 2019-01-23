package com.youngman.board.api;

import com.youngman.board.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게 되는 반면
Request와 Response용 DTO는 View를 위한 클래스라 정말 자주 변경이 필요합니다.*/

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String writer;

    @Builder
    public PostsSaveRequestDto(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Posts toEntity() {
        return Posts.builder().title(title).content(content).writer(writer).build();
    }

}
