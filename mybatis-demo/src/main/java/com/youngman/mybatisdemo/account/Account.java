package com.youngman.mybatisdemo.account;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * Created by YoungMan on 2019-12-11.
 */

@Getter
@Setter
@Alias("account")
public class Account {
	private Long id;
	private String name;
	private String age;

	public Account() {
	}

	public Account(String name, String age) {
		this.name = name;
		this.age = age;
	}
}
