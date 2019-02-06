package com.youngman.cosmosdemo.repository;

import com.youngman.cosmosdemo.model.onetomany.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by YoungMan on 2019-02-06.
 */

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update File file set file.fileName = :fileName where file.id = :fileId ")
    void updateFileName(@Param("fileId") Long fileId, @Param("fileName") String fileName);

    @Modifying
    @Query("delete from File file where file.id = :fileId ")
    void deleteFile(@Param("fileId") Long fileId);

    /*
     * 자료와 첨부 파일의 수 출력
     * Group by : board 별로 집계
     */
    @Query("select board, count(file) from Board board left outer join board.files file group by board")
    List<Object[]> getSummary();
}
