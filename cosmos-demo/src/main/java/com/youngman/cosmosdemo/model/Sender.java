package com.youngman.cosmosdemo.model;

import com.youngman.cosmosdemo.model.embedded.Address;
import com.youngman.cosmosdemo.model.embedded.Name;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by youngman on 2019-01-29.
 */
@Getter
@Setter
@Entity
public class Sender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "sender_city")),
            @AttributeOverride(name = "groop", column = @Column(name = "sender_groop")),
            @AttributeOverride(name = "dong", column = @Column(name = "sender_dong"))
    })
    private Address address;

    @Builder
    public Sender(Name name, Address address) {
        this.name = name;
        this.address = address;
    }
}
