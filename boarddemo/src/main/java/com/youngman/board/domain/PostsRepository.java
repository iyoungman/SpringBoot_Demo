package com.youngman.board.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    //List<Posts> findByTitleLike(String title);

    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")

    Stream<Posts> findAllDesc();
}
