package com.youngman.board.service;

import com.youngman.board.api.PostsMainResponseDto;
import com.youngman.board.api.PostsSaveRequestDto;
import com.youngman.board.domain.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
