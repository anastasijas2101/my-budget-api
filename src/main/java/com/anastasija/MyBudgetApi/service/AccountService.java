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

    @Autowired
    private CurrencyService currencyService;

    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }

    public Account createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setName(accountDTO.name());
        double balance = accountDTO.balance();
        account.setBalance(balance);
        String currency = accountDTO.currency();
        account.setCurrency(currency);
        account.setConvertedBalance(currencyService.convert(currency, balance, "EUR"));
        account.setConvertedCurrency("EUR");

        return accountRepository.save(account);
    }

    public double findTotalBalance() {
        Double totalBalance = accountRepository.findTotalBalance();
        return (totalBalance != null) ? totalBalance : 0.00;
    }

    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }
}
