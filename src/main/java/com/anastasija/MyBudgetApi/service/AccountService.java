package com.anastasija.MyBudgetApi.service;

import com.anastasija.MyBudgetApi.model.dto.AccountDTO;
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

    public Account createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setName(accountDTO.name());
        account.setBalance(accountDTO.balance());
        account.setCurrency(accountDTO.currency());

        return accountRepository.save(account);
    }
}
