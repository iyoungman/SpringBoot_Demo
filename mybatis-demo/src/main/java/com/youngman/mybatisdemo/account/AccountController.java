package com.youngman.mybatisdemo.account;

import com.youngman.mybatisdemo.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by YoungMan on 2019-12-12.
 */

@Slf4j
@RestController
public class AccountController {

	@Autowired
	private AccountMapper accountMapper;

	@GetMapping("/id/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return accountMapper.selectAccountById(id);
	}

	@GetMapping("/list")
	public List<Account> getAccounts() {
		return accountMapper.selectAccounts();
	}

	@PostMapping
	public void saveAccount(@RequestBody Account account) {
		log.info(account.getName());
		log.info(account.getAge());

		accountMapper.insertAccount(account);
	}
}
