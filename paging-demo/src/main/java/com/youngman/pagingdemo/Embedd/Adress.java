package com.youngman.pagingdemo.Embedd;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by youngman on 2019-01-23.
 */
@Embeddable
public class Adress {

    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "zip_code")
    private String zipCode;

    public String getFullAddress() {
        return city + street + zipCode;
    }
}
