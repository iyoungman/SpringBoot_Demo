package com.youngman.cosmosdemo.model.onetomany;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by YoungMan on 2019-02-06.
 */

@Getter
@Setter
@Entity
@ToString(exclude = "files")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private long id;

    @Column(name = "board_name")
    private String boardName;

    private String writer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "board_id")
    private List<File> files;

    public Board() {
    }

    @Builder
    public Board(String boardName, String writer, List<File> files) {
        this.boardName = boardName;
        this.writer = writer;
        this.files = files;
    }
}
