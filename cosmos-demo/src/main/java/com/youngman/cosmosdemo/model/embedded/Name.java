package com.youngman.cosmosdemo.model.embedded;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by YoungMan on 2019-01-29.
 */

@Embeddable
@Getter
@Setter
@ToString
public class Name {
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    public Name() {
    }

    @Builder
    public Name(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getFullName() {
        return this.lastName + this.firstName;
    }

}
