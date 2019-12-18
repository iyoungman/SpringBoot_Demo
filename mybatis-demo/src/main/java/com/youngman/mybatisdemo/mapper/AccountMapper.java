package com.youngman.mybatisdemo.mapper;

import com.youngman.mybatisdemo.account.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YoungMan on 2019-12-11.
 */

@Mapper
@Repository
public interface AccountMapper {
	Account selectAccountById(Long id);

	List<Account> selectAccounts();

	void insertAccount(Account account);
}
