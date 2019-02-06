package com.youngman.cosmosdemo.model.onetomany;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-02-06.
 */

@Getter
@Setter
@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private long id;

    @Column(name = "file_name")
    private String fileName;

    public File() {
    }

    @Builder
    public File(String fileName) {
        this.fileName = fileName;
    }
}
