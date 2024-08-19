package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.entity.Account;
import com.anastasija.MyBudgetApi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }
}
