package com.youngman.cosmosdemo;

import com.youngman.cosmosdemo.model.onetomany.Board;
import com.youngman.cosmosdemo.model.onetomany.File;
import com.youngman.cosmosdemo.repository.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by YoungMan on 2019-02-06.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class OneToManyTest {
    private Logger logger = LoggerFactory.getLogger(OneToManyTest.class);

    @Autowired
    private BoardRepository boardRepository;

    /*
     * 새로운 자료 등록
     * 하나의 자료와 그에 해당하는 두개의 첨부파일 저장
     */
    @Test
    public void insertBoard() {
        File file1 = File.builder()
                .fileName("첨부파일1")
                .build();

        File file2 = File.builder()
                .fileName("첨부파일2")
                .build();

        Board board = Board.builder()
                .boardName("자료1")
                .writer("글쓴이1")
                .files(Arrays.asList(file1, file2))
                .build();

        boardRepository.save(board);
    }

    @Transactional
    @Test
    public void updateFile() {
        Long fileId = 3L;
        String fileName = "첨부파일3";

        boardRepository.updateFileName(fileId, fileName);
    }

    @Transactional
    @Test
    public void deleteFile() {
        Long fileId = 3L;

        boardRepository.deleteFile(fileId);
    }

    @Test
    public void veiwSummary() {
        List<Object[]> summarys = boardRepository.getSummary();
        summarys.forEach(arr -> logger.info(Arrays.toString(arr)));
    }

}
